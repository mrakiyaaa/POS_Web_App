package com.example.pos_demo.controller;

import com.example.pos_demo.dto.CustomerDTO;
import com.example.pos_demo.dto.request.CustomerUpdateDTO;
import com.example.pos_demo.service.CustomerService;
import com.example.pos_demo.service.impl.CustomerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/savedCustomer")
    public String saveCustomer (@RequestBody CustomerDTO customerDTO) {

//        CustomerServiceIMPL customerServiceIMPL = new CustomerServiceIMPL();
//        customerServiceIMPL.saveCustomer(customerDTO);

        customerService.saveCustomer(customerDTO);
        return "Saved";
    }

    @PutMapping("/update")
    public String updateCustomer (@RequestBody CustomerUpdateDTO customerUpdateDTO) {

        customerService.updateCustomer(customerUpdateDTO);
        return "Updated";
    }

}
