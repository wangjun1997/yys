package cn.wangjun.yys.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wangjun.yys.entity.Liuyan;

import cn.wangjun.yys.service.LiuyanSerivce;

import cn.wangjun.yys.service.impl.LiuyanSerivceImpl;
import cn.wangjun.yys.utils.PageUtil;

/**
 * Servlet implementation class LiuyanServlet
 */
public class LiuyanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LiuyanSerivce ls = new LiuyanSerivceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LiuyanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if("load".equals(action))
			doGetLiuyan(request, response);
		else if("add".equals(action)){
			doLiuyan(request, response);
		}
		
	}

	private void doLiuyan(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String content = request.getParameter("content");
		String uname = request.getParameter("uname");
		
		int res = ls.addOneLiuyan(content,uname);
		if(res>0){
			request.setAttribute("zt", "留言成功");
		}else{
			request.setAttribute("zt", "留言失败");
		}
		doGetLiuyan(request, response);
	}

	private void doGetLiuyan(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String curr = request.getParameter("curr");
		//System.out.println("curr="+curr);
		PageUtil p = new PageUtil();
		p.setPageCount(3); //每页显示3条
		p.setTotalCount(ls.getAllCount());
		p.setTotalPages((p.getTotalCount()+p.getPageCount()-1)/p.getPageCount());
		if(curr==null){ //从首页进来
			p.setCurrPage(1);	
			List<Liuyan> list = ls.getAllLiuyan(p);
			System.out.println("list.size"+list.size());
			for (Liuyan liuyan : list) {
				System.out.println(liuyan);
			}
			request.setAttribute("page", p);
			request.setAttribute("liuyanList1", list);
			request.getRequestDispatcher("liuyanban.jsp").forward(request, response);
		}else{
			p.setCurrPage(Integer.parseInt(curr));
			List<Liuyan> list = ls.getAllLiuyan(p);
			request.setAttribute("page", p);
			request.setAttribute("liuyanList1", list);
			System.out.println("123");
			request.getRequestDispatcher("liuyanban2.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
