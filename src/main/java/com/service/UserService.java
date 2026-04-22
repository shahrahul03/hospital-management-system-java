package com.service;

import java.util.List;

import com.model.User;

public interface UserService {
	void register(User user);
	boolean login(String Uname, String psw);
	List<User> getAllUsers();

}
