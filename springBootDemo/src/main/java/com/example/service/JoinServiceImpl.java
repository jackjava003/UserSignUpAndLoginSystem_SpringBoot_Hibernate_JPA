package com.example.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.models.MemberBean;
import com.example.models.MemberDAO;

@Component
@Transactional
public class JoinServiceImpl implements JoinService {

	@Autowired
	MemberDAO memberDAO;

	@Override
	public boolean checkExist(String email) {
		MemberBean mb = memberDAO.findByEmail(email);
		if(mb==null){
			return false;
		}else{
			return true;
		}

	}

	@Override
	public MemberBean addUser(String firstName, String lastName, String email, String password) {
		// if not exists
		if (!checkExist(email)) {
			// save member in table "MEMBER"
			// this table is a class create by Spring
			MemberBean newMember = new MemberBean();
			newMember.setEmail(email);
			newMember.setFirstName(firstName);
			newMember.setLastName(lastName);
			newMember.setPassword(password);
			newMember.setCreateDate(new Date());
			return memberDAO.save(newMember);
		}

		return null;

	}

	@Override
	public MemberBean logIn(String email, String password) {
		MemberBean mb = memberDAO.findByEmailAndPassword(email, password);
		return mb;
	}

}
