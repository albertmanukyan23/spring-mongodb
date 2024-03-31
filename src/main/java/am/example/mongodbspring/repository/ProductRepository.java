package am.example.mongodbspring.repository;

import am.example.mongodbspring.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findAllByNameIgnoreCase(String name);

    List<Product> findAllByNameStartingWith(String name);

    List<Product> findAllByNameEndingWith(String name);

    List<Product> findAllByNameContaining(String name);

    List<Product> findAllByPriceLessThan(BigDecimal price);

    List<Product> findAllByPriceGreaterThan(BigDecimal price);

    List<Product> findAllByNameContainingOrderByPriceDesc(String name);

    List<Product> findAllByNameContainingOrderByPriceDesc(String filedName, Pageable pageable);
}
