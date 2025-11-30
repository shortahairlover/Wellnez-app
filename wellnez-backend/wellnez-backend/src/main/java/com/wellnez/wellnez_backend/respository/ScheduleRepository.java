package com.wellnez.wellnez_backend.respository;

import com.wellnez.wellnez_backend.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
