package pl.edu.vistula.sanjay.firstrestapi.product.support.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Could not locate product record matching tracking ID: " + id);
    }
}