package com.example.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//@Entity assign the class as a table to do OR mapping
@Entity
@Table(name = "MEMBER")
public class MemberBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userID;
	
	@NotNull
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@NotNull
	@Column(name = "LASTNAME")
	private String lastName;
	
	@NotNull
	@Column(name = "EMAIL", unique = true)
	private String email;
	
	@NotNull
	@Column(name = "PASSWORD")
	private String password;
	
	@NotNull
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	public MemberBean(){
		super();
	}
	
	public int getUserID() {
		return userID;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	

}
