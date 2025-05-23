package umi.fs.studentapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import umi.fs.studentapp.entities.Product;
import umi.fs.studentapp.repository.ProductRepository;

import java.util.List;

@RestController
public class ProductRestController {
    @Autowired
    ProductRepository productRepository;
    @GetMapping("/Products")
    public List<Product> Products(){
        return productRepository.findAll();
    }
    @GetMapping("/Products/{id}")
    public Product ProductById(@PathVariable Long id){
        return productRepository.findById(id).get();
    }
}
