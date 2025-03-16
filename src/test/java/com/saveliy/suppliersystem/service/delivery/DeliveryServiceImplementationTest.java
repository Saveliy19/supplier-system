package com.saveliy.suppliersystem.service.delivery;

import com.saveliy.suppliersystem.dto.delivery.CreateDeliveryDTO;
import com.saveliy.suppliersystem.dto.delivery.CreateDeliveryItemDTO;
import com.saveliy.suppliersystem.dto.delivery.DeliveryDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class DeliveryServiceImplementationTest {

    private List<CreateDeliveryItemDTO> items;

    @Autowired
    private DeliveryService deliveryService;

    @BeforeEach
    void setUp() {
        items = new ArrayList<>();
        items.add(new CreateDeliveryItemDTO(6, 50));
        items.add(new CreateDeliveryItemDTO(8, 100));
    }

    @Test
    void createDelivery() {
        DeliveryDTO deliveryDTO = deliveryService.createDelivery(new CreateDeliveryDTO(1, items));
        assertNotNull(deliveryDTO);
        assertEquals(deliveryDTO.getSupplierId(), 1);
        assertEquals(deliveryDTO.getDeliveryItems().size(), 2);
        assertEquals(deliveryDTO.getDeliveryItems().get(0).productId(), 6);
        assertEquals(deliveryDTO.getDeliveryItems().get(1).productId(), 8);
    }

    @Test
    void validateProductsUnique() {
        CreateDeliveryDTO createDeliveryDTO = new CreateDeliveryDTO(1,
                items);
        deliveryService.validateProductsUnique(createDeliveryDTO);
        items.add(new CreateDeliveryItemDTO(6, 50));
        assertThrows(IllegalArgumentException.class, () -> deliveryService.validateProductsUnique(createDeliveryDTO));
    }
}