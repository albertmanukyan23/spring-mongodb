package am.example.mongodbspring.repository;

import am.example.mongodbspring.model.Category;
import am.example.mongodbspring.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
