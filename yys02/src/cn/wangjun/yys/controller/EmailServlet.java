package cn.wangjun.yys.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wangjun.yys.utils.BaseServlet;
import cn.wangjun.yys.utils.SendMailUtil;

/**
 * Servlet implementation class EmailServlet
 */
public class EmailServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
   
	public String sendMail(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String vcode = (int)(1000+Math.random()*8999)+"";
		System.out.println(vcode);
		Cookie c = new Cookie("vcode", URLEncoder.encode(vcode, "utf-8"));
		c.setMaxAge(60);
		response.addCookie(c);
		String mail = request.getParameter("mail");
		String text = "欢迎您注册万物嘤嘤师,您本次的验证码为:"+vcode; 
		SendMailUtil.sendCommonMail(mail,"万物嘤嘤师验证码",text);
		return "#";
	}
	public String check(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String incode = request.getParameter("incode");
		String mycode = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if("vcode".equals(cookie.getName())){
				mycode = cookie.getValue();
			}
		}
		if(mycode==null){
			response.getWriter().write("alert('验证码过期')");
			System.out.println(0);
		}else{
			if(mycode.equals(incode)){
				response.getWriter().write("alert('OK')");
				System.out.println(1);
			}else{
				response.getWriter().write("alert('验证码错误')");
				System.out.println(-1);
			}
		}
		return "#";
	}
	
	
}
