package com.fpoly.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "oders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private Integer id;

    @Column(name = "cartid")
    private Integer cartid;

    @Column(name = "paymentmethodid")
    private Integer paymentmethodId;

    @Column(name = "statusid")
    private String statusId = "ST1";

    @Column(name = "totalPrice")
    private double totalOrders;

    @ManyToOne
    @JoinColumn(name = "cartid", insertable = false, updatable = false)
    @JsonIgnore
    Cart cart;

    @ManyToOne
    @JoinColumn(name = "statusid", insertable = false, updatable = false)
    @JsonIgnore
    Status status;
}
