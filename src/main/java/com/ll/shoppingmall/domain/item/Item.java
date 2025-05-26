package com.ll.shoppingmall.domain.item;

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
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long amount;
    private long price;
    private String name;

    @OneToMany(mappedBy = "item_id", cascade = CascadeType.ALL)
    private List<OrdersItem> ordersItems;
}
