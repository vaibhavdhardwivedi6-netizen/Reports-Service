package com.REAL_TIME.ANALYTICS.REPORTING.DASHBOARD.Reports_Service.Client;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AnalyticsClient {

    private final WebClient webClient;

    public AnalyticsClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("http://localhost:8082")
                .build();
    }

    public List<ActivityResponse> getAllActivities() {
        return webClient.get()
                .uri("/api/activities")
                .retrieve()
                .bodyToFlux(ActivityResponse.class)
                .collectList()
                .block();
    }
}