package com.devmtn30.TDD_Hexagonal;

import org.springframework.util.Assert;

class Product {
    private final String name;
    private final int price;
    private final DiscountPilicy discountPilicy;
    private Long id;

    public Product(String name, int price, DiscountPilicy discountPilicy) {
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
        Assert.notNull(discountPilicy, "할인 정책은 필수입니다.");

        this.name = name;
        this.price = price;
        this.discountPilicy = discountPilicy;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
