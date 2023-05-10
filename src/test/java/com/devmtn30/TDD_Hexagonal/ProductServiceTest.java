package com.devmtn30.TDD_Hexagonal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    private ProductService prodctService;
    private ProductPort productPort;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
        productPort = new ProductAdapter(productRepository);
        prodctService = new ProductService(productPort);
    }

    @Test
    void 상품등록() {
        final AddProductRequest request = 상품등록요청_생성();
        prodctService.addProduct(request);
    }

    private AddProductRequest 상품등록요청_생성() {
        final String name = "상품명";
        final int price = 1000;
        DiscountPilicy discountPilicy = DiscountPilicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPilicy);
        return request;
    }

}

