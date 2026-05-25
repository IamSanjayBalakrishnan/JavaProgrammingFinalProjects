package pl.edu.vistula.sanjay.firstrestapi.product.support;

import org.springframework.stereotype.Component;
import pl.edu.vistula.sanjay.firstrestapi.product.api.request.ProductRequest;
import pl.edu.vistula.sanjay.firstrestapi.product.api.response.ProductResponse;
import pl.edu.vistula.sanjay.firstrestapi.product.domain.Product;

@Component
public class ProductMapper {
    // Map request to domain model [cite: 77]
    public Product toProduct(ProductRequest request) {
        return new Product(null, request.getName());
    }

    // Map domain model to response payload [cite: 77, 81]
    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName());
    }
}