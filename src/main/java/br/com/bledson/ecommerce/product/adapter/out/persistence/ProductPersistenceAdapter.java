package br.com.bledson.ecommerce.product.adapter.out.persistence;

import br.com.bledson.ecommerce.product.domain.Product;
import br.com.bledson.ecommerce.product.application.port.out.LoadProductPort;
import br.com.bledson.ecommerce.product.application.port.out.SaveProductPort;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
class ProductPersistenceAdapter implements LoadProductPort, SaveProductPort {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    ProductPersistenceAdapter(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Mono<Product> create(Product product) {
        return productMapper.toJPAEntity(product)
            .flatMap(productRepository::save)
            .flatMap(productMapper::toDomainEntity);
    }

    @Override
    public Mono<Product> findById(Long id) {
        return productRepository.findById(id)
            .flatMap(productMapper::toDomainEntity);
    }

    @Override
    public Flux<Product> findAll() {
        return productRepository.findAll()
            .flatMap(productMapper::toDomainEntity);
    }
}
