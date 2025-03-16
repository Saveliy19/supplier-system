package com.saveliy.suppliersystem.service.product;

import com.saveliy.suppliersystem.dto.product.CreateProductDTO;
import com.saveliy.suppliersystem.dto.product.ProductDTO;
import com.saveliy.suppliersystem.dto.supplier.CreateSupplierDTO;
import com.saveliy.suppliersystem.dto.supplier.SupplierDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class ProductServiceImplementationTest {

    @Autowired
    private ProductService productService;

    @Test
    void findAllProducts() {
        List<ProductDTO> products = productService.findAllProducts();
        assertNotNull(products);
        assertTrue(products.size() >= 0);
    }

    @Test
    void addProduct() {
        List<ProductDTO> productsBefore = productService.findAllProducts();
        ProductDTO newProduct = productService.addProduct(new CreateProductDTO("New product"));
        List<ProductDTO> productsAfter = productService.findAllProducts();

        assertNotNull(newProduct);
        assertEquals(newProduct.name(), "New product");
        assertEquals(productsBefore.size() + 1, productsAfter.size());
    }
}