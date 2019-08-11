package com.example.demo.util;

import java.util.List;

import com.example.demo.domain.UserDomain;
import com.example.demo.model.UserModel;

public interface UserService {

	
	UserDomain getUserDetails(Long id);
	
	void deleteUserDetails(Long id);
	
	UserDomain saveUserDetails(UserModel model);
	
	List<UserDomain> getAllUsers();
	
}
