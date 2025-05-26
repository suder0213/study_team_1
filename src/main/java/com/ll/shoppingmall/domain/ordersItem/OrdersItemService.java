package com.ll.shoppingmall.domain.ordersItem;

import com.ll.shoppingmall.domain.item.ItemRepository;
import com.ll.shoppingmall.domain.orders.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersItemService {
    private final OrdersItemRepository ordersItemRepositoy;
    private final OrdersRepository ordersRepository;
    private final ItemRepository itemRepository;


    public List<OrdersItem> findAll() {
        return ordersItemRepositoy.findAll();
    }

    // 다른 요청들과는 다르게 order id에 기반한 item들을 return 해야함
    public List<OrdersItem> findItemsByOrdersId(long orderId) {
        List<OrdersItem> ordersItems = ordersItemRepositoy.findAll();
        List<OrdersItem> ordi = ordersItems.stream().filter(
                _ordersItem -> _ordersItem.getOrders().getId() == orderId
        ).toList();
        return ordi;
    }

    public String createItem(OrdersItem ordersItem) {
        ordersItemRepositoy.save(ordersItem);
        return "OrdersItem created";
    }

    public boolean modifyItem(long id, OrdersItem ordersItem) {
        List<OrdersItem> items = ordersItemRepositoy.findAll();
        OrdersItem item = items.stream()
                .filter(_item -> _item.getId() == id
                ).findFirst()
                .orElse(null);
        if (item == null) return false;
        item.setOrders(ordersItem.getOrders());
        item.setItems(ordersItem.getItems());
        return true;
    }

    public boolean deleteItem(OrdersItem ordersItem) {
        List<OrdersItem> items = ordersItemRepositoy.findAll();
        OrdersItem item = items.stream()
                .filter(_item -> _item.getItems().getId() ==
                        ordersItem.getItems().getId()
                )
                .filter(_item -> _item.getOrders().getId() ==
                        ordersItem.getOrders().getId()
                )
                .findFirst()
                .orElse(null);
        if (item == null) return false;
        ordersItemRepositoy.delete(item);
        return true;
    }

//    public List<Orders> getOrders(long id) {
//        List<item> items = ordersItemRepositoy.findAll();
//        item item = items.stream()
//                .filter(_item -> _item.getId() == id
//                ).findFirst()
//                .orElse(null);
//        if (item == null) return List<Empty>;
//    }
}
