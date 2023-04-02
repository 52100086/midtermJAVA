package tdtu.edu.Midterm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tdtu.edu.Midterm.model.Product;
import tdtu.edu.Midterm.service.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getAllProducts(Model model, @RequestParam(name = "category", required = false) String category,@RequestParam(name = "name", required = false) String name) {
        List<Product> productList;
        if(category == null || category.equalsIgnoreCase("All") && name == null) {
            productList = productService.getAllProducts();
        } else {
            productList = productService.getProductsByNameAndCategory(name, category);
        }
        model.addAttribute("products", productList);
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
