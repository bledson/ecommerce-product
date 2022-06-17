package br.com.bledson.ecommerce.product.application.port.out;

import br.com.bledson.ecommerce.product.domain.Product;
import reactor.core.publisher.Mono;

public interface SaveProductPort {
    Mono<Product> create(Product product);
}
