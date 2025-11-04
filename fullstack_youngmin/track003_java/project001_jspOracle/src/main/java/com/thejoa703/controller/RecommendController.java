package com.thejoa703.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("*.rec")
public class RecommendController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RecommendController() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String path = request.getServletPath();
		System.out.println(path);
/*
		RecommendService service = null;

		if (path.equals("")) {
			service = new RecommendInsert();
			service.exec(request, response);
			String result = (String) request.getAttribute("result");
			if ("1".equals(result)) {
				out.print("<script>alert('추천 등록 성공!'); location.href='list.rec';</script>");
			} else {
				out.print("<script>alert('추천 등록 실패!'); history.go(-1);</script>");
			}

		} else if (path.equals("")) {
			service = new RecommendList();
			service.exec(request, response);
			request.getRequestDispatcher("recommend/recommendList.jsp").forward(request, response);

		} else if (path.equals("/insertView.rec")) {
			request.getRequestDispatcher("recommend/recommendInsert.jsp").forward(request, response);
			
		}
		*/
	}
}
