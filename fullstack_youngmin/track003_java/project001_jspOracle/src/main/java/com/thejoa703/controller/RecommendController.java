package com.thejoa703.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thejoa703.service.RecommendDelete;
import com.thejoa703.service.RecommendDetail;
import com.thejoa703.service.RecommendSelectAll;
import com.thejoa703.service.RecommendService;
import com.thejoa703.service.RecommendUpdate;
import com.thejoa703.service.Recommendwrite;

// 🔹 음식 등록 서비스 클래스 import 추가
import com.thejoa703.service.FoodInsert;

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

		RecommendService service = null;

		if(path.equals("/regForm.recommend")) {
			request.getRequestDispatcher("/recommendType/write.jsp").forward(request, response);

		}else if(path.equals("/reg.recommend")) {
			service = new Recommendwrite();
			service.exec(request, response);
			out.println("<script>alert('등록했습니다.'); location.href='recommendAll.recommend'; </script>");

		}else if(path.equals("/recommendAll.recommend")) {
			service = new RecommendSelectAll();
			service.exec(request, response);
			request.getRequestDispatcher("/recommendType/list.jsp").forward(request, response);

		}else if(path.equals("/user.recommend")) {
			service = new RecommendDetail();
			service.exec(request, response);
			request.getRequestDispatcher("/recommendType/detail.jsp").forward(request, response);

		}else if(path.equals("/edit.recommend")) {
			service = new RecommendDetail();
			service.exec(request, response);
			request.getRequestDispatcher("/recommendType/edit.jsp").forward(request, response);

		}else if(path.equals("/update.recommend")) {
			service = new RecommendUpdate();
			service.exec(request, response);
			out.println("<script>alert('수정했습니다.'); location.href='recommendAll.recommend'; </script>");

		}else if(path.equals("/delete.recommend")) {
		    service = new RecommendDelete();
		    service.exec(request, response);

		    Integer result = (Integer) request.getAttribute("deleteResult"); // 삭제 결과 받기

		    if(result != null && result > 0) {
		        out.println("<script>alert('삭제했습니다.'); location.href='recommendAll.recommend'; </script>");
		    } else {
		        out.println("<script>alert('삭제 실패'); history.go(-1); </script>");
		    }
		


		// 🔹 음식 등록 처리 추가
		}else if(path.equals("/insert.food")) {
			service = new FoodInsert();
			service.exec(request, response);
		}
	}
}