package com.saveliy.suppliersystem.suppliersystem.service;

import com.saveliy.suppliersystem.suppliersystem.exception.ResourceAlreadyExistsException;
import com.saveliy.suppliersystem.suppliersystem.repository.SupplierRepository;
import com.saveliy.suppliersystem.suppliersystem.dto.CreateSupplierDTO;
import com.saveliy.suppliersystem.suppliersystem.dto.SupplierDTO;
import com.saveliy.suppliersystem.suppliersystem.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplierServiceImplementation implements SupplierService {

    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImplementation(SupplierRepository repository) {
        this.supplierRepository = repository;
    }

    @Override
    @Transactional
    public SupplierDTO addSupplier(CreateSupplierDTO supplierDTO) {
        try {
            return SupplierMapper.INSTANCE.SupplierToSupplierDTO(
                    supplierRepository.saveAndFlush(
                            SupplierMapper.INSTANCE.CreateSupplierToSupplier(supplierDTO)
                    )
            );
        } catch (DataIntegrityViolationException e) {
            throw new ResourceAlreadyExistsException("Supplier already exists");
        }
    }

    @Override
    @Transactional
    public List<SupplierDTO> getAllSuppliers() {
        return SupplierMapper.INSTANCE.SupplierListToSupplierDTOList(supplierRepository.findAll());
    }
}
