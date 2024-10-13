package com.example.pos_demo.service;

import com.example.pos_demo.dto.CustomerDTO;
import com.example.pos_demo.dto.request.CustomerUpdateDTO;

public interface CustomerService {

    public String saveCustomer (CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);
}
