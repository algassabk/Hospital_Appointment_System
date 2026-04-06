package com.hospital.service;

import com.hospital.dto.ScheduleDTO;
import com.hospital.model.Doctor;
import com.hospital.model.Schedule;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final DoctorRepository doctorRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, DoctorRepository doctorRepository) {
        this.scheduleRepository = scheduleRepository;
        this.doctorRepository = doctorRepository;
    }

    public Schedule createSchedule(ScheduleDTO scheduleDTO) {
        Doctor doctor = doctorRepository.findById(scheduleDTO.getDoctorId()).orElse(null);

        if (doctor == null) {
            return null;
        }

        Schedule schedule = new Schedule();
        schedule.setDoctor(doctor);
        schedule.setAvailableDate(scheduleDTO.getAvailableDate());
        schedule.setStartTime(scheduleDTO.getStartTime());
        schedule.setEndTime(scheduleDTO.getEndTime());
        schedule.setIsAvailable(scheduleDTO.getIsAvailable());

        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule getScheduleById(Integer id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    public Schedule updateSchedule(Integer id, ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleRepository.findById(id).orElse(null);
        Doctor doctor = doctorRepository.findById(scheduleDTO.getDoctorId()).orElse(null);

        if (schedule == null || doctor == null) {
            return null;
        }

        schedule.setDoctor(doctor);
        schedule.setAvailableDate(scheduleDTO.getAvailableDate());
        schedule.setStartTime(scheduleDTO.getStartTime());
        schedule.setEndTime(scheduleDTO.getEndTime());
        schedule.setIsAvailable(scheduleDTO.getIsAvailable());

        return scheduleRepository.save(schedule);
    }

    public void deleteSchedule(Integer id) {
        scheduleRepository.deleteById(id);
    }
}