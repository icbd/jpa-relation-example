package com.example.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorDto {
    private LocalDateTime timestamp;
    private Integer code;
    private String message;
}
