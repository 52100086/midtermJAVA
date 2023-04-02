package tdtu.edu.Midterm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tdtu.edu.Midterm.model.Cart;
import tdtu.edu.Midterm.model.Orders;
import tdtu.edu.Midterm.model.Product;
import tdtu.edu.Midterm.service.CartService;
import tdtu.edu.Midterm.service.OrdersService;
import tdtu.edu.Midterm.service.ProductService;

import java.util.*;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/cart")
    public String viewCart(Model model) {
        List<Cart> carts = cartService.getAllCarts();
        Map<Integer, Product> productMap = new HashMap<>();
        double total = 0.0;
        for (Cart cart : carts) {
            int productId = cart.getProductId();
            if (!productMap.containsKey(productId)) {
                Product product = productService.getProductById(productId)
                        .orElseThrow(() -> new RuntimeException("Product not found"));
                productMap.put(productId, product);
            }
            total += cart.getQuantity() * productMap.get(productId).getPrice();
        }
        model.addAttribute("carts", carts);
        model.addAttribute("products", productMap);
        model.addAttribute("total", total);
        return "cart";
    }


    @PostMapping("/cart")
    public String addToCart(@RequestParam int product_id, @RequestParam int quantity) {
        Product product = productService.getProductById(product_id).orElseThrow(() -> new RuntimeException("Product not found"));
        Optional<Cart> optionalCart = cartService.getCartByProductId(product_id);
        Cart cart;
        if (optionalCart.isPresent()) {
            cart = optionalCart.get();
            cart.setQuantity(cart.getQuantity() + quantity);
        } else {
            cart = new Cart();
            cart.setProductId(product.getId());
            cart.setQuantity(quantity);
        }
        cartService.saveOrUpdateCart(cart);
        return "redirect:/cart";
    }

    @GetMapping("/cart/checkout")
    public String checkout(Model model, @RequestParam int cartId) {
        Cart cart = cartService.getCartById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        Product product = productService.getProductById(cart.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        double subtotal = cart.getQuantity() * product.getPrice();
        model.addAttribute("cart", cart);
        model.addAttribute("product", product);
        model.addAttribute("subtotal", subtotal);
        return "checkout";
    }

    @PostMapping("/cart/checkout")
    public String placeOrder(@RequestParam int cartId, @RequestParam String deliveryAddress, @RequestParam String phone) {
        Cart cart = cartService.getCartById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        Product product = productService.getProductById(cart.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        double subtotal = cart.getQuantity() * product.getPrice();
        Orders order = new Orders();
        order.setDelivery_address(deliveryAddress);
        order.setOrder_status("Not delivered");
        order.setPhone(phone);
        order.setCartId(cart.getId());
        ordersService.createOrder(order);
        return "checkout-success";
    }

}
