package br.com.bledson.ecommerce.product.adapter.out.persistence;

import br.com.bledson.ecommerce.product.domain.Product;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
class ProductMapper {

    Mono<Product> toDomainEntity(ProductJPAEntity productJPAEntity) {
        return Mono.just(new Product(productJPAEntity.getId(), productJPAEntity.getName(), productJPAEntity.getQuantity()));
    }

    Mono<ProductJPAEntity> toJPAEntity(Product product) {
        return Mono.just(new ProductJPAEntity(product.getId(), product.getName(), product.getQuantity()));
    }
}
