package com.devmtn30.TDD_Hexagonal.payment;

import com.devmtn30.TDD_Hexagonal.DiscountPolicy;
import com.devmtn30.TDD_Hexagonal.Product;
import com.devmtn30.TDD_Hexagonal.order.Order;
import org.springframework.stereotype.Component;

@Component
class PaymentAdapter implements PaymentPort {
    private final PaymentGateway paymentGateway;
    private final PaymentRepository paymentRepository;

    PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Order getOrder(Long orderId) {
        return new Order(new Product("상품1", 1000, DiscountPolicy.NONE), 2);
    }


    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void pay(int totalPrice, String cardNumber) {
        paymentGateway.excute(totalPrice, cardNumber);
    }

}
