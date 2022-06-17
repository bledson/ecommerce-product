package br.com.bledson.ecommerce.product.application.port.in;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

public record CreateProductCommand(@NotEmpty String name, @NotNull Long quantity, @NotEmpty Collection<String> images) {
}
