package com.example.service;

import org.springframework.stereotype.Component;

import com.example.models.MemberBean;

//@Component tell Spring this is a object, to do Di injection while application is starting
@Component
public interface JoinService {
	
	public  boolean checkExist(String email);

	public  MemberBean addUser(String firstName, String lastName, String email, String password);
	
	public  MemberBean logIn(String email, String password);

}
