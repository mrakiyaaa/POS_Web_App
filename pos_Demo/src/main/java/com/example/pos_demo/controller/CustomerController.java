package com.example.pos_demo.controller;

import com.example.pos_demo.dto.CustomerDTO;
import com.example.pos_demo.dto.request.CustomerUpdateDTO;
import com.example.pos_demo.service.CustomerService;
import com.example.pos_demo.service.impl.CustomerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/savedCustomer")
    public String saveCustomer (@RequestBody CustomerDTO customerDTO) {

//        customerService.saveCustomer(customerDTO);
//        return "Saved";

        try {
            customerService.saveCustomer(customerDTO);
            return "Your Data Saved Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to save customer: " + e.getMessage();
        }

    }


    @PutMapping("/update")
    public String updateCustomer (@RequestBody CustomerUpdateDTO customerUpdateDTO) {

        customerService.updateCustomer(customerUpdateDTO);
        return "Updated";
    }

    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId) {

        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }

    @GetMapping(
            path = {"/get-all-customers"}
    )
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomer();
        return allCustomers;
    }

    @DeleteMapping(
            path = {"delete-customer/{id}"}
    )
    public String deleteCustomer(@PathVariable(value = "id") int customerId) {
        String deleted = customerService.deleteCustomer(customerId);
        return deleted;

    }

    @GetMapping(
            path = {"/get-all-customers-by-active-state/{status}"}
    )
    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable (value = "status") boolean activeState) {
        List<CustomerDTO> allCustomers = customerService.getAllCustomersByActiveState(activeState);
        return allCustomers;
    }

}
