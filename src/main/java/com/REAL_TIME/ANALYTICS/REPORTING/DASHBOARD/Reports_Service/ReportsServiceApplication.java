package com.REAL_TIME.ANALYTICS.REPORTING.DASHBOARD.Reports_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
public class ReportsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportsServiceApplication.class, args);
	}

}
