package com.devmtn30.TDD_Hexagonal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService prodctService;

    @Test
    void 상품등록() {
        final AddProductRequest request = 상품등록요청_생성();
        prodctService.addProduct(request);
    }

    private static AddProductRequest 상품등록요청_생성() {
        final String name = "상품명";
        final int price = 1000;
        DiscountPilicy discountPilicy = DiscountPilicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPilicy);
        return request;
    }

}

