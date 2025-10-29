package com.company.jsp009Servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletBasic3_LifeCycle
 */
@WebServlet("/ServletBasic3_LifeCycle")
public class ServletBasic3_LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	int initCnt = 1;  // init 맨처음 한번만
 	int doGetCnt = 1; //Thread-get/post
	int destroyCnt =1; //destroy 맨마지막 한번만
    public ServletBasic3_LifeCycle() { super();  }	
	public void init(ServletConfig config) throws ServletException {	
	    System.out.println("#1. init() 첫요청에만 호출 > " + initCnt++);
	    }	
	public void destroy() {	 System.out.println("#3. destroy() 첫요청에만 호출 > " + destroyCnt++);	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Good :Day").append(request.getContextPath());
		System.out.println("#2.                       호출될때마다...재사용> " + doGetCnt++);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
