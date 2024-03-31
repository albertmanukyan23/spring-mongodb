package am.example.mongodbspring;

import am.example.mongodbspring.model.Category;
import am.example.mongodbspring.model.Product;
import am.example.mongodbspring.repository.CategoryRepository;
import am.example.mongodbspring.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MongodbSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbSpringApplication.class, args);
    }

//    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository,
                                               CategoryRepository categoryRepository){
        return args -> {
            var category_one = Category.builder()
                    .description("phone-1")
                    .name("phone-1")
                    .build();
            var category_two = Category.builder()
                    .description("phone-2")
                    .name("phone-2")
                    .build();
            categoryRepository.insert(List.of(category_one, category_two));
            var product = Product.builder()
                    .description("Smart phone")
                    .name("IPhone")
                    .build();
            productRepository.insert(product);
        };
    }
}
