package com.REAL_TIME.ANALYTICS.REPORTING.DASHBOARD.Reports_Service.Entity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.REAL_TIME.ANALYTICS.REPORTING.DASHBOARD.Reports_Service.Client.ActivityResponse;
import com.REAL_TIME.ANALYTICS.REPORTING.DASHBOARD.Reports_Service.Client.AnalyticsClient;
import com.REAL_TIME.ANALYTICS.REPORTING.DASHBOARD.Reports_Service.DTO.ReportFilter;
import com.REAL_TIME.ANALYTICS.REPORTING.DASHBOARD.Reports_Service.DTO.ReportSummary;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportsService {

    private final AnalyticsClient analyticsClient;

   
    public List<ActivityResponse> getAllActivities() {
        return analyticsClient.getAllActivities();
    }

    public List<ActivityResponse> filterActivities(ReportFilter filter) {

        return analyticsClient.getAllActivities()
                .stream()
                .filter(activity ->
                        filter.getLocation() == null ||
                        (activity.getUser() != null &&
                         activity.getUser().getLocation() != null &&
                         activity.getUser().getLocation()
                                .equalsIgnoreCase(filter.getLocation())))
                .filter(activity ->
                        filter.getActionType() == null ||
                        activity.getActionType()
                                .equalsIgnoreCase(filter.getActionType()))
                .filter(activity ->
                        filter.getUserAgent() == null ||
                        activity.getUserAgent()
                                .equalsIgnoreCase(filter.getUserAgent()))
                .filter(activity ->
                        filter.getProductId() == null ||
                        filter.getProductId().equals(activity.getProductId()))
                .filter(activity ->
                        filter.getStartDate() == null ||
                        !activity.getTimestamp().isBefore(filter.getStartDate()))
                .filter(activity ->
                        filter.getEndDate() == null ||
                        !activity.getTimestamp().isAfter(filter.getEndDate()))
                .toList();
    }

    public List<ReportSummary> getActionSummary() {

        Map<String, Long> result = analyticsClient.getAllActivities()
                .stream()
                .collect(Collectors.groupingBy(
                        ActivityResponse::getActionType,
                        Collectors.counting()
                ));

        return result.entrySet()
                .stream()
                .map(entry ->
                        new ReportSummary(
                                entry.getKey(),
                                entry.getValue()
                        ))
                .toList();
    }
}