package com.example.adventure.repository;

import com.example.adventure.model.Shift;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

public interface ShiftRepository extends CrudRepository<Shift, Long> {

    //@Query("SELECT s FROM Shift WHERE s.startTime between '2017-02-16 **00:00:00.000**' and '2017-12-16 **23:59:00.999**'")
    @Query(value = "SELECT s FROM Shift s WHERE s.startTime > ?1 AND s.endTime < ?2")
    Set<Shift> getActivityByDate(LocalDateTime startTime, LocalDateTime endTime);
}
