package br.com.bledson.ecommerce.product.application.port.in;

import br.com.bledson.ecommerce.product.domain.Product;
import reactor.core.publisher.Mono;

public interface CreateProductUseCase {
    Mono<Product> createProduct(CreateProductCommand createProductCommand);
}
