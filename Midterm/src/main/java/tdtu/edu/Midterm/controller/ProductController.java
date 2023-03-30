package tdtu.edu.Midterm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tdtu.edu.Midterm.model.Product;
import tdtu.edu.Midterm.service.ProductService;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }

    @GetMapping("/product/{id}")
    public String getProductDetails(@PathVariable("id") int productId, Model model) {
        Optional<Product> product = productService.getProductById(productId);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "product-details";
        }
        return "index";
    }



}
