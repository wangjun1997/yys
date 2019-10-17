package cn.wangjun.yys.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.wangjun.yys.dao.BaseDao;
import cn.wangjun.yys.dao.UserInfoDao;
import cn.wangjun.yys.entity.UserInfo;

public class UserInfoDaoImpl extends BaseDao implements UserInfoDao {

	public List<UserInfo> getAllUser() {
		// TODO Auto-generated method stub
		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			String sql = "select name,roleId,level,icon from user";
			rs = query(sql);
			while(rs.next()){
				UserInfo ui = new UserInfo();
				ui.setName(rs.getString("name"));
				ui.setRoleid(rs.getString("roleId"));
				ui.setLevel(rs.getString("level"));
				ui.setIcon(rs.getString("icon"));
				list.add(ui);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

}
