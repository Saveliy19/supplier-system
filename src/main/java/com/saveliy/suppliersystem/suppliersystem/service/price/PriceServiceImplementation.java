package com.saveliy.suppliersystem.suppliersystem.service.price;

import com.saveliy.suppliersystem.suppliersystem.dto.price.CreatePriceDTO;
import com.saveliy.suppliersystem.suppliersystem.dto.price.PriceDTO;
import com.saveliy.suppliersystem.suppliersystem.exception.OverlappingPriceException;
import com.saveliy.suppliersystem.suppliersystem.mapper.PriceMapper;
import com.saveliy.suppliersystem.suppliersystem.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PriceServiceImplementation implements PriceService {

    private final PriceRepository priceRepository;

    @Autowired
    public PriceServiceImplementation(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    @Transactional
    public PriceDTO createPrice(CreatePriceDTO priceDTO) {
        List<PriceDTO> conflicts = PriceMapper.INSTANCE.PriceListToPriceDTOList(
                priceRepository.findOverlappingPrices(
                        priceDTO.productId(),
                        priceDTO.supplierId(),
                        priceDTO.startDate(),
                        priceDTO.endDate()
                ));
        if (!conflicts.isEmpty()) {throw new OverlappingPriceException(conflicts);
        }
        return PriceMapper.INSTANCE.PriceToPriceDTO(priceRepository.saveAndFlush(
                PriceMapper.INSTANCE.CreatePriceDTOtoPrice(priceDTO)
        ));
    }

    @Override
    @Transactional
    public List<PriceDTO> getProductPricesByDate(int productId, LocalDate localDate) {
        return PriceMapper.INSTANCE.PriceListToPriceDTOList(
                priceRepository.findAllByProductIdAndDateBetween(productId, localDate)
        );
    }

    @Override
    @Transactional
    public List<PriceDTO> getSupplierPricesByDate(int supplierId, LocalDate localDate) {
        return PriceMapper.INSTANCE.PriceListToPriceDTOList(
                priceRepository.findAllBySupplierIdAndDateBetween(supplierId, localDate)
        );
    }
}
