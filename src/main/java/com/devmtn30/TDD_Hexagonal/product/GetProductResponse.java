package com.devmtn30.TDD_Hexagonal.product;

import com.devmtn30.TDD_Hexagonal.DiscountPolicy;
import org.springframework.util.Assert;

public record GetProductResponse(
        long id,
        String name,
        int price,
        DiscountPolicy discountPilicy
) {
    public GetProductResponse {
        Assert.notNull(id, "아이디는 필수입니다");
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.notNull(discountPilicy, "할인 정책은 필수입니다.");
    }
}
