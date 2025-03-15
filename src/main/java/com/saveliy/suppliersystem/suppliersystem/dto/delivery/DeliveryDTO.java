package com.saveliy.suppliersystem.suppliersystem.dto.delivery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DeliveryDTO {
    private int id;
    private int supplierId;
    private List<DeliveryItemDTO> deliveryItems;
}
