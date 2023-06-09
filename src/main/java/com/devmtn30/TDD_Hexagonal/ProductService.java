package com.devmtn30.TDD_Hexagonal;

import com.devmtn30.TDD_Hexagonal.product.GetProductResponse;
import com.devmtn30.TDD_Hexagonal.product.UpdateProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductService {
    private final ProductPort productPort;

    public ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }


    @PostMapping
    @Transactional
    public ResponseEntity<Void> addProduct(@RequestBody final AddProductRequest request) {
        final Product product = new Product(request.name(), request.price(), request.discountPilicy());

        productPort.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable final Long productId) {
        Product product = productPort.getProduct(productId);

        GetProductResponse response = new GetProductResponse(product.getId(), product.getName(), product.getPrice(), product.getDiscountPolicy());

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{productId}")
    @Transactional
    public ResponseEntity<Void> updateProduct(@RequestBody UpdateProductRequest request, @PathVariable Long productId) {
        Product product = productPort.getProduct(productId);
        product.update(request.name(), request.price(), request.discountPilicy());

        productPort.save(product);

        return ResponseEntity.ok().build();
    }
}
