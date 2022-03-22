package com.sculfunk.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Qna_reply {

	@Id @GeneratedValue
	@Column(name= "qna_reply_id")
	private Long id;
	
	private String title;
	
	private String contents;
	
	private LocalDateTime regdate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="manager_id")
	private Manager manager;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="qna_id")
	private Qna qna;
	
}
