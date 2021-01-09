package com.hodo.service;

import java.sql.SQLException;
import java.util.List;

import com.hodo.dao.LogDao;
import com.hodo.model.Log;

public class LogService {
	public Log queryOne(Integer id){
		try {
			return new LogDao().queryOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Log> queryAll(){
		try {
			return new LogDao().queryAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int update(Log s) {
		LogDao sDao =new LogDao();
		try {
			sDao.update(s);
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1001;
		}
	}
	
	public int delete(int id) {
		LogDao sDao =new LogDao();
		try {
			sDao.detele(id);
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1001;
		}
	}
	
	public int insert(Log s) {
		LogDao sDao =new LogDao();
		try {
			sDao.add(s);
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1001;
		}
	}
	
	
}
