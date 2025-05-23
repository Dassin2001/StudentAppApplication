package umi.fs.studentapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import umi.fs.studentapp.entities.Product;
import umi.fs.studentapp.repository.ProductRepository;

import java.util.List;

@SpringBootApplication
public class StudentAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(StudentAppApplication.class, args);

    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            /// code execute au demarage de application
            //constructeur sans parametre Noargsconstructor
            Product p=new Product();
            p.setName("Ord");
            p.setPrice(4000);
            p.setQuantity(10);
            productRepository.save(p);
            //constructeur avec parametre Allargsconstructor
            Product p1 = Product.builder()
                    .name("Phone")
                    .price(8000)
                    .quantity(10)
                    .build();
            productRepository.save(p1);            productRepository.save(p1);
            // builder cest mieux utiliser builder
            Product p2 = Product.builder()
                    .name("TV")
                    .price(10000)
                    .quantity(1)
                    .build();
            productRepository.save(p2);
            productRepository.save(Product.builder()
                    .name("HeadPhone").quantity(1000).price(100)
                    .build());
            productRepository.save(Product.builder()
                    .name("Tablet").quantity(100).price(1000)
                    .build());
            List<Product> products = productRepository.findAll();
            System.out.println("Tous Les prod :");

            products.forEach(prod->{
                System.out.println(prod.toString());
            });
            List<Product> products1 = productRepository.findByNameContainsIgnoreCase("a");
            System.out.println("Les prod qui cpntient a :");
            products1.forEach(prod->{
                System.out.println(prod.toString());
            });
            System.out.println("Les prod qui cpntient T :");
            List<Product> products2 = productRepository.findByNameContains("T");
            products2.forEach(prod->{
                System.out.println(prod.toString());
            });
        };
    }

}
