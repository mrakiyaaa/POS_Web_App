package com.example.pos_demo.controller;

import com.example.pos_demo.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @PostMapping("/savedCustomer")
    public String saveCustomer (@RequestBody CustomerDTO customerDTO) {

        String message = customerDTO.getCustomerName();
        System.out.println("Name:"+ message);
        return message;
    }

}
