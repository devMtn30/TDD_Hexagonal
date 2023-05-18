package com.devmtn30.TDD_Hexagonal.product;

import com.devmtn30.TDD_Hexagonal.ApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.devmtn30.TDD_Hexagonal.product.ProductSteps.*;
import static org.assertj.core.api.Assertions.assertThat;

class ProductApiTest extends ApiTest {


    @Test
    void 상품등록() {
        final var request = 상품등록요청_생성();

        final var response = 상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void 상품조회() {
        상품등록요청(상품등록요청_생성());
        Long productId = 1L;

        var response = 상품조회요청(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    }

}

