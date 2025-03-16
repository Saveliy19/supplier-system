package com.saveliy.suppliersystem.service.report;

import com.saveliy.suppliersystem.dto.report.ReportDTO;
import com.saveliy.suppliersystem.dto.report.SupplierReportDTO;
import com.saveliy.suppliersystem.entity.dto.SupplierProductSummary;
import com.saveliy.suppliersystem.repository.DeliveryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Используем расширение для Mockito
class ReportServiceImplementationTest {

    @Mock
    private DeliveryRepository deliveryRepository; // Мокаем репозиторий

    @InjectMocks
    private ReportServiceImplementation reportService; // Сервис, который тестируем

    private LocalDate startDate;
    private LocalDate endDate;

    @BeforeEach
    void setUp() {
        startDate = LocalDate.of(2025, 3, 1);
        endDate = LocalDate.of(2025, 3, 31);
    }

    @Test
    void getReport() {
        List<SupplierProductSummary> testData = List.of(
                new SupplierProductSummary(1, "Supplier A", 1, "Product X", 100.0, 200.0),
                new SupplierProductSummary(1, "Supplier A", 2, "Product Y", 50.0, 100.0),
                new SupplierProductSummary(2, "Supplier B", 3, "Product Z", 200.0, 400.0)
        );

        when(deliveryRepository.getSupplierProductWeightsAndCosts(startDate, endDate)).thenReturn(testData);

        ReportDTO report = reportService.getReport(startDate, endDate);

        assertNotNull(report);
        assertEquals(startDate, report.getStartDate());
        assertEquals(endDate, report.getEndDate());
        assertEquals(2, report.getSuppliers().size());

        SupplierReportDTO supplierA = report.getSuppliers().get(0);
        assertEquals(1, supplierA.getId());
        assertEquals("Supplier A", supplierA.getName());
        assertEquals(150.0, supplierA.getTotalWeight());
        assertEquals(300.0, supplierA.getTotalPrice());
        assertEquals(2, supplierA.getProducts().size());

        SupplierReportDTO supplierB = report.getSuppliers().get(1);
        assertEquals(2, supplierB.getId());
        assertEquals("Supplier B", supplierB.getName());
        assertEquals(200.0, supplierB.getTotalWeight());
        assertEquals(400.0, supplierB.getTotalPrice());
        assertEquals(1, supplierB.getProducts().size());
    }
}