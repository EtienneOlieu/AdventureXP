package com.example.adventure.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DateDto {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
