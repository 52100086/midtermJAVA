package tdtu.edu.Midterm.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.Midterm.model.Cart;
import tdtu.edu.Midterm.model.Orders;
import tdtu.edu.Midterm.repository.CartRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartById(int id) {
        return cartRepository.findById(id);
    }

    public void saveOrUpdateCart(Cart cart) {
        cartRepository.save(cart);
    }

    public void deleteCartById(int id) {
        cartRepository.deleteById(id);
    }

    public void deleteCart(Cart cart) {
        cartRepository.delete(cart);
    }
    public Optional<Cart> getCartByProductId(int productId) {
        return cartRepository.findByProductId(productId);
    }




}
