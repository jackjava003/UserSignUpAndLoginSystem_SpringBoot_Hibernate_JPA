package com.example.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

//tell Spring this class is data related transaction
//CrudRepository is a CRUD(create,read,update,delete) class provide by Spring
//<entity class name, primary key>


public interface MemberDAO extends CrudRepository<MemberBean, Integer>, Repository<MemberBean, Integer> {
	MemberBean findByEmail(String email);
	MemberBean findByEmailAndPassword(String email, String password);
}
