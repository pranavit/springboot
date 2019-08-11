package com.example.demo.util;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.domain.UserDomain;
import com.example.demo.model.UserModel;
import com.example.demo.repo.UserRepo;

@Service
@Component
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDomain getUserDetails(Long id) {
		return userRepo.findOne(id);
	}

	@Override
	public void deleteUserDetails(Long id) {
		userRepo.delete(id);
	}

	@Override
	public UserDomain saveUserDetails(UserModel model) {
		UserDomain domain = new UserDomain();
		BeanUtils.copyProperties(model, domain);
		return userRepo.save(domain);
	}

	@Override
	public List<UserDomain> getAllUsers() {
		return userRepo.findAll();
	}

}
