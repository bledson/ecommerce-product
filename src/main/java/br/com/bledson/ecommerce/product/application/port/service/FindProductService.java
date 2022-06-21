package br.com.bledson.ecommerce.product.application.port.service;

import br.com.bledson.ecommerce.product.domain.Product;
import br.com.bledson.ecommerce.product.application.port.in.FindProductUseCase;
import br.com.bledson.ecommerce.product.application.port.out.LoadProductPort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class FindProductService implements FindProductUseCase {

    private final LoadProductPort loadProductPort;

    FindProductService(LoadProductPort loadProductPort) {
        this.loadProductPort = loadProductPort;
    }

    @Override
    public Mono<Product> findById(Long id) {
        return loadProductPort.findById(id);
    }

    @Override
    public Flux<Product> findAll() {
        return loadProductPort.findAll();
    }
}
