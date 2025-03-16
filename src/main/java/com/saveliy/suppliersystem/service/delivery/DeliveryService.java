package com.saveliy.suppliersystem.service.delivery;

import com.saveliy.suppliersystem.dto.delivery.CreateDeliveryDTO;
import com.saveliy.suppliersystem.dto.delivery.DeliveryDTO;

public interface DeliveryService {
    public DeliveryDTO createDelivery(CreateDeliveryDTO deliveryDTO);

    public void validateProductsUnique(CreateDeliveryDTO deliveryDTO);
}
