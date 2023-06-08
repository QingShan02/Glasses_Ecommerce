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

//    @Column(name = "cartid")
//    private Integer cartId;

    @Column(name = "paymentmethodid")
    private Integer paymentmethodId = 1;

    @Column(name = "statusid")
    private String statusId;

    @Column(name = "totalprice")
    private double totalOrders;

//    @ManyToOne
//    @JoinColumn(name = "cartid", insertable = false, updatable = false)
//    @JsonIgnore
//    Cart cart;

    @ManyToOne
    @JoinColumn(name = "statusid", insertable = false, updatable = false)
    @JsonIgnore
    Status status;
}
