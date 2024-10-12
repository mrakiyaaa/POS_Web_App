package com.example.pos_demo.service.impl;

import com.example.pos_demo.dto.CustomerDTO;
import com.example.pos_demo.dto.request.CustomerUpdateDTO;
import com.example.pos_demo.entity.Customer;
import com.example.pos_demo.repository.CustomerRepo;
import com.example.pos_demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {

        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getContactNumber(),
                customerDTO.getNic(),
                customerDTO.isActive()
        );

        customerRepo.save(customer);
        return "";
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if(customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());

            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName() + "updated Successfully";


        }else {
            throw new RuntimeException("no data found");
        }
    }

}
