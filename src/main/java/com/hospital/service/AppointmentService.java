package com.hospital.service;

import com.hospital.dto.AppointmentDTO;
import com.hospital.model.Appointment;
import com.hospital.model.Doctor;
import com.hospital.model.Patient;
import com.hospital.model.Schedule;
import com.hospital.repository.AppointmentRepository;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.PatientRepository;
import com.hospital.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final ScheduleRepository scheduleRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              PatientRepository patientRepository,
                              DoctorRepository doctorRepository,
                              ScheduleRepository scheduleRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public Appointment createAppointment(AppointmentDTO dto) {
        Patient patient = patientRepository.findById(dto.getPatientId()).orElse(null);
        Doctor doctor = doctorRepository.findById(dto.getDoctorId()).orElse(null);
        Schedule schedule = scheduleRepository.findById(dto.getScheduleId()).orElse(null);

        if (patient == null) {
            throw new RuntimeException("Patient not found");
        }
        if (doctor == null) {
            throw new RuntimeException("Doctor not found");
        }
        if (schedule == null) {
            throw new RuntimeException("Schedule not found");
        }
        if (!schedule.getIsAvailable()) {
            throw new RuntimeException("This time slot is already booked");
        }
        schedule.setIsAvailable(false);
        scheduleRepository.save(schedule);

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setSchedule(schedule);
        appointment.setAppointmentDateTime(dto.getAppointmentDateTime());
        appointment.setStatus(dto.getStatus());
        appointment.setNotes(dto.getNotes());

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Integer id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public void deleteAppointment(Integer id) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);

        if (appointment == null) {
            return;
        }

        if (appointment.getSchedule() != null) {
            appointment.getSchedule().setAppointment(null);
            scheduleRepository.save(appointment.getSchedule());
        }

        appointmentRepository.delete(appointment);
    }
}