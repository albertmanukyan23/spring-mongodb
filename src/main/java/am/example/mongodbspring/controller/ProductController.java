package am.example.mongodbspring.controller;

import am.example.mongodbspring.model.Product;
import am.example.mongodbspring.service.ProductService;
import am.example.mongodbspring.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;
    private final SearchService searchService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable String id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        productService.deleteById(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<List<Product>> searchByName(@RequestParam(name = "") String name) {

        return ResponseEntity.ok(searchService.searchByName(name));
    }

}
