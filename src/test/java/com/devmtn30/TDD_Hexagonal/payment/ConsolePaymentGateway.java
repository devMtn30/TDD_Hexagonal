package com.devmtn30.TDD_Hexagonal.payment;

public class ConsolePaymentGateway implements PaymentGateway {
    @Override
    public void excute(int totalPrice, String cardNumber) {
        System.out.println("Pay!");
    }
}
