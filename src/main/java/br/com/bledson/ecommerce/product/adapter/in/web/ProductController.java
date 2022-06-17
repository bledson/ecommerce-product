package br.com.bledson.ecommerce.product.adapter.in.web;

import br.com.bledson.ecommerce.product.application.port.in.CreateProductCommand;
import br.com.bledson.ecommerce.product.application.port.in.CreateProductUseCase;
import br.com.bledson.ecommerce.product.application.port.in.FindProductUseCase;
import br.com.bledson.ecommerce.product.domain.Product;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@RequestMapping("products")
@RestController
class ProductController {

    private final CreateProductUseCase createProductUseCase;

    private final FindProductUseCase findProductUseCase;

    public ProductController(CreateProductUseCase createProductUseCase, FindProductUseCase findProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.findProductUseCase = findProductUseCase;
    }

    public Mono<Void> create(@RequestBody Mono<CreateProductCommand> createProductCommandMono) {
        return Mono.empty().then();
    }

    public Flux<Product> findAll() {
        return findProductUseCase.findAll();
    }
}
