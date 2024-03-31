package am.example.mongodbspring.service;

import am.example.mongodbspring.model.Product;
import am.example.mongodbspring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public String save(Product product) {
        return productRepository.save(product).getId();
    }

    public Product findById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}
