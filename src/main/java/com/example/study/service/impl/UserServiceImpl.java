package com.example.study.service.impl;

import java.util.List;
import java.util.Map;

import com.example.study.dao.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.study.domain.User;
import com.example.study.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
	private UserDao userDao;

	public User getByPrimaryKey(Long id){
		return userDao.getByPrimaryKey(id);
	}
	public void create(User user){
		userDao.create(user);
	}
	public void update(User user){
		userDao.update(user);
	}
	public void delete(Long id){
		userDao.delete(id);
	}
	public int count(Map<String,Object> params){
		return userDao.count(params);
	}
	public User get(Map<String,Object> params){
	    return userDao.get(params);
	}
	public List<User> getList(Map<String,Object> params){
		return userDao.getList(params);
	}
}