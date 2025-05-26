package com.ll.shoppingmall.domain.ordersItem;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order-items")
public class OrdersItemController {
    private final OrdersItemService OrdersItemService;

    @GetMapping("/{orderID}")
    @ResponseBody
    public List<OrdersItem> getItem(
            @PathVariable long orderID) {
        return OrdersItemService.findItemsByOrdersId(orderID);
    }

    @PostMapping
    @ResponseBody
    public String createItem(
            @RequestBody OrdersItem item) {
        return OrdersItemService.createItem(item);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public boolean modifyItem(
            @PathVariable long id,
            @RequestBody OrdersItem item) {
        return OrdersItemService.modifyItem(id, item);
    }

    @DeleteMapping
    @ResponseBody
    public boolean deleteItem(
            @RequestBody OrdersItem item) {
        return OrdersItemService.deleteItem(item);
    }

//    @GetMapping("/items/{id}/orders")
//    @ResponseBody
//    public List<Orders> getOrders(@PathVariable long id) {
//        return OrdersItemService.getOrders(id);
//    }
}
