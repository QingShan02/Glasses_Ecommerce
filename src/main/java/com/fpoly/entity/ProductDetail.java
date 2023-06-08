package com.fpoly.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productdetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "price")
	private double price;
	
//	@Column(name = "image")
//	private Integer productId;
	
	@Column(name = "description")
	private String description;

	@Column(name = "colorid")
	private String colorId;

	@Column(name = "productid")
	private Integer productId;

	@ManyToOne
	@JoinColumn(name = "colorid", insertable = false, updatable = false)
	@JsonIgnore
	Color color;
	
	@ManyToOne
	@JoinColumn(name = "productid", insertable = false, updatable = false)
	@JsonIgnore
	Product product;
}
