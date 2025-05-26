package com.ll.shoppingmall.domain.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;


    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    public Optional<Orders> findById(long id) {
        return ordersRepository.findById(id);
    }

    public Orders createOrders(Orders orders) {
        ordersRepository.save(orders);
        return orders;
    }

    public boolean modifyOrders(long id, long totalPrice, boolean delivered) {
        List<Orders> orderss = ordersRepository.findAll();
        Orders orders = orderss.stream()
                .filter(_orders -> _orders.getId() == id
                ).findFirst()
                .orElse(null);
        if (orders == null) return false;
        orders.setTotalPrice(totalPrice);
        orders.setDelivered(delivered);
        return true;
    }

    public boolean deleteOrders(long id) {
        List<Orders> orderss = ordersRepository.findAll();
        Orders orders = orderss.stream()
                .filter(_orders -> _orders.getId() == id
                ).findFirst()
                .orElse(null);
        if (orders == null) return false;
        ordersRepository.delete(orders);
        return true;
    }

}
