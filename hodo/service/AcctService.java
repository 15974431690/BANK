package com.hodo.service;

import java.sql.SQLException;
import java.util.List;

import com.hodo.dao.AcctDao;
import com.hodo.model.Acct;

public class AcctService {
	public Acct queryOne(String acctNo){
		try {
			return new AcctDao().queryOne(acctNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Acct queryOneByUserId(Integer userId){
		try {
			return new AcctDao().queryOneByUserId(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Acct> queryAll(){
		try {
			return new AcctDao().queryAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int update(Acct s) {
		AcctDao sDao =new AcctDao();
		try {
			sDao.update(s);
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1001;
		}
	}
	
	public int delete(String acctNo) {
		AcctDao sDao =new AcctDao();
		try {
			sDao.detele(acctNo);
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1001;
		}
	}
	
	public int insert(Acct s) {
		AcctDao sDao =new AcctDao();
		try {
			sDao.add(s);
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1001;
		}
	}
	
	
}
