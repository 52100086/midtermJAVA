package tdtu.edu.Midterm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.Midterm.model.Customer;
import tdtu.edu.Midterm.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepo;

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Optional<Customer> getCustomerById(int id) {
        return customerRepo.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer updateCustomer(int id, Customer customer) {
        Optional<Customer> existingCustomer = customerRepo.findById(id);
        if (existingCustomer.isPresent()) {
            Customer updatedCustomer = existingCustomer.get();
            updatedCustomer.setName(customer.getName());
            updatedCustomer.setEmail(customer.getEmail());
            updatedCustomer.setPhone(customer.getPhone());
            updatedCustomer.setAddress(customer.getAddress());
            return customerRepo.save(updatedCustomer);
        } else {
            return null;
        }
    }

    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }
}

