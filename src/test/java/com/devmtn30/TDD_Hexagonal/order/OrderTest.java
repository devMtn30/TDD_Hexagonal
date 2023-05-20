package com.devmtn30.TDD_Hexagonal.order;

import com.devmtn30.TDD_Hexagonal.DiscountPolicy;
import com.devmtn30.TDD_Hexagonal.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getTotalPrice() {
        Order order = new Order(new Product("상품명", 2000, DiscountPolicy.FIX_1000_AMOUNT), 2);

        int totalPrice = order.getTotalPrice();

        assertThat(totalPrice).isEqualTo(2000);
    }
}