package com.hodo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hodo.model.User;
import com.hodo.util.JdbcUtil;

public class UserDao {
	
	public void add(User s) throws SQLException {
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//准备sql
		String sql="insert into usr1 values(null,?,?,?,?,?)";
		//获取PreparedStatement
		PreparedStatement ps=conn.prepareStatement(sql);
		//填充占位符
		ps.setString(1, s.getUsrnm());
		ps.setString(2, s.getPwd());
		ps.setString(3, s.getNm());
		ps.setString(4, s.getSex());
		ps.setString(5, s.getUsrGroup());
		//执行sql
		ps.executeUpdate();
		//关闭连接
		JdbcUtil.release(conn);
	}
	
	public void detele(int id) throws SQLException {
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//准备sql
		String sql="delete from usr1 where id=?";
		//获取PreparedStatement
		PreparedStatement ps=conn.prepareStatement(sql);
		//填充占位符
		ps.setInt(1, id);
		//执行sql
		ps.executeUpdate();
		//关闭连接
		JdbcUtil.release(conn);
	}
	
	public void update(User s) throws SQLException {
		Connection conn = JdbcUtil.getConnection();
		String sql="update usr1 set usrnm=?,pwd=?,nm=?,sex=?,usrGroup=? where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ps.setString(1, s.getUsrnm());
		ps.setString(2, s.getPwd());
		ps.setString(3, s.getNm());
		ps.setString(4, s.getSex());
		ps.setString(5, s.getUsrGroup());
		ps.setInt(6, s.getId());
		
		ps.executeUpdate();
		JdbcUtil.release(conn);
	}
	
	public List<User> queryAll() throws SQLException{
		List<User> user=new ArrayList<>();
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//准备sql
		String sql="select * from usr1";
		//获取PreparedStatement
		PreparedStatement ps=conn.prepareStatement(sql);
		//执行sql
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			User s=new User();
			
			s.setId(rs.getInt(1));
			s.setUsrnm(rs.getString(2));
			s.setPwd(rs.getString(3));
			s.setNm(rs.getString(4));
			s.setSex(rs.getString(5));
			s.setUsrGroup(rs.getString(6));
			
			user.add(s);
		}
		//关闭连接
		JdbcUtil.release(conn);
		return user;
	}
	public User queryOne(Integer id) throws SQLException{
		
		User s=null;
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//准备sql
		String sql="select * from usr1 where id="+id;
		//获取PreparedStatement
		PreparedStatement ps=conn.prepareStatement(sql);
		//执行sql
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			s=new User();
			s.setId(rs.getInt(1));
			s.setUsrnm(rs.getString(2));
			s.setPwd(rs.getString(3));
			s.setNm(rs.getString(4));
			s.setSex(rs.getString(5));
			s.setUsrGroup(rs.getString(6));
		}
		//关闭连接
		JdbcUtil.release(conn);
		return s;
	}
	public User queryOneLast() throws SQLException{
		
		User s=null;
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//准备sql
		String sql="select * from usr1 order by id desc limit 1 ";
		//获取PreparedStatement
		PreparedStatement ps=conn.prepareStatement(sql);
		//执行sql
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			s=new User();
			s.setId(rs.getInt(1));
			s.setUsrnm(rs.getString(2));
			s.setPwd(rs.getString(3));
			s.setNm(rs.getString(4));
			s.setSex(rs.getString(5));
			s.setUsrGroup(rs.getString(6));
		}
		//关闭连接
		JdbcUtil.release(conn);
		return s;
	}

	public User queryByLogin(String cardNo, String pwd) throws SQLException {
		User a=null;
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//准备sql
		String sql="select * from usr1 where usrnm='"+cardNo+"' and pwd='"+pwd+"'";
		//获取PreparedStatement
		PreparedStatement ps=conn.prepareStatement(sql);
		//执行sql
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			a=new User();
			a.setId(rs.getInt(1));
			a.setUsrnm(rs.getString(2));
			a.setPwd(rs.getString(3));
			a.setNm(rs.getString(4));
			a.setSex(rs.getString(5));
			a.setUsrGroup(rs.getString(6));
		}
		//关闭连接
		JdbcUtil.release(conn);
		return a;
	}

}
