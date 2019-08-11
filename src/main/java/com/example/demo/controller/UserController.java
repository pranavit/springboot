package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.util.UserService;
import com.example.demo.util.UserServiceImpl;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping(value = "/{id}")
	Map<String,Object> getUserInfo(@PathVariable(value = "id") Long id){
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("user", userService.getUserDetails(id));
		return dataMap;
	}
	
	@PostMapping(value = "/save")
	Map<String,Object> saveUserDetails(@RequestBody UserModel model){
		Map<String,Object> dataMap =new HashMap<>();
		try {
			userService.saveUserDetails(model);
			dataMap.put("msg", "success");
		}catch(Exception e) {
			dataMap.put("error", e.getMessage());
		}
		return dataMap;
	}
	
	
	@DeleteMapping(value = "/delete/{id}")
	void deleteUser(@PathVariable(value = "id") Long id){
		userService.deleteUserDetails(id);
	}
	
	@GetMapping(value = "/")
	Map<String,Object> allUsers(){
		Map<String,Object> dataMap =new HashMap<>();
		dataMap.put("data", userService.getAllUsers());
		return dataMap;
	}
	
}
