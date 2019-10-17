package cn.wangjun.yys.dao.impl;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.wangjun.yys.dao.BaseDao;
import cn.wangjun.yys.dao.LiuyanDao;
import cn.wangjun.yys.entity.Liuyan;
import cn.wangjun.yys.entity.UserInfo;
import cn.wangjun.yys.utils.PageUtil;

public class LiuyanDaoImpl extends BaseDao implements LiuyanDao{

	public List<Liuyan> getAllLiuyan() {
		// TODO Auto-generated method stub
		List<Liuyan> list = new ArrayList<Liuyan>();
		try {
			String sql = "select id,content,name,time from lyb";
			rs = query(sql);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			while(rs.next()){
				Liuyan ly = new Liuyan();
				ly.setName(rs.getString("name"));
				ly.setId(rs.getInt("id"));
				ly.setContent(rs.getString("content"));
				Timestamp timestamp = rs.getTimestamp("time");
				ly.setDate(sdf.format(timestamp.getTime()));
				list.add(ly);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			close(rs,ps,conn);
		}	
		
		return list;
	}

	public int addOneLiuyan(String content, String uname) {
		// TODO Auto-generated method stub
		int s =0;
		try {
			String sql = "insert into lyb(content,name,time) values(?,?,now())";
			s = update(sql, content,uname);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			close(rs,ps,conn);
		}
		return s;
	}

	public List<Liuyan> getAllLiuyan(PageUtil p) {
		// TODO Auto-generated method stub
		List<Liuyan> list = new ArrayList<Liuyan>();
		try {
			int start = (p.getCurrPage()-1)*p.getPageCount();
			String sql = "select id,content,name,time from lyb limit ?,?";
			
			rs = query(sql,start,p.getPageCount());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			while(rs.next()){
				Liuyan ly = new Liuyan();
				ly.setName(rs.getString("name"));
				ly.setId(rs.getInt("id"));
				ly.setContent(rs.getString("content"));
				Timestamp timestamp = rs.getTimestamp("time");
				ly.setDate(sdf.format(timestamp.getTime()));
				list.add(ly);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			close(rs,ps,conn);
		}	
		return list;
	}

	public Integer getAllCount() {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			
			String sql = "select count(*) from lyb";
			rs = query(sql);
			while(rs.next()){
				result = rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			close(rs,ps,conn);
		}	
		return result;
	}

}
