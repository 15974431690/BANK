package com.hodo.model;

/*
 * 日志
 */
public class Log {
	
	private Integer id;     //ID
	private String content; //处理内容
	private String dt;      //时间
	
	private Integer userId; //用户ID
	
	//非数据
	private String nm;      //用户姓名
	
	public Log() {}

	public Log(String content,Integer userId) {
		super();
		this.content = content;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", content=" + content + ", dt=" + dt + ", userId=" + userId + ", nm=" + nm + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}


	
}
