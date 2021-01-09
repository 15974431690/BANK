package com.hodo.test;

import java.util.List;

import org.junit.Test;

import com.hodo.model.Acct;
import com.hodo.model.Log;
import com.hodo.model.User;
import com.hodo.service.AcctService;
import com.hodo.service.LogService;
import com.hodo.service.UserService;

public class A {
	
	@Test
	public void userSel(){
		UserService as=new UserService();
		List<User> userList = as.queryAll();
		for (User user : userList) {
			System.out.printf(user.toString()+"\n");
		}
	}
	
	@Test
	public void acctSel(){
		AcctService as=new AcctService();
		List<Acct> acctList = as.queryAll();
		for (Acct acct : acctList) {
			System.out.printf(acct.toString()+"\n");
		}
	}
	
	@Test
	public void logSel(){
		LogService as=new LogService();
		List<Log> logList = as.queryAll();
		for (Log l : logList) {
			System.out.printf(l.toString()+"\n");
		}
	}
	public void testSub(){
		
	}

}
