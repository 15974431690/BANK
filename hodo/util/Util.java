package com.hodo.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;



public class Util {

	public static final String CHARSET_NAME = "MS932";

	protected Util() {
	}
	
	/*
	 * 设置frame窗口居中显示
	 */
	public static void setCenter(JFrame frame,int width, int height) {
    //---------------------------设置窗口居中----------------------------------------------------------
    int windowWidth = width;                    //获得窗口宽
    int windowHeight = height;                  //获得窗口高
    Toolkit kit = Toolkit.getDefaultToolkit();             //定义工具包
    Dimension screenSize = kit.getScreenSize();            //获取屏幕的尺寸
    int screenWidth = screenSize.width;                    //获取屏幕的宽
    int screenHeight = screenSize.height;                  //获取屏幕的高
    frame.setBounds(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2,windowWidth,windowHeight);
    //------------------------------------------------------------------------------------------------
	}
	/**
	 * 判断对象是否为空-常用
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj instanceof String) {
			String val = (String) obj;
			val = val.replaceAll(" ", "");
			if (val.trim().length() == 0) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 判断对象是否不为空-常用
	 */
	public static boolean isNotEmpty(Object obj) {
		if(isEmpty(obj)){
			return false;
		} else {
			return true;
		}
	}
	public static boolean isNotListEmpty(List list) {
		if(Util.isNotEmpty(list) && list.size()>0){
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 判断是否大数字
	 */
	public static boolean isNumeric(String target) {
		try {
			new BigDecimal(target);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * 判断字符串内容是否一样
	 */
	public static boolean isEquals(Object obj1, Object obj2) {
		if (obj1 == null && obj2 == null) {
			return true;
		} else if (obj2 == null) {
			return obj1.equals(obj2);
		} else {
			return obj2.equals(obj1);
		}
	}
	/**
	 * 判断字符串第个字符是否一样
	 */
	public static boolean isSameChars(String str) throws IllegalArgumentException {
		if (str == null)
			throw new IllegalArgumentException("Input string should not be null.");
		else if (str.length() < 2)
			return true;
		char first = str.charAt(0);
		for (int i = 1; i < str.length(); i++)
			if (str.charAt(i) != first)
				return false;
		return true;
	}
}
