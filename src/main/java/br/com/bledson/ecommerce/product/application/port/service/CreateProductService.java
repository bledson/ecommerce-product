package br.com.bledson.ecommerce.product.application.port.service;

import br.com.bledson.ecommerce.product.application.port.in.CreateProductCommand;
import br.com.bledson.ecommerce.product.application.port.in.CreateProductUseCase;
import br.com.bledson.ecommerce.product.application.port.out.SaveProductPort;
import br.com.bledson.ecommerce.product.domain.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class CreateProductService implements CreateProductUseCase {
    private final SaveProductPort saveProductPort;

    CreateProductService(SaveProductPort saveProductPort) {
        this.saveProductPort = saveProductPort;
    }

    @Override
    public Mono<Product> createProduct(CreateProductCommand createProductCommand) {
        return saveProductPort.create(new Product(createProductCommand.name(), createProductCommand.quantity()));
    }
}
