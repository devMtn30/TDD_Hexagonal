package com.devmtn30.TDD_Hexagonal.payment;

interface PaymentGateway {
    void excute(int totalPrice, String cardNumber);
}
