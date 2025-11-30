package com.wellnez.wellnez_backend.controller;

import com.wellnez.wellnez_backend.dto.ScheduleRequest;
import com.wellnez.wellnez_backend.model.Schedule;
import com.wellnez.wellnez_backend.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@CrossOrigin(origins = "http://localhost:3000")
public class ScheduleController {

    private final ScheduleService service;

    public ScheduleController(ScheduleService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping("/add")
    public Schedule add(@RequestBody ScheduleRequest req) {
        return service.addSchedule(req);
    }

    // READ ALL
    @GetMapping("/all")
    public List<Schedule> getAll() {
        return service.getAll();
    }

    // UPDATE
   @PutMapping("/update/{id}")
public Schedule update(
        @PathVariable("id") Long id, 
        @RequestBody ScheduleRequest req
) {
    return service.updateSchedule(id, req);
}


    // DELETE
    @DeleteMapping("/delete/{id}")
public void delete(@PathVariable("id") Long id) {
    service.deleteSchedule(id);
}

}