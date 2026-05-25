package pl.edu.vistula.sanjay.firstrestapi.product.support;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.edu.vistula.sanjay.firstrestapi.product.support.exception.ProductNotFoundException;
import pl.edu.vistula.sanjay.firstrestapi.product.api.response.ErrorMessageResponse;


@RestControllerAdvice(basePackages = "pl.edu.vistula.sanjay.firstrestapi.product.api")
public class ProductExceptionHandler {

}
