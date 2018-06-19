package com.example.study.service;

import java.util.List;
import java.util.Map;

import com.example.study.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

public interface UserService {
	public User getByPrimaryKey(Long id);
	public void create(User user);
	public void update(User user);
	public void delete(Long id);
	public int count(Map<String, Object> params);
	public User get(Map<String, Object> params);
    public List<User> getList(Map<String, Object> params);

	int queryCount(Integer user_id);
	List<User> queryUserList(Integer user_id);
	User queryUser(Integer user_id);
}