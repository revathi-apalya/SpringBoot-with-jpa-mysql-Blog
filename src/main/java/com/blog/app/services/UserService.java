package com.blog.app.services;

import java.util.List;

import com.blog.app.models.User;

public interface UserService {
	List<User> findAll();
	User findById(Long id);
	User create(User user);
	User edit(User user);
	void deleteById(Long id);
}
