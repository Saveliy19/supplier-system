package com.saveliy.suppliersystem.suppliersystem.mapper;

import com.saveliy.suppliersystem.suppliersystem.dto.CreateSupplierDTO;
import com.saveliy.suppliersystem.suppliersystem.dto.SupplierDTO;
import com.saveliy.suppliersystem.suppliersystem.entity.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SupplierMapper {
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    Supplier CreateSupplierToSupplier(CreateSupplierDTO createSupplierDTO);
    SupplierDTO SupplierToSupplierDTO(Supplier supplier);
    List<SupplierDTO> SupplierListToSupplierDTOList(List<Supplier> suppliers);
}
