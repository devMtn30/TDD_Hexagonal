package com.devmtn30.TDD_Hexagonal.payment;

import org.springframework.util.Assert;

record PaymentRequest(Long orderId, String cardNumber) {
    PaymentRequest {
        Assert.notNull(orderId, "주문 Id는 필수입니다.");
        Assert.hasText(cardNumber, "카드 번호는 필수입니다.");
    }
}
