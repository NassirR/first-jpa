package ma.enset.formation3;

import ma.enset.formation3.entities.Product;
import ma.enset.formation3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

//https://www.youtube.com/watch?v=cz3p4y7tUEs
@SpringBootApplication
public class Formation3Application implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(Formation3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        productRepository.save(new Product(null, "ELITEBOOK",700,20));
        productRepository.save(new Product(null, "LG",350,110));
        productRepository.save(new Product(null, "SUMSUNG",900,90));
        productRepository.save(new Product(null, "TABLE",400,100));
        productRepository.save(new Product(null, "MILK",250,80));
        productRepository.save(new Product(null, "CHAIR",500,27));

       /* List<Product> products = productRepository.findAll();
        products.forEach(p -> {
            System.out.println(p.toString());
        });

        Product product = productRepository.findById(Long.valueOf(1)).get();
        System.out.println(product.getName());
    */

        List<Product> p1 = productRepository.findByNameContains("L");
        p1.forEach(product1 ->{
            System.out.println(product1.getName());
        } );

        System.out.println("*");

        List<Product> p2 = productRepository.searchByName("%L%");
        p2.forEach(product2 -> {
            System.out.println(product2.getName());
        });

        System.out.println("*");

        List<Product> p3 = productRepository.findByPriceIsGreaterThan(Double.valueOf(500));
        p3.forEach(product3 -> {
            System.out.println(product3.getPrice());
        } );

        System.out.println("*");

        List<Product> p4 = productRepository.searchByPrice(Double.valueOf(500));
        p4.forEach(product4 -> {
            System.out.println(product4.getPrice());
        } );



    }
}
