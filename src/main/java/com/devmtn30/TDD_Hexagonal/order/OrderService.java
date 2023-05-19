package com.devmtn30.TDD_Hexagonal.order;

import com.devmtn30.TDD_Hexagonal.Product;
import org.springframework.stereotype.Component;

@Component
class OrderService {
    private OrderPort orderPort;

    public OrderService(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public void createOrder(CreateOrderRequest request) {
        final Product product = orderPort.getProductById(request.productId());

        final Order order = new Order(product, request.quantity());
        orderPort.save(order);
    }
}
