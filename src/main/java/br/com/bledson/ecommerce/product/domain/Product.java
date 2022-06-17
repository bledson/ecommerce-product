package br.com.bledson.ecommerce.product.domain;

public class Product {

    private Long id;

    private String name;

    private Long quantity;

    public Product(String name, Long quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Product(Long id, String name, Long quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getQuantity() {
        return quantity;
    }
}
