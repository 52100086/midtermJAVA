package tdtu.edu.Midterm.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String delivery_address;
    private String order_status;
    @Column(name = "cart_id")
    private int cartId;
    private String phone;
}
