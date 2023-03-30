package tdtu.edu.Midterm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.Midterm.model.Orders;
import tdtu.edu.Midterm.repository.OrdersRepository;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository orderRepo;

    public List<Orders> getAllOrders() {
        return orderRepo.findAll();
    }

    public Optional<Orders> getOrderById(int id) {
        return orderRepo.findById(id);
    }

    public Orders createOrder(Orders order) {
        return orderRepo.save(order);
    }

    public Orders updateOrder(int id, Orders order) {
        Optional<Orders> existingOrder = orderRepo.findById(id);
        if (existingOrder.isPresent()) {
            Orders updatedOrder = existingOrder.get();
            updatedOrder.setCustomer(order.getCustomer());
            updatedOrder.setOrderDate(order.getOrderDate());
            updatedOrder.setDelivery_address(order.getDelivery_address());
            updatedOrder.setOrder_status(order.getOrder_status());
            return orderRepo.save(updatedOrder);
        } else {
            return null;
        }
    }
    public void deleteOrder(int id) {
        orderRepo.deleteById(id);
    }
}
