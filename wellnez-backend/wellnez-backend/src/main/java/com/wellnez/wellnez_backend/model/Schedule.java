package com.wellnez.wellnez_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long scheduleId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "schedule_name")
    private String scheduleName;

    @Column(name = "schedule_description")
    private String scheduleDescription;

    @Column(name = "schedule_time")
    private LocalDateTime scheduleTime;

    @Column(name = "schedule_type")
    private String scheduleType;

    public Schedule() {}

    public Schedule(Long userId, String scheduleName, String scheduleDescription,
                    LocalDateTime scheduleTime, String scheduleType) {
        this.userId = userId;
        this.scheduleName = scheduleName;
        this.scheduleDescription = scheduleDescription;
        this.scheduleTime = scheduleTime;
        this.scheduleType = scheduleType;
    }

    public Long getScheduleId() { return scheduleId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getScheduleName() { return scheduleName; }
    public void setScheduleName(String scheduleName) { this.scheduleName = scheduleName; }

    public String getScheduleDescription() { return scheduleDescription; }
    public void setScheduleDescription(String scheduleDescription) { this.scheduleDescription = scheduleDescription; }

    public LocalDateTime getScheduleTime() { return scheduleTime; }
    public void setScheduleTime(LocalDateTime scheduleTime) { this.scheduleTime = scheduleTime; }

    public String getScheduleType() { return scheduleType; }
    public void setScheduleType(String scheduleType) { this.scheduleType = scheduleType; }
}
