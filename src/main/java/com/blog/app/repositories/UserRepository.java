package com.blog.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.app.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
