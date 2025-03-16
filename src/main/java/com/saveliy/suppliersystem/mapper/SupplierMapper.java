package com.saveliy.suppliersystem.mapper;

import com.saveliy.suppliersystem.dto.supplier.CreateSupplierDTO;
import com.saveliy.suppliersystem.dto.supplier.SupplierDTO;
import com.saveliy.suppliersystem.entity.Supplier;
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
