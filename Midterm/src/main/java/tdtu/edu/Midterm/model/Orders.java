package tdtu.edu.Midterm.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private LocalDate orderDate;
    private String delivery_address;
    private String order_status;

}
