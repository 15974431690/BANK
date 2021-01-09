package com.hodo.model;

/*
 * 用户
 */
public class User {
	
	private Integer id;     //ID
	private String usrnm;   //用户名
	private String pwd;     //密码
	private String nm;      //姓名
	private String sex;     //性别
	private String usrGroup;//身份(用户/管理员)
	
	public User() {}

	@Override
	public String toString() {
		return "User [id=" + id + ", usrnm=" + usrnm + ", pwd=" + pwd + ", nm=" + nm + ", sex=" + sex + ", usrGroup="
				+ usrGroup + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsrnm() {
		return usrnm;
	}

	public void setUsrnm(String usrnm) {
		this.usrnm = usrnm;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getUsrGroup() {
		return usrGroup;
	}

	public void setUsrGroup(String usrGroup) {
		this.usrGroup = usrGroup;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	
}
