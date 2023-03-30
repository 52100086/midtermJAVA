package tdtu.edu.Midterm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.Midterm.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
