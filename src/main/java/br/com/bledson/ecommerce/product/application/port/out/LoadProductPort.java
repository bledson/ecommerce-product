package br.com.bledson.ecommerce.product.application.port.out;

import br.com.bledson.ecommerce.product.domain.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LoadProductPort {
    Mono<Product> findById(Long id);

    Flux<Product> findAll();
}
