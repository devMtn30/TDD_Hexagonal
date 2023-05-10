package com.devmtn30.TDD_Hexagonal;

class ProductService {
    private final ProductPort productPort;

    ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }

    public void addProduct(AddProductRequest request) {
        final Product product = new Product(request.name(), request.price(), request.discountPilicy());

        productPort.save(product);
    }
}
