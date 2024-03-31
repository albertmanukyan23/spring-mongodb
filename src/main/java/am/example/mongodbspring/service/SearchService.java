package am.example.mongodbspring.service;

import am.example.mongodbspring.model.Product;
import com.mongodb.internal.operation.AggregateOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final MongoTemplate mongoTemplate;

    public List<Product> searchByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> searchByNameStartsWith(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex("^" + name));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> searchByNameEndsWith(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(name + "$"));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> searchByPriceLt(BigDecimal price) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").lt(price));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> searchByPriceGt(BigDecimal price) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").gt(price));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> sortByFiledNameAsc(String filedName) {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.ASC, filedName));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> sortAndPaging(String filedName) {
        Query query = new Query();
        Pageable pageable = PageRequest.of(0,10, Sort.by(Sort.Direction.ASC));
        query.with(pageable);
        return mongoTemplate.find(query, Product.class);
    }
}
