package com.example.ports.out;

import java.util.Map;

public interface StockReportOutPort {
    void saveReport(Map<String, String> report);
}
