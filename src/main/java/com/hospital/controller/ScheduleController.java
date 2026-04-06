package com.hospital.controller;

import com.hospital.dto.ScheduleDTO;
import com.hospital.model.Schedule;
import com.hospital.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public Schedule createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.createSchedule(scheduleDTO);
    }

    @GetMapping
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public Schedule getScheduleById(@PathVariable Integer id) {
        return scheduleService.getScheduleById(id);
    }

    @PutMapping("/{id}")
    public Schedule updateSchedule(@PathVariable Integer id, @RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.updateSchedule(id, scheduleDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Integer id) {
        scheduleService.deleteSchedule(id);
    }
}