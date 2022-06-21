package br.com.bledson.ecommerce.product.adapter.in.web;

import br.com.bledson.ecommerce.product.application.port.in.CreateProductCommand;
import br.com.bledson.ecommerce.product.application.port.in.CreateProductUseCase;
import br.com.bledson.ecommerce.product.application.port.in.FindProductUseCase;
import br.com.bledson.ecommerce.product.domain.Product;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequestMapping("products")
@RestController
class ProductController {

    private final CreateProductUseCase createProductUseCase;

    private final FindProductUseCase findProductUseCase;

    private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

    public ProductController(CreateProductUseCase createProductUseCase, FindProductUseCase findProductUseCase, ReactorLoadBalancerExchangeFilterFunction lbFunction) {
        this.createProductUseCase = createProductUseCase;
        this.findProductUseCase = findProductUseCase;
        this.lbFunction = lbFunction;
    }

    @PostMapping
    public Mono<Product> create(@RequestBody CreateProductCommand createProductCommand) {
        return createProductUseCase.createProduct(createProductCommand)
            .subscribeOn(Schedulers.boundedElastic())
            .map(
                product -> {
                    Flux.merge(
                    WebClient.builder().baseUrl("http://image-importer")
                        .filter(lbFunction)
                        .build()
                        .post()
                        .uri("/images/" + product.getId())
                        .body(BodyInserters.fromValue(createProductCommand.images()))
                        .retrieve()
                        .toBodilessEntity(),
                    WebClient.builder().baseUrl("http://publication")
                        .filter(lbFunction)
                        .build()
                        .post()
                        .uri("/publications")
                        .body(BodyInserters.fromValue(createProductCommand.name()))
                        .retrieve()
                        .toBodilessEntity()
                    ).subscribe();
                    return product;
                }
            );
    }

    @GetMapping
    public Flux<Product> findAll() {
        return findProductUseCase.findAll();
    }
}
