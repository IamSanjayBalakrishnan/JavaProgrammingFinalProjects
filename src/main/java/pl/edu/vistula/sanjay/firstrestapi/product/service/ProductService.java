package pl.edu.vistula.sanjay.firstrestapi.product.service;

import org.springframework.stereotype.Service;
import pl.edu.vistula.sanjay.firstrestapi.product.api.request.ProductRequest;
import pl.edu.vistula.sanjay.firstrestapi.product.api.response.ProductResponse;
import pl.edu.vistula.sanjay.firstrestapi.product.domain.Product;
import pl.edu.vistula.sanjay.firstrestapi.product.repository.ProductRepository;
import pl.edu.vistula.sanjay.firstrestapi.product.support.ProductExceptionSupplier;
import pl.edu.vistula.sanjay.firstrestapi.product.support.ProductMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final ProductExceptionSupplier exceptionSupplier;

    public ProductService(ProductRepository repository, ProductMapper mapper, ProductExceptionSupplier exceptionSupplier) {
        this.repository = repository;
        this.mapper = mapper;
        this.exceptionSupplier = exceptionSupplier;
    }

    public ProductResponse create(ProductRequest request) {
        Product product = mapper.toProduct(request);
        Product savedProduct = repository.save(product);
        return mapper.toProductResponse(savedProduct);
    }

    public ProductResponse find(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(exceptionSupplier.productNotFound(id));
        return mapper.toProductResponse(product);
    }

    public List<ProductResponse> findAll() {
        return repository.findAll().stream()
                .map(mapper::toProductResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse update(Long id, ProductRequest request) {
        Product product = repository.findById(id)
                .orElseThrow(exceptionSupplier.productNotFound(id));
        product.setName(request.getName());
        Product updatedProduct = repository.save(product);
        return mapper.toProductResponse(updatedProduct);
    }

    public void delete(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(exceptionSupplier.productNotFound(id));
        repository.deleteById(product.getId());
    }
}