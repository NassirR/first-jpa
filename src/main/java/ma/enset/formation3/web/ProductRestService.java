package ma.enset.formation3.web;

import ma.enset.formation3.entities.Product;
import ma.enset.formation3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestService {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> products(){
       List<Product> products = productRepository.findAll();
       return products;
    }

    @GetMapping("/product/{id}")
    public Product productById(@PathVariable("id") Long id){
        Product product = productRepository.findById(id).orElse(null);
        return product;
    }
}
