package com.gregory.hospitalapp.dao.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gregory.hospitalapp.model.User;

public interface UserDao extends CrudRepository<User, Long> {
	@Query(value = "SELECT * FROM user u WHERE u.login = ? and u.id !=?", nativeQuery = true)
	User findByUserName(String username, Long long1);
}
