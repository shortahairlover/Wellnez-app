package com.wellnez.wellnez_backend.service;

import com.wellnez.wellnez_backend.dto.ScheduleRequest;
import com.wellnez.wellnez_backend.model.Schedule;
import com.wellnez.wellnez_backend.respository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository repo;

    public ScheduleService(ScheduleRepository repo) {
        this.repo = repo;
    }

    // helper: parse string ke LocalDateTime
    private LocalDateTime parseTime(String s) {
        if (s == null || s.isBlank()) return null;
        s = s.trim();

        // kalau sudah pakai T (2025-01-04T09:30:00)
        if (s.contains("T")) {
            return LocalDateTime.parse(s);
        }

        // 2025-01-04 09:30
        if (s.length() == 16) {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return LocalDateTime.parse(s, f);
        }

        // 2025-01-04 09:30:00
        if (s.length() == 19) {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return LocalDateTime.parse(s, f);
        }

        // fallback
        return LocalDateTime.parse(s);
    }

    // CREATE
    public Schedule addSchedule(ScheduleRequest req) {
        LocalDateTime time = parseTime(req.getScheduleTime());

        Schedule s = new Schedule(
                req.getUserId(),
                req.getScheduleName(),
                req.getScheduleDescription(),
                time,
                req.getScheduleType()
        );

        return repo.save(s);
    }

    // READ ALL
    public List<Schedule> getAll() {
        return repo.findAll();
    }

    // UPDATE
    public Schedule updateSchedule(Long id, ScheduleRequest req) {

        Schedule s = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        s.setUserId(req.getUserId());
        s.setScheduleName(req.getScheduleName());
        s.setScheduleDescription(req.getScheduleDescription());
        s.setScheduleType(req.getScheduleType());
        s.setScheduleTime(parseTime(req.getScheduleTime()));

        return repo.save(s);
    }

    // DELETE
    public void deleteSchedule(Long id) {
        repo.deleteById(id);
    }
}
