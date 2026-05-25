package pl.edu.vistula.sanjay.firstrestapi.product.support;

import org.springframework.stereotype.Component;
import pl.edu.vistula.sanjay.firstrestapi.product.support.exception.ProductNotFoundException;
import java.util.function.Supplier;

@Component
public class ProductExceptionSupplier {

    public Supplier<ProductNotFoundException> productNotFound(Long id) {
        return () -> new ProductNotFoundException(id);
    }
}