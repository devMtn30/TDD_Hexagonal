package com.devmtn30.TDD_Hexagonal.order;

import com.devmtn30.TDD_Hexagonal.Product;
import org.springframework.util.Assert;

class Order {
    private Long id;
    private final Product product;
    private final int quantity;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        Assert.notNull(product, "상품은 필수입니다.");
        Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
