package tdtu.edu.Midterm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.Midterm.model.Cart;

import java.util.Optional;
@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    Optional<Cart> findByProductId(int productId);
}
