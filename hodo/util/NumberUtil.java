package com.hodo.util;

public class NumberUtil {    
    
    /**  
    * 判断String是否是整数  
    */    
    public static boolean isInteger(String s){    
        if((s != null)&&(s!=""))    
         return s.matches("^[0-9]*$");    
        else    
         return false;    
    }    
    /**  
    * 判断字符串是否是浮点数  
    */    
    public static boolean isDouble(String value) {    
        try {    
           Double.parseDouble(value);    
           if (value.contains("."))    
               return true;    
           return false;    
        } catch (NumberFormatException e) {    
           return false;    
        }    
    }    
    /**  
    * 判断字符串是否是数字  
    */    
    public static boolean isNumber(String value) {    
        return isInteger(value) || isDouble(value);    
    }    
    
}    
