package com.ll.shoppingmall.domain.customer;

import com.ll.shoppingmall.domain.orders.Orders;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "customerId", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Orders> orders;
}
