package com.hodo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hodo.model.Acct;
import com.hodo.util.JdbcUtil;

public class AcctDao {
	
	public void add(Acct s) throws SQLException {
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//准备sql
		String sql="insert into acct values(?,?,?)";
		//获取PreparedStatement
		PreparedStatement ps=conn.prepareStatement(sql);
		//填充占位符
		ps.setString(1, s.getAcctNo());
		ps.setInt(2, s.getAmt());
		ps.setInt(3, s.getUserId());
		//执行sql
		ps.executeUpdate();
		//关闭连接
		JdbcUtil.release(conn);
	}
	
	public void detele(String  acctNo) throws SQLException {
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//准备sql
		String sql="delete from acct where acctNo=?";
		//获取PreparedStatement
		PreparedStatement ps=conn.prepareStatement(sql);
		//填充占位符
		ps.setString(1, acctNo);
		//执行sql
		ps.executeUpdate();
		//关闭连接
		JdbcUtil.release(conn);
	}
	
	public void update(Acct s) throws SQLException {
		Connection conn = JdbcUtil.getConnection();
		String sql="update acct set amt=? where acctNo=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ps.setInt(1, s.getAmt());
		ps.setString(2, s.getAcctNo());
		
		ps.executeUpdate();
		JdbcUtil.release(conn);
	}
	
	public List<Acct> queryAll() throws SQLException{
		List<Acct> acct=new ArrayList<>();
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//准备sql
		String sql="select * from acct";
		//获取PreparedStatement
		PreparedStatement ps=conn.prepareStatement(sql);
		//执行sql
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Acct s=new Acct();
			
			s.setAcctNo(rs.getString(1));
			s.setAmt(rs.getInt(2));
			s.setUserId(rs.getInt(3));
			
			
			acct.add(s);
		}
		//关闭连接
		JdbcUtil.release(conn);
		return acct;
	}
	public Acct queryOne(String acctNo) throws SQLException{
		
		Acct s=null;
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//准备sql
		String sql="select * from acct where acctNo='"+acctNo+"' ";
		//获取PreparedStatement
		PreparedStatement ps=conn.prepareStatement(sql);
		//执行sql
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			s=new Acct();
			s.setAcctNo(rs.getString(1));
			s.setAmt(rs.getInt(2));
			s.setUserId(rs.getInt(3));
		}
		//关闭连接
		JdbcUtil.release(conn);
		return s;
	}
	public Acct queryOneByUserId(Integer userId) throws SQLException{
		
		Acct s=null;
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//准备sql
		String sql="select * from acct where userId="+userId;
		//获取PreparedStatement
		PreparedStatement ps=conn.prepareStatement(sql);
		//执行sql
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			s=new Acct();
			s.setAcctNo(rs.getString(1));
			s.setAmt(rs.getInt(2));
			s.setUserId(rs.getInt(3));
		}
		//关闭连接
		JdbcUtil.release(conn);
		return s;
	}


}
