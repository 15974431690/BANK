package com.hodo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hodo.model.Log;
import com.hodo.util.JdbcUtil;

public class LogDao {
	
	public void add(Log s) throws SQLException {
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//准备sql
		String sql="insert into log values(null,?,DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%S'),?)";
		//获取PreparedStatement
		PreparedStatement ps=conn.prepareStatement(sql);
		//填充占位符
		ps.setString(1, s.getContent());
		ps.setInt(2, s.getUserId());
		//执行sql
		ps.executeUpdate();
		//关闭连接
		JdbcUtil.release(conn);
	}
	
	public void detele(int id) throws SQLException {
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//准备sql
		String sql="delete from log where id=?";
		//获取PreparedStatement
		PreparedStatement ps=conn.prepareStatement(sql);
		//填充占位符
		ps.setInt(1, id);
		//执行sql
		ps.executeUpdate();
		//关闭连接
		JdbcUtil.release(conn);
	}
	
	public void update(Log s) throws SQLException {
		Connection conn = JdbcUtil.getConnection();
		String sql="update log set content=? where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ps.setString(1, s.getContent());
		ps.setInt(2, s.getUserId());
		
		ps.executeUpdate();
		JdbcUtil.release(conn);
	}
	
	public List<Log> queryAll() throws SQLException{
		List<Log> log=new ArrayList<>();
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//准备sql
		String sql="select * from log";
		//获取PreparedStatement
		PreparedStatement ps=conn.prepareStatement(sql);
		//执行sql
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Log s=new Log();
			
			s.setId(rs.getInt(1));
			s.setContent(rs.getString(2));
			s.setDt(rs.getString(3));
			s.setUserId(rs.getInt(4));
			
			log.add(s);
		}
		//关闭连接
		JdbcUtil.release(conn);
		return log;
	}
	public Log queryOne(Integer id) throws SQLException{
		
		Log s=null;
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//准备sql
		String sql="select * from log where id="+id;
		//获取PreparedStatement
		PreparedStatement ps=conn.prepareStatement(sql);
		//执行sql
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			s=new Log();
			s.setId(rs.getInt(1));
			s.setContent(rs.getString(2));
			s.setDt(rs.getString(3));
			s.setUserId(rs.getInt(4));
		}
		//关闭连接
		JdbcUtil.release(conn);
		return s;
	}


}
