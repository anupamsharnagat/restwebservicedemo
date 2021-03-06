package com.anu.demo.restwebservice.restwebservicedemo.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="all details about anupam demo User model")
public class Userold {
	
	private Integer id;
	
	@Size(min=2, message="Name must have atleast 2 charactar")
	@ApiModelProperty(notes="User name must be atleast 2 charactor")
	private String name;
	
	@Past
	@ApiModelProperty(notes="Birthday must be in past date")
	private Date birthDate;
	
	protected Userold(){}
	
	public Userold(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
	

}
