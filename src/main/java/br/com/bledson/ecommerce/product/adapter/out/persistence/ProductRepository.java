package br.com.bledson.ecommerce.product.adapter.out.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

interface ProductRepository extends ReactiveCrudRepository<ProductJPAEntity, Long> {
}
