package tdtu.edu.Midterm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.Midterm.model.Order_Item;
import tdtu.edu.Midterm.repository.OrderItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepo;

    public List<Order_Item> getAllOrderItems() {
        return orderItemRepo.findAll();
    }

    public Optional<Order_Item> getOrderItemById(int id) {
        return orderItemRepo.findById(id);
    }

    public Order_Item createOrderItem(Order_Item orderItem) {
        return orderItemRepo.save(orderItem);
    }

    public Order_Item updateOrderItem(int id, Order_Item orderItem) {
        Optional<Order_Item> existingOrderItem = orderItemRepo.findById(id);
        if (existingOrderItem.isPresent()) {
            Order_Item updatedOrderItem = existingOrderItem.get();
            updatedOrderItem.setOrder(orderItem.getOrder());
            updatedOrderItem.setProduct(orderItem.getProduct());
            updatedOrderItem.setQuantity(orderItem.getQuantity());
            return orderItemRepo.save(updatedOrderItem);
        } else {
            return null;
        }
    }

    public void deleteOrderItem(int id) {
        orderItemRepo.deleteById(id);
    }
}
