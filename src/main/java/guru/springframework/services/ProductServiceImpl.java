package guru.springframework.services;

import guru.springframework.domain.Product;
import guru.springframework.repositories.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl() {
        this.productRepository = new ProductRepository(); // Uses symbolic model repository
    }

    // @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll(); // Symbolic read for all
    }

    // @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id); // Symbolic read by ID
    }

    // @Override
    public Product saveProduct(Product product) {
        Set<Product> productSet = new HashSet<>();
        productSet.add(product);
        productRepository.save(productSet); // Symbolic write
        return product;
    }
}

