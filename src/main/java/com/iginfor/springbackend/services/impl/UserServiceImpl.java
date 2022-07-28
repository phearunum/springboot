package com.iginfor.springbackend.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iginfor.springbackend.exception.EtAuthException;
import com.iginfor.springbackend.model.Users;
import com.iginfor.springbackend.repositorys.UserRepoitory;
import com.iginfor.springbackend.services.UserServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public  class UserServiceImpl implements UserServices, UserDetailsService {
	
	@Autowired
	private UserRepoitory userRepoitory;

	@Override
	public Users validateUser(String username, String password) throws EtAuthException {
		return null;
	}

	@Override
	public Users registerUser(String firstName, String lastName, String email, String password) throws EtAuthException {
		return null;
	}

	@Override
	public Users saveUsers(Users users) {
		return userRepoitory.save(users);
	}

	@Override
	public Users getUser(String username) {
		
		return userRepoitory.findByUsername(username);
	}

	@Override
	public List<Users> getUsers() {
	
		return userRepoitory.findAll();
	}

	@Override
	public Users getUserbyId(Integer id) {
		// TODO Auto-generated method stub
		return userRepoitory.findById(id).get();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users users=userRepoitory.findByUsername(username);
		if(users==null) {
			//log.error("user not found");
			throw new UsernameNotFoundException("user not found");
		}
		Collection<SimpleGrantedAuthority> authorities =new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(users.getUsername()));
		return new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(), authorities);
	}


}












