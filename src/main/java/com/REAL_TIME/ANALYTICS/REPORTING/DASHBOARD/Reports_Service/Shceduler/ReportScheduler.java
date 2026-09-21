package com.REAL_TIME.ANALYTICS.REPORTING.DASHBOARD.Reports_Service.Shceduler;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.REAL_TIME.ANALYTICS.REPORTING.DASHBOARD.Reports_Service.DTO.ReportSummary;
import com.REAL_TIME.ANALYTICS.REPORTING.DASHBOARD.Reports_Service.Entity.ReportsService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReportScheduler {

	private final ReportsService reportService;

	@Scheduled(fixedRate = 60000)
	public void generateReport() {

		List<ReportSummary> summary = reportService.getActionSummary();

		System.out.println("Scheduled Report: " + summary);
	}
}