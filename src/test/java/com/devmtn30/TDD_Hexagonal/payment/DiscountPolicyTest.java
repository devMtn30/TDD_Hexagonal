package com.devmtn30.TDD_Hexagonal.payment;

import com.devmtn30.TDD_Hexagonal.DiscountPolicy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountPolicyTest {

    @Test
    void none_Discounted_Policy() {
        int price = 1000;
        int discountedPrice = DiscountPolicy.NONE.applyDiscount(price);
        assertThat(discountedPrice).isEqualTo(price);
    }

    @Test
    void fix_1000_discounted_price() {
        int price = 2000;
        int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);
        assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    void over_discounted_price() {
        int price = 500;
        int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);
        assertThat(discountedPrice).isEqualTo(0);
    }
}