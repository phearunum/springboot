package com.iginfor.springbackend.repositorys;


import com.iginfor.springbackend.exception.EtAuthException;
import com.iginfor.springbackend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepoitory extends JpaRepository<Users,Integer>{
	Users findByUsername(String username)throws EtAuthException;
    

}

