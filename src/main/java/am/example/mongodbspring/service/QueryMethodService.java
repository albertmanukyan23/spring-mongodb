package am.example.mongodbspring.service;

import am.example.mongodbspring.model.Product;
import am.example.mongodbspring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryMethodService {

    private final ProductRepository productRepository;

    public List<Product> searchByName(String name) {
        return productRepository.findAllByNameIgnoreCase(name);
    }

    public List<Product> searchByNameStartsWith(String name) {
        return productRepository.findAllByNameStartingWith(name);
    }

    public List<Product> searchByNameEndsWith(String name) {
        return productRepository.findAllByNameEndingWith(name);
    }

    public List<Product> searchByNameContaining(String name) {
        return productRepository.findAllByNameContaining(name);
    }

    public List<Product> searchByPriceLt(BigDecimal price) {
        return productRepository.findAllByPriceLessThan(price);

    }

    public List<Product> searchByPriceGt(BigDecimal price) {
        return productRepository.findAllByPriceGreaterThan(price);

    }

    public List<Product> sortByFiledNameAsc(String filedName) {
        return productRepository.findAllByNameContainingOrderByPriceDesc(filedName);

    }

    public List<Product> sortAndPaging(String filedName) {
        Pageable pageable = PageRequest.of(0,5, Sort.by(Sort.Direction.ASC));
        return productRepository.findAllByNameContainingOrderByPriceDesc(filedName, pageable);
    }
}
