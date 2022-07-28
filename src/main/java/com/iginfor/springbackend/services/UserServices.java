package com.iginfor.springbackend.services;

import java.util.List;

import com.iginfor.springbackend.exception.EtAuthException;
import com.iginfor.springbackend.model.Users;


public interface UserServices {
	
	Users validateUser(String username, String password) throws  EtAuthException;
	Users registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;
	Users saveUsers(Users users);
	Users getUser(String username);
	List<Users>getUsers();
	Users getUserbyId(Integer id);
}
