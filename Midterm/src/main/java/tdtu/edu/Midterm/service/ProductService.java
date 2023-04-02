package tdtu.edu.Midterm.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.Midterm.model.Product;
import tdtu.edu.Midterm.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    public List<Product> getAllProducts(){return productRepo.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepo.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(int id, Product product){
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isPresent()){
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setBrand(product.getBrand());
            existingProduct.setColor(product.getColor());
            existingProduct.setPrice(product.getPrice());
            return productRepo.save(existingProduct);
        } else {
            return null;
        }
    }
    public void deleteProductById(int id) {
        productRepo.deleteById(id);
    }


    public List<Product> getProductsByNameAndCategory(String name, String category) {
        List<Product> productList = this.getAllProducts();
        if (category != null && !category.isEmpty() && !category.equalsIgnoreCase("All")) {
            productList = productList.stream()
                    .filter(p -> p.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toList());
        }
        if (name != null && !name.isEmpty()) {
            productList = productList.stream()
                    .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
        }

        return productList;
    }









}
