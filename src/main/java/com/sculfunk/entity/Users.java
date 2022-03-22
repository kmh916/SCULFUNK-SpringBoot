package com.sculfunk.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Users {
	@Id
	@Column(name = "user_id")
	private String id;
	private String pw;
	private String name;
	private String addr;
	private String phone;
	private String email;
	private LocalDateTime joindate;
	
}
