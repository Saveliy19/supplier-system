package com.saveliy.suppliersystem.suppliersystem.controller;

import com.saveliy.suppliersystem.suppliersystem.dto.report.ReportDTO;
import com.saveliy.suppliersystem.suppliersystem.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public ResponseEntity<ReportDTO> getReport(
            @RequestParam(name = "startDate", required = true) LocalDate startDate,
            @RequestParam(name = "endDate", required = true) LocalDate endDate) {
        return ResponseEntity.ok().body(reportService.getReport(startDate, endDate));
    }

}
