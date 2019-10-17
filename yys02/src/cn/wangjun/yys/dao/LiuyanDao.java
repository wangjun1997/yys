package cn.wangjun.yys.dao;

import java.util.List;

import cn.wangjun.yys.entity.Liuyan;
import cn.wangjun.yys.utils.PageUtil;

public interface LiuyanDao {

	List<Liuyan> getAllLiuyan();

	int addOneLiuyan(String content, String uname);

	List<Liuyan> getAllLiuyan(PageUtil p);

	Integer getAllCount();

}
