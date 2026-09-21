package com.REAL_TIME.ANALYTICS.REPORTING.DASHBOARD.Reports_Service.Client;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityResponse {

    private Long id;
    private UserResponse user;
    private String actionType;
    private String userAgent;
    private Long productId;
    private LocalDateTime timestamp;
}