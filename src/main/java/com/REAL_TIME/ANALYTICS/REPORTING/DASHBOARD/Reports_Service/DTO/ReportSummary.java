package com.REAL_TIME.ANALYTICS.REPORTING.DASHBOARD.Reports_Service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportSummary {

	private String actionType;
	private Long totalCount;
}