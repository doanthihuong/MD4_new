package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final ICustomerService customerService = new CustomerService();

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/index";
    }
    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id){
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }
    @PostMapping("/edit")
    public String update(Customer customer) {
        customerService.update(customer.getId(), customer);
        return "redirect:/customer";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id){
        customerService.remove(id);
        return "redirect:/customer";
    }
    @GetMapping("/create")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        return modelAndView;
    }
    @PostMapping("/create")
    public String createCustomer(@RequestParam int id,@RequestParam String name,@RequestParam String email,@RequestParam String address){
        Customer customer = new Customer(id, name, email,address);
        customerService.save(customer);
        return "redirect:/customer";
    }
    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id){
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }

}