package com.sculfunk.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

	@Id @GeneratedValue
	@Column(name= "product_id")
	private Long id;
	
	private String name;
	private int price;
	private int stock;
	private String imgpath;
	private String detail;
	private int point;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	private LocalDateTime regdate;
}
