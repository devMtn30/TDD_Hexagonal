package com.devmtn30.TDD_Hexagonal;

public interface ProductPort {
    void save(Product product);

    Product getProduct(long productId);
}
