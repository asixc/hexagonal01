package com.example.adapters.in.cron;

import com.example.ports.in.StockReportInPort;
import org.springframework.scheduling.annotation.Scheduled;

public class StockReportJob {

    private final StockReportInPort stockReportInPort;

    public StockReportJob(StockReportInPort stockReportInPort) {
        this.stockReportInPort = stockReportInPort;
    }

    @Scheduled(cron = "0/5 * * * * *")
    public void generateDailyReport(){
        System.out.println("Generando reporte");
        this.stockReportInPort.generateDailyReport();
    }

}
