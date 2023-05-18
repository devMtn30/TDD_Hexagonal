package com.devmtn30.TDD_Hexagonal.product;

import com.devmtn30.TDD_Hexagonal.DiscountPilicy;
import com.devmtn30.TDD_Hexagonal.Product;
import com.devmtn30.TDD_Hexagonal.ProductPort;
import com.devmtn30.TDD_Hexagonal.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductServiceTest {


    private ProductService productService;

    private ProductPort productPort;

    @BeforeEach
    void setUp() {
        productPort = Mockito.mock(ProductPort.class);
        productService = new ProductService(productPort);
    }

    @Test
    void 상품수정() {

        final Long request = 1L;
        final UpdateProductRequest productId = new UpdateProductRequest("상품 수정", 2000, DiscountPilicy.NONE);
        final Product product = new Product("상품명", 1000, DiscountPilicy.NONE);
        Mockito.when(productPort.getProduct(1L)).thenReturn(product);

        productService.updateProduct(productId, request);

        assertThat(product.getName()).isEqualTo("상품 수정");
        assertThat(product.getPrice()).isEqualTo(2000);
    }

}
