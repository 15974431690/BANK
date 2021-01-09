package com.hodo.util;

import java.util.List;

import com.hodo.model.Log;
import com.hodo.model.User;
import com.hodo.service.UserService;


public class DateUtil {

	public static Object[][] userListToArray(List<User> p){
		Object[][] data=new Object[p.size()][];
		int size=p.size();
		for(int i=0;i<size;i++) {
			User s = p.get(i);
			Object[] info =new Object[] {
					s.getId(),s.getUsrnm(),s.getPwd(),s.getNm(),s.getSex(),s.getUsrGroup()};
			data[i]=info;
		}
		return data;
	}
	public static Object[][] logListToArray(List<Log> p){
		Object[][] data=new Object[p.size()][];
		int size=p.size();
		for(int i=0;i<size;i++) {
			Log s = p.get(i);
			UserService userService = new UserService();
			
			Object[] info =new Object[] {
					s.getId(),s.getContent(),s.getDt(),userService.queryOne(s.getUserId()).getNm()};
			data[i]=info;
		}
		return data;
	}
	
}
