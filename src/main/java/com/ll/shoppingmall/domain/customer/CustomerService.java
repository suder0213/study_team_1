package com.ll.shoppingmall.domain.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;


    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(long id) {
        return customerRepository.findById(id);
    }

    public String createCustomer(String name) {
        Customer customer = Customer
                .builder()
                .name(name)
                .build();
        customerRepository.save(customer);
        return "%s 고객 생성됨 ( id = %d )\n".formatted(customer.getName(), customer.getId());
    }

    public boolean modifyCustomer(long id, String name) {
        List<Customer> customers = customerRepository.findAll();
        Customer customer = customers.stream()
                .filter(_customer -> _customer.getId() == id
                ).findFirst()
                .orElse(null);
        if (customer == null) return false;
        customer.setName(name);
        return true;
    }

    public boolean deleteCustomer(long id) {
        List<Customer> customers = customerRepository.findAll();
        Customer customer = customers.stream()
                .filter(_customer -> _customer.getId() == id
                ).findFirst()
                .orElse(null);
        if (customer == null) return false;
        customerRepository.delete(customer);
        return true;
    }

//    public List<Orders> getOrders(long id) {
//        List<Customer> customers = customerRepository.findAll();
//        Customer customer = customers.stream()
//                .filter(_customer -> _customer.getId() == id
//                ).findFirst()
//                .orElse(null);
//        if (customer == null) return List<Empty>;
//    }
}
