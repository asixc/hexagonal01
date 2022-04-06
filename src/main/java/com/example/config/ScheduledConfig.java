package com.example.config;

import com.example.adapters.in.cron.StockReportJob;
import com.example.ports.in.StockReportInPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@Configuration
public class ScheduledConfig {

    @Bean
    public StockReportJob stockReporterJob(StockReportInPort stockReportInPort) {
        return new StockReportJob(stockReportInPort);
    }
}
