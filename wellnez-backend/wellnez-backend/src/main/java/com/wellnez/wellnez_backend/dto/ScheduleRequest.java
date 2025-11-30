package com.wellnez.wellnez_backend.dto;

public class ScheduleRequest {
    private Long userId;
    private String scheduleName;
    private String scheduleDescription;
    private String scheduleTime;   
    private String scheduleType;

    public void setUserId(Long userId) { this.userId = userId; }
    public void setScheduleName(String scheduleName) { this.scheduleName = scheduleName; }
    public void setScheduleDescription(String scheduleDescription) { this.scheduleDescription = scheduleDescription; }
    public void setScheduleTime(String scheduleTime) { this.scheduleTime = scheduleTime; }
    public void setScheduleType(String scheduleType) { this.scheduleType = scheduleType; }

    public Long getUserId() { return userId; }
    public String getScheduleName() { return scheduleName; }
    public String getScheduleDescription() { return scheduleDescription; }
    public String getScheduleTime() { return scheduleTime; }
    public String getScheduleType() { return scheduleType; }
}
