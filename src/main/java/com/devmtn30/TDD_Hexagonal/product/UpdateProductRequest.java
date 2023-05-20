package com.devmtn30.TDD_Hexagonal.product;

import com.devmtn30.TDD_Hexagonal.DiscountPolicy;
import org.springframework.util.Assert;

public record UpdateProductRequest(String name, int price,
                                   DiscountPolicy discountPilicy) {
    public UpdateProductRequest {
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
        Assert.notNull(discountPilicy, "할인 정책은 필수입니다.");
    }
}
