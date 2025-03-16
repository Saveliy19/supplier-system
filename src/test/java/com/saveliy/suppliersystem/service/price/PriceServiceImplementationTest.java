package com.saveliy.suppliersystem.service.price;

import com.saveliy.suppliersystem.dto.price.CreatePriceDTO;
import com.saveliy.suppliersystem.dto.price.PriceDTO;
import com.saveliy.suppliersystem.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class PriceServiceImplementationTest {

    private CreatePriceDTO priceDTO;

    @Autowired
    private PriceService priceService;


    @BeforeEach
    void setUp() {
        priceDTO = new CreatePriceDTO(
                100.0, LocalDate.now(), LocalDate.now().plusDays(2),
                1, 6
        );
    }

    @Test
    void createPrice() {
        PriceDTO price = priceService.createPrice(priceDTO);

        assertNotNull(price);
        assertEquals(price.productId(), priceDTO.productId());
        assertEquals(price.price(), priceDTO.price());
        assertEquals(price.startDate(), priceDTO.startDate());
        assertEquals(price.endDate(), priceDTO.endDate());
    }

    @Test
    void getProductPricesByDate() {
        List<PriceDTO> pricesBefore = priceService.getProductPricesByDate(6, LocalDate.now());

        PriceDTO price = priceService.createPrice(priceDTO);

        List<PriceDTO> pricesAfter = priceService.getProductPricesByDate(6, LocalDate.now());

        assertNotNull(pricesAfter);
        assertFalse(pricesAfter.isEmpty());
        assertEquals(pricesAfter.size(), pricesBefore.size() + 1);

    }

    @Test
    void getSupplierPricesByDate() {
        List<PriceDTO> pricesBefore = priceService.getSupplierPricesByDate(1, LocalDate.now());
        PriceDTO price = priceService.createPrice(priceDTO);
        List<PriceDTO> pricesAfter = priceService.getSupplierPricesByDate(1, LocalDate.now());

        assertNotNull(pricesAfter);
        assertFalse(pricesAfter.isEmpty());
        assertEquals(pricesAfter.size(), pricesBefore.size() + 1);
    }
}