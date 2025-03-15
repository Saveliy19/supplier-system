package com.saveliy.suppliersystem.suppliersystem.service.price;

import com.saveliy.suppliersystem.suppliersystem.dto.price.CreatePriceDTO;
import com.saveliy.suppliersystem.suppliersystem.dto.price.PriceDTO;
import org.springframework.stereotype.Service;

@Service
public interface PriceService {
    PriceDTO createPrice(CreatePriceDTO priceDTO);
}
