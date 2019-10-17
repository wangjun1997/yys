package cn.wangjun.yys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class BaseDao {
	
	 protected Connection conn =null;
	 protected PreparedStatement ps = null;
	 protected ResultSet rs = null;
	 protected static ComboPooledDataSource cpds = new ComboPooledDataSource();
	public  Connection getConnection(){
		try {
			conn = cpds.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}

	public  ResultSet query(String sql,Object...objects){
		try {
			
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			if(objects!=null&&objects.length>0){
				for (int i = 0; i < objects.length; i++) {
					ps.setObject(i+1, objects[i]);
				}
			}
			rs = ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	public int update(String sql,Object...obs){
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			if(obs!=null&&obs.length>0){
				for (int i = 0; i < obs.length; i++) {
					ps.setObject(i+1, obs[i]);
				}
			}
			int len = ps.executeUpdate();
			return len;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}	
	public static void close(AutoCloseable...cs){
		if(cs!=null)
		for (AutoCloseable a : cs) {
			try {
				if(a!=null)
				a.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
