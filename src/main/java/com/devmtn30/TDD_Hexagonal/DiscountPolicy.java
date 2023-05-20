package com.devmtn30.TDD_Hexagonal;

public enum DiscountPolicy {
    NONE {
        @Override
        public int applyDiscount(int price) {
            return price;
        }
    },
    FIX_1000_AMOUNT {
        @Override
        public int applyDiscount(int price) {
            return Math.max(price - 1000, 0);
        }
    };

    public abstract int applyDiscount(int price);
}
