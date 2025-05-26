package com.ll.shoppingmall.domain.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    @ResponseBody
    public List<Customer> getCustomers() {
        return customerService.findAll();
    }
    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Customer> getCustomer(@PathVariable long id) {
        return customerService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public String createCustomer(
            @RequestBody Customer customer) {
        return customerService.createCustomer(customer.getName());
    }

    @PutMapping("/{id}")
    @ResponseBody
    public boolean modifyCustomer(
            @PathVariable long id,
            @RequestBody String name) {
        return customerService.modifyCustomer(id, name);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean deleteCustomer(
            @PathVariable long id) {
        return customerService.deleteCustomer(id);
    }

//    @GetMapping("/customers/{id}/orders")
//    @ResponseBody
//    public List<Orders> getOrders(@PathVariable long id) {
//        return customerService.getOrders(id);
//    }
}
