package com.fpoly.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "userid")
    private int userId;

    @Column(name = "totalAmount")
    private double totalOrders;

    @Column(name = "shippingaddress")
    private double shippingAddress;

    @Column(name = "orderdate")
    private double orderDate;

    @Column(name = "statusid")
    private String statusId;

    @ManyToOne
    @JoinColumn(name = "statusid", insertable = false, updatable = false)
    @JsonIgnore
    Status status;
}
