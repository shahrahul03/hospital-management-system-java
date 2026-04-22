package com.service;

import com.model.User;

public interface UserService {
	void register(User user);
	boolean login(String Uname, String psw);

}
