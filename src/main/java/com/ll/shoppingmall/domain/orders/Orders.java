package com.ll.shoppingmall.domain.orders;

import com.ll.shoppingmall.domain.ordersItem.OrdersItem;
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
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long totalPrice;
    private boolean delivered;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id") // 외래키 컬럼
//    private Customer customer;
    private long customerId;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdersItem> ordersItems;
}
