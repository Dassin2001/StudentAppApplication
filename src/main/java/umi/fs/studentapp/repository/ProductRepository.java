package umi.fs.studentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umi.fs.studentapp.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContains(String kw);
    List<Product> findByNameContainsIgnoreCase(String kw);
    List<Product> findByNameContainsAndPriceGreaterThan(String kw, Double price);
   // @Query("select p from Product p where p.name like :x and p.price>:y")
    //List<Product> search(@Param(x) String kw,@Param(y) Double price);


}
