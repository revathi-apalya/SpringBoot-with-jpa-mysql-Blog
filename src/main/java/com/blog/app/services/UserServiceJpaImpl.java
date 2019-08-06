package com.blog.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.blog.app.models.User;
import com.blog.app.repositories.UserRepository;
@Service
@Primary
public class UserServiceJpaImpl implements UserService {
@Autowired
private UserRepository userRepo;
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return  this.userRepo.findAll();
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return this.userRepo.findOne(id);
	}

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return this.userRepo.save(user);
	}

	@Override
	public User edit(User user) {
		// TODO Auto-generated method stub
		return this.userRepo.save(user);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		this.userRepo.delete(id);
	}


}