package ie.atu.lab4validation.service;

import ie.atu.lab4validation.module.Product;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();
    private long nextId = 1;

    public Product addProduct(Product product){
        product.setId(nextId++);
        products.add(product);
        return product;
    }
}
