package com.devmtn30.TDD_Hexagonal.order;

import com.devmtn30.TDD_Hexagonal.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Product product;
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        Assert.notNull(product, "상품은 필수입니다.");
        Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
    }
}
