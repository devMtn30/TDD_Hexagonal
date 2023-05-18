package com.devmtn30.TDD_Hexagonal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void update() {
        Product product = new Product("상품명", 1000, DiscountPilicy.NONE);
        product.update("상품수정", 2000 , DiscountPilicy.NONE);

        assertThat(product.getName()).isEqualTo("상품수정");
        assertThat(product.getPrice()).isEqualTo(2000);
    }
}