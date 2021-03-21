package com.example.onlinedebate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Statement implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	private String comment;

	public Statement() {}

	public Statement(String comment) {
		super();
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setName(String name) {
		this.comment = name;
	}

	@Override
	public String toString() {
		return "Statemetn [id=" + id + ", comment=" + comment + "]";
	}
	
}
