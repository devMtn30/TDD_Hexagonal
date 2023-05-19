package com.devmtn30.TDD_Hexagonal.order;

import com.devmtn30.TDD_Hexagonal.Product;

public interface OrderPort {
    Product getProductById(Long productId);

    void save(Order order);
}
