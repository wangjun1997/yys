package cn.wangjun.yys.utils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 重写父类service方法
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		//this是谁调用指向谁
		Class clazz = this.getClass();
		try {
			Method m = clazz.getDeclaredMethod(method,HttpServletRequest.class,HttpServletResponse.class);
			m.setAccessible(true);
			
			
			
			String result = m.invoke(this, request,response).toString();
			
			
			if(result.startsWith("redirect:")){
				response.sendRedirect(result.substring(result.indexOf(':')+1));
			}else if(result.startsWith("ajax:")){
				response.getWriter().write(result.substring(result.indexOf(':')+1));
			}else{
				request.getRequestDispatcher(result).forward(request, response);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	protected <T> T  parseRequset(Class<T> clazz,HttpServletRequest request, HttpServletResponse response) {
		T t =null;
		try {
			Map<String, String[]> map1 = new HashMap<String, String[]>();
			Map<String, String> map2 = new HashMap<String, String>();
			map1 = request.getParameterMap();
			
			/*Field[] fs = clazz.getDeclaredFields();
			for (Field field : fs) {
				field.setAccessible(true);
				String v = Arrays.toString(map1.get(field.getName()));
				map2.put(field.getName(), v.substring(1,v.length()-1));
			}*/
			Set<Entry<String, String[]>> set2 = map1.entrySet();
			for (Entry<String, String[]> e : set2) {
				String values1 = Arrays.toString(e.getValue());
				map2.put(e.getKey(), values1.substring(1,values1.length()-1));
			}
			
			
			t= clazz.newInstance();
			BeanUtils.populate(t, map2);
			System.out.println(t);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}
}
