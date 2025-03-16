package com.saveliy.suppliersystem.suppliersystem.service.report;

import com.saveliy.suppliersystem.suppliersystem.dto.report.ReportDTO;

import java.time.LocalDate;

public interface ReportService {
    ReportDTO getReport(LocalDate startDate, LocalDate endDate);
}
