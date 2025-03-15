package com.saveliy.suppliersystem.suppliersystem.service.delivery;

import com.saveliy.suppliersystem.suppliersystem.dto.delivery.*;
import com.saveliy.suppliersystem.suppliersystem.entity.Delivery;
import com.saveliy.suppliersystem.suppliersystem.entity.DeliveryItem;
import com.saveliy.suppliersystem.suppliersystem.entity.Price;
import com.saveliy.suppliersystem.suppliersystem.exception.ResourceNotExistsException;
import com.saveliy.suppliersystem.suppliersystem.mapper.DeliveryMapper;
import com.saveliy.suppliersystem.suppliersystem.repository.DeliveryRepository;
import com.saveliy.suppliersystem.suppliersystem.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryServiceImplementation implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final PriceRepository priceRepository;

    @Autowired
    public DeliveryServiceImplementation(DeliveryRepository deliveryRepository, PriceRepository priceRepository) {
        this.deliveryRepository = deliveryRepository;
        this.priceRepository = priceRepository;
    }


    @Override
    @Transactional
    public DeliveryDTO createDelivery(CreateDeliveryDTO deliveryDTO) {
        Delivery delivery = new Delivery();
        delivery.setDeliveryDate(LocalDate.now());
        deliveryRepository.saveAndFlush(delivery);
        List<DeliveryItem> deliveryItems = new ArrayList<>();
        for (CreateDeliveryItemDTO item : deliveryDTO.deliveryItems()) {
            Price price = priceRepository.findByProductIdAndSupplierIdAndDate(
                    item.productId(), deliveryDTO.supplierId(), LocalDate.now());
            if (price == null) {
                throw new ResourceNotExistsException("The supplier " + deliveryDTO.supplierId() +
                        " has not set the cost of the product " + item.productId() + " as of the current date");
            }

            DeliveryItem deliveryItem = new DeliveryItem();
            deliveryItem.setDelivery(delivery);
            deliveryItem.setWeight(item.weight());
            deliveryItem.setPrice(price);
            deliveryItems.add(deliveryItem);
        }
        delivery.setDeliveryItems(deliveryItems);
        DeliveryDTO result =DeliveryMapper.INSTANCE.DeliverytoDeliveryDTO(deliveryRepository.saveAndFlush(delivery));
        result.setSupplierId(deliveryDTO.supplierId());
        return result;
    }

    @Override
    public void validateProductsUnique(CreateDeliveryDTO deliveryDTO) {
        boolean hasDuplicates = deliveryDTO.deliveryItems().stream()
                .map(CreateDeliveryItemDTO::productId)
                .distinct()
                .count() != deliveryDTO.deliveryItems().size();

        if (hasDuplicates) {
            throw new IllegalArgumentException("There are several products with the same Id in the list.");
        }
    }
}
