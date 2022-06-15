package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService{
    private static final Map<Integer, Customer> customers ;
    static {

        customers = new HashMap<>();
        customers.put(1, new Customer(1, "rose", "rosea@codegym.vn", "Hanoi"));
        customers.put(2, new Customer(2, "huong", "huong261@codegym.vn", "Hatinh"));
        customers.put(3, new Customer(3, "jonyNguyen", "jony@codegym.vn", "Saigon"));
        customers.put(4, new Customer(4, "thuyLinh", "thuylinhnguyen@codegym.vn", "tokyo"));
        customers.put(5, new Customer(5, "hoangHa", "hoangha@codegym.vn", "Hue"));
        customers.put(6, new Customer(6, "sunny", "sunny@codegym.vn", "Newyork"));
    }



    @Override
    public List<Customer> findAll() {
        return  new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);

    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id,customer);

    }

    @Override
    public void remove(int id) {
        customers.remove(id);

    }
}
