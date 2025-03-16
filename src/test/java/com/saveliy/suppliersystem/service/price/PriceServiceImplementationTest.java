package com.saveliy.suppliersystem.service.price;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class PriceServiceImplementationTest {

    @Autowired
    private PriceService priceService;

    @Test
    void createPrice() {
    }

    @Test
    void getProductPricesByDate() {
    }

    @Test
    void getSupplierPricesByDate() {
    }
}