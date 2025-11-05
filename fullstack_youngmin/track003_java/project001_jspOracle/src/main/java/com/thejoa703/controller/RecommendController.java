package com.thejoa703.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thejoa703.service.RecommendDelete;
import com.thejoa703.service.RecommendInsert;
import com.thejoa703.service.RecommendSelect;
import com.thejoa703.service.RecommendSelectAll;
import com.thejoa703.service.RecommendService;




@WebServlet("*.recommend")
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
		
		RecommendService service = null;   //##
		
		 if(path.equals("/regForm.recommend")) {
				request.getRequestDispatcher("/recommendType/write.jsp").forward(request, response);

		 }else if(path.equals("/reg.recommend")) {
				service = new RecommendInsert();
				service.exec(request, response);
				out.println("<script>alert('등록했습니다.'); location.href='recommendAll.recommend'; </script>");

		 }else if(path.equals("/recommendAll.recommend")) {
				service = new RecommendSelectAll();
				service.exec(request, response);
				request.getRequestDispatcher("/recommendType/list.jsp").forward(request, response);

		 }else if(path.equals("/recommend.recommend")) {
				service = new RecommendSelect();
				service.exec(request, response);
				request.getRequestDispatcher("/recommendType/detail.jsp").forward(request, response);

		 }else if(path.equals("/updateForm.recommend")) {
				// 수정 폼 보여줄 때도 RecommendSelect 사용 가능
				service = new RecommendSelect();
				service.exec(request, response);
				request.getRequestDispatcher("/recommendType/edit.jsp").forward(request, response);

		 }else if(path.equals("/update.recommend")) {
				service = new RecommendInsert(); // 수정용 클래스가 없으니 임시로 insert 사용
				service.exec(request, response);
				out.println("<script>alert('수정했습니다.'); location.href='recommend.recommend'; </script>");

		 }else if(path.equals("/delete.recommend")) {
				service = new RecommendDelete();
				service.exec(request, response);
				out.println("<script>alert('삭제했습니다.'); location.href='recommendAll.recommend'; </script>");
		 }
		}
	}


