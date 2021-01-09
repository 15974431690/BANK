package com.hodo.service;

import java.sql.SQLException;
import java.util.List;

import com.hodo.dao.UserDao;
import com.hodo.model.User;

public class UserService {
	public User queryOne(Integer id){
		try {
			return new UserDao().queryOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public User queryOneLast(){
		try {
			return new UserDao().queryOneLast();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<User> queryAll(){
		try {
			return new UserDao().queryAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int update(User s) {
		UserDao sDao =new UserDao();
		try {
			sDao.update(s);
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1001;
		}
	}
	
	public int delete(int id) {
		UserDao sDao =new UserDao();
		try {
			sDao.detele(id);
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1001;
		}
	}
	
	public int insert(User s) {
		UserDao sDao =new UserDao();
		try {
			sDao.add(s);
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1001;
		}
	}
	public User queryByLogin(String nick, String pwd) {
		try {
			return new UserDao().queryByLogin(nick,pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
