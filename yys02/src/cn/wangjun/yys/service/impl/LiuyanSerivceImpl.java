package cn.wangjun.yys.service.impl;

import java.util.List;

import cn.wangjun.yys.dao.LiuyanDao;
import cn.wangjun.yys.dao.impl.LiuyanDaoImpl;
import cn.wangjun.yys.entity.Liuyan;
import cn.wangjun.yys.service.LiuyanSerivce;
import cn.wangjun.yys.utils.PageUtil;

public class LiuyanSerivceImpl implements LiuyanSerivce{
	
	LiuyanDao ld = new LiuyanDaoImpl();
	
	public List<Liuyan> getAllLiuyan() {
		// TODO Auto-generated method stub
		List<Liuyan> list = ld.getAllLiuyan();
		return list;
	}

	public int addOneLiuyan(String content, String uname) {
		// TODO Auto-generated method stub
		return ld.addOneLiuyan(content,uname);
	}

	public List<Liuyan> getAllLiuyan(PageUtil p) {
		// TODO Auto-generated method stub
		return ld.getAllLiuyan(p);
	}

	public Integer getAllCount() {
		// TODO Auto-generated method stub
		return ld.getAllCount();
	}

}
