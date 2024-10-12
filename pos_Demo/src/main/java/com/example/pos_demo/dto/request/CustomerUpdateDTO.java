package com.example.pos_demo.dto.request;

public class CustomerUpdateDTO {

    private int customerId;
    private String customerName;
    private String customerAddress;

    //No Args Constructer
    public CustomerUpdateDTO() {
    }

    //All Args Constructer
    public CustomerUpdateDTO(int customerId, String customerName, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }

    //Getters
    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }


    //Setters

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
