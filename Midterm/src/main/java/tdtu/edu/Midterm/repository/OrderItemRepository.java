package tdtu.edu.Midterm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.Midterm.model.Order_Item;
@Repository
public interface OrderItemRepository extends JpaRepository<Order_Item, Integer> {
}
