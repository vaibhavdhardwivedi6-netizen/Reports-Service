package com.REAL_TIME.ANALYTICS.REPORTING.DASHBOARD.Reports_Service.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.REAL_TIME.ANALYTICS.REPORTING.DASHBOARD.Reports_Service.Client.ActivityResponse;
import com.REAL_TIME.ANALYTICS.REPORTING.DASHBOARD.Reports_Service.DTO.ReportFilter;
import com.REAL_TIME.ANALYTICS.REPORTING.DASHBOARD.Reports_Service.DTO.ReportSummary;
import com.REAL_TIME.ANALYTICS.REPORTING.DASHBOARD.Reports_Service.Entity.ReportsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportsController {

	private final ReportsService service;

	@GetMapping("/activities")
	public ResponseEntity<List<ActivityResponse>> getAllActivities() {
		return ResponseEntity.ok(service.getAllActivities());
	}

	@PostMapping("/filter")
	public ResponseEntity<List<ActivityResponse>> filterActivities(@RequestBody ReportFilter filter) {

		return ResponseEntity.ok(service.filterActivities(filter));
	}

	@GetMapping("/summary/actions")
	public ResponseEntity<List<ReportSummary>> getActionSummary() {

		return ResponseEntity.ok(service.getActionSummary());
	}
}