package com.example.study.dao.mapper;

import java.util.List;
import java.util.Map;

import com.example.study.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
	public User getByPrimaryKey(Long id);
	public void create(User user);
	public void update(User user);
	public void delete(Long id);
	public int count(Map<String, Object> params);
	public User get(Map<String, Object> params);
    public List<User> getList(Map<String, Object> params);


    @Select("select count(1) from s_user where id<#{user_id}")
    @ResultType(Integer.class)
    int queryCount(@Param("user_id") Integer user_id);


    @Select("select * from s_user where id<#{user_id}")
    @ResultType(Integer.class)
    List<User> queryUserList(@Param("user_id") Integer user_id);

    @Select("select * from s_user where id=#{user_id}")
    @ResultType(User.class)
    User queryUser(@Param("user_id") Integer user_id);
}