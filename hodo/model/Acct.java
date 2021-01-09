package com.hodo.model;

/*
 * 账户
 */
public class Acct {
	
	private String acctNo;//账号
	private Integer amt;  //账户余额
	
	private Integer userId; //用户ID
	
	public Acct() {}

	
	@Override
	public String toString() {
		return "Acct [acctNo=" + acctNo + ", amt=" + amt + ", userId=" + userId + "]";
	}


	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public Integer getAmt() {
		return amt;
	}

	public void setAmt(Integer amt) {
		this.amt = amt;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	
}
