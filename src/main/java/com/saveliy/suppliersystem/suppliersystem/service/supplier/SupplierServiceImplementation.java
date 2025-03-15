package com.saveliy.suppliersystem.suppliersystem.service.supplier;

import com.saveliy.suppliersystem.suppliersystem.repository.SupplierRepository;
import com.saveliy.suppliersystem.suppliersystem.dto.supplier.CreateSupplierDTO;
import com.saveliy.suppliersystem.suppliersystem.dto.supplier.SupplierDTO;
import com.saveliy.suppliersystem.suppliersystem.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplierServiceImplementation implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImplementation(SupplierRepository repository) {
        this.supplierRepository = repository;
    }

    @Override
    @Transactional
    public SupplierDTO addSupplier(CreateSupplierDTO supplierDTO) {
        return SupplierMapper.INSTANCE.SupplierToSupplierDTO(
                supplierRepository.saveAndFlush(
                        SupplierMapper.INSTANCE.CreateSupplierToSupplier(supplierDTO)));
    }

    @Override
    @Transactional
    public List<SupplierDTO> getAllSuppliers() {
        return SupplierMapper.INSTANCE.SupplierListToSupplierDTOList(supplierRepository.findAll());
    }
}
