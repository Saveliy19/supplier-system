package com.saveliy.suppliersystem.service.report;

import com.saveliy.suppliersystem.dto.report.ProductReportDTO;
import com.saveliy.suppliersystem.dto.report.ReportDTO;
import com.saveliy.suppliersystem.dto.report.SupplierReportDTO;
import com.saveliy.suppliersystem.entity.dto.SupplierProductSummary;
import com.saveliy.suppliersystem.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportServiceImplementation implements ReportService {

    private final DeliveryRepository deliveryRepository;

    @Autowired
    public ReportServiceImplementation(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    @Transactional
    public ReportDTO getReport(LocalDate startDate, LocalDate endDate) {
        List<SupplierProductSummary> results = deliveryRepository.getSupplierProductWeightsAndCosts(startDate, endDate);

        Map<Integer, SupplierReportDTO> supplierMap = results.stream()
                .collect(Collectors.groupingBy(
                        SupplierProductSummary::getSupplierId,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    // Первый элемент в группе (для supplierId и supplierName)
                                    SupplierProductSummary first = list.get(0);

                                    // Создаем SupplierReportDTO
                                    SupplierReportDTO supplierDTO = new SupplierReportDTO();
                                    supplierDTO.setId(first.getSupplierId());
                                    supplierDTO.setName(first.getSupplierName());

                                    // Вычисляем общий вес и стоимость для поставщика
                                    supplierDTO.setTotalWeight(list.stream()
                                            .mapToDouble(SupplierProductSummary::getTotalWeight)
                                            .sum());
                                    supplierDTO.setTotalPrice(list.stream()
                                            .mapToDouble(SupplierProductSummary::getTotalCost)
                                            .sum());

                                    // Преобразуем продукты в ProductReportDTO
                                    supplierDTO.setProducts(list.stream()
                                            .map(summary -> {
                                                ProductReportDTO productDTO = new ProductReportDTO();
                                                productDTO.setId(summary.getProductId());
                                                productDTO.setName(summary.getProductName());
                                                productDTO.setWeight(summary.getTotalWeight());
                                                productDTO.setPrice(summary.getTotalCost());
                                                return productDTO;
                                            })
                                            .collect(Collectors.toList()));

                                    return supplierDTO;
                                }
                        )
                ));

        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setStartDate(startDate);
        reportDTO.setEndDate(endDate);
        reportDTO.setSuppliers(new ArrayList<>(supplierMap.values()));

        return reportDTO;
    }

}
