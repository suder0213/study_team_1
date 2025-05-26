package com.ll.shoppingmall.domain.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService ordersService;

    @GetMapping
    @ResponseBody
    public List<Orders> getOrders() {
        return ordersService.findAll();
    }
    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Orders> getOrders(@PathVariable long id) {
        return ordersService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public Orders createOrders(
            @RequestBody Orders orders) {
        return ordersService.createOrders(orders);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public boolean modifyOrders(
            @PathVariable long id,
            @RequestBody long totalPrice,
            @RequestBody boolean delivered) {
        return ordersService.modifyOrders(id, totalPrice, delivered);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean deleteOrders(
            @PathVariable long id) {
        return ordersService.deleteOrders(id);
    }

//    @PutMapping("/{id}")
//    @ResponseBody
//    public boolean modifyOrders(
//            @PathVariable long id,
//            @RequestBody Orders orders) {
//        return ordersService.modifyOrders();
//    }
//
//    @PutMapping("/{id}")
//    @ResponseBody
//    public boolean modifyOrders(
//            @PathVariable long id,
//            @RequestBody Orders orders) {
//        return ordersService.modifyOrders();
//    }

}
