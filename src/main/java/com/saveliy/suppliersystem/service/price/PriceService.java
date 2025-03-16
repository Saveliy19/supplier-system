package com.saveliy.suppliersystem.service.price;

import com.saveliy.suppliersystem.dto.price.CreatePriceDTO;
import com.saveliy.suppliersystem.dto.price.PriceDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface PriceService {
    PriceDTO createPrice(CreatePriceDTO priceDTO);

    List<PriceDTO> getProductPricesByDate(int productId, LocalDate localDate);

    List<PriceDTO> getSupplierPricesByDate(int supplierId, LocalDate localDate);
}
