package br.com.bledson.ecommerce.product.adapter.out.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "products")
class ProductJPAEntity {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private Long quantity;

    public ProductJPAEntity(Long id, String name, Long quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    Long getQuantity() {
        return quantity;
    }

    void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
