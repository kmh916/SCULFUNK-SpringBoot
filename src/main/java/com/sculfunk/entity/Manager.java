package com.sculfunk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Manager {
	@Id
	@Column(name="manager_id")
	private String id;
	
	private String pw; 
	private String name;
	private String imgpath;
	@Enumerated(EnumType.STRING)
	private Manager_Authority authority;
}
