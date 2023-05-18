package com.devmtn30.TDD_Hexagonal.product;

import com.devmtn30.TDD_Hexagonal.DiscountPilicy;
import com.devmtn30.TDD_Hexagonal.Product;
import com.devmtn30.TDD_Hexagonal.ProductPort;
import com.devmtn30.TDD_Hexagonal.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static com.devmtn30.TDD_Hexagonal.product.ProductSteps.상품등록요청;
import static com.devmtn30.TDD_Hexagonal.product.ProductSteps.상품등록요청_생성;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void 상품수정() {
        productService.addProduct(상품등록요청_생성());
        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000, DiscountPilicy.NONE);

        productService.updateProduct(request, productId);

        ResponseEntity<GetProductResponse> response = productService.getProduct(productId);
        GetProductResponse productResponse = response.getBody();
        assertThat(productResponse.name()).isEqualTo("상품 수정");
        assertThat(productResponse.price()).isEqualTo(2000);
    }

}
