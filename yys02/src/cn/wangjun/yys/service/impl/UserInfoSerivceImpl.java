package cn.wangjun.yys.service.impl;

import java.util.List;

import cn.wangjun.yys.dao.UserInfoDao;
import cn.wangjun.yys.dao.impl.UserInfoDaoImpl;
import cn.wangjun.yys.entity.UserInfo;
import cn.wangjun.yys.service.UserInfoSerivce;

public class UserInfoSerivceImpl implements UserInfoSerivce {
	UserInfoDao ufd = new UserInfoDaoImpl();
	public List<UserInfo> getAllUser() {
		// TODO Auto-generated method stub
		List<UserInfo> list = ufd.getAllUser();
		return list;
	}

}
