package tdtu.edu.Midterm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.Midterm.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
