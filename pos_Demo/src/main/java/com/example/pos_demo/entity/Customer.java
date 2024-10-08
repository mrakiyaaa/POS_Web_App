package com.example.pos_demo.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Type;


import java.util.ArrayList;

@Entity
@Table(name = "customer")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
public class Customer {

    @Id
    @Column(name = "customer_id",length = 45)
    private int customerId;

    @Column(name = "customer_name",length = 45,nullable = false)
    private String customerName;

    @Column(name = "customer_address",length = 255)
    private String customerAddres;

    @Type(type = "json")
    @Column(name = "customer_numbers",columnDefinition = "json")
    private ArrayList contactNumber;

    @Column(name = "nic")
    private String nic;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean active;


}
