package com.REAL_TIME.ANALYTICS.REPORTING.DASHBOARD.Reports_Service.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReportFilter {

	private String location;
	private String actionType;
	private String userAgent;
	private Long productId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
}