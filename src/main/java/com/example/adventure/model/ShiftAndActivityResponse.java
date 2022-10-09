package com.example.adventure.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShiftAndActivityResponse {

    private Long shiftId;
    private String employeeName;
    private String startTimeString;
    private String endTimeString;
    private String activityDescription;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime startTime;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime  endTime;
}
