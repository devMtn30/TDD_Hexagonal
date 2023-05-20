package com.devmtn30.TDD_Hexagonal.payment;

import com.devmtn30.TDD_Hexagonal.order.Order;

interface PaymentPort {
    Order getOrder(Long orderId);

    void save(Payment payment);

    void pay(int totalPrice, String cardNumber);
}
