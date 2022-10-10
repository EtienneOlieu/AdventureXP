package com.example.adventure.service;

import com.example.adventure.model.Shift;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;


public interface ShiftService extends CrudService<Shift, Long> {

    Set<Shift> getActivityByDate(LocalDateTime startTime, LocalDateTime endTime);
}
