package com.iginfor.springbackend.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iginfor.springbackend.config.Constants;
import com.iginfor.springbackend.config.ResponseHandler;
import com.iginfor.springbackend.model.Users;
import com.iginfor.springbackend.services.UserServices;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
	@Autowired
	private UserServices service;

	
	@GetMapping("/")
	public ResponseEntity<Object>Get(){
		try {
            List<Users> result = service.getUsers();
            return ResponseHandler.generateResponse("success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
	}
    
	@GetMapping("/{id}")
	public ResponseEntity<Object> get(@PathVariable String id) {
		try {		
			int _id=Integer.parseInt(id);
			Users users= service.getUserbyId(_id);
			return  ResponseHandler.generateResponse("sucess",HttpStatus.OK,users);
			
		}catch(NoSuchElementException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	
	@PostMapping("/register")
	public ResponseEntity<Users> register(@RequestBody Users user){
		try {
			service.saveUsers(user);
			return new ResponseEntity<Users>(service.saveUsers(user), HttpStatus.CREATED);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Users>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody Map<String,Object> req ){
		try {
			String username = (String) req.get("account");
			String password=(String) req.get("password");
			Users users =service.validateUser(username, password);
		
			return new ResponseEntity<>(generateJWTToken(users), HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	private Map<String, String> generateJWTToken(Users user) {
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
                .claim("userId", user.get_id())
                .claim("email", user.getUsername())
                .compact();
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }

}

























