<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../inc/header.jsp" %>

<div class="container card my-5">
  <h3 class="card-header">📋 오늘의 섹시푸드</h3>
  <div class="container mt-3">
    <a href="regForm.recommend" class="btn btn-primary mb-3">섹시푸드 추천 받으려면 Click</a>

    <table class="table table-dark table-striped">
      <thead>
        <tr>
          <th scope="col">NO</th>
          <th scope="col">음식 ID</th>
          <th scope="col">피드백</th>
          <th scope="col">추천 음식</th>         
          <th scope="col">추천일시</th>
           <th scope="col">삭제</th> <!-- 삭제 버튼 컬럼 추가 -->
          
        </tr>
      </thead>
      <tbody>
        <c:forEach var="dto" items="${list}" varStatus="status">
          <tr>
            <td>${list.size() - status.index}</td>
            <td>
              <a href="<%=request.getContextPath()%>/user.recommend?tableId=${dto.tableId}">
                ${dto.foodId}
              </a>
            </td>          
            <td>${dto.feedback}</td>
            <td>${dto.type}</td>
            <td>${dto.createdAt}</td>
        <td>
          <form action="${pageContext.request.contextPath}/delete.recommend" method="post" onsubmit="return confirm('정말 삭제할까요?');">
            <input type="hidden" name="tableId" value="${dto.tableId}" />
            <button type="submit" class="btn btn-sm btn-danger">삭제</button>   <!-- 각 행마다 삭제버튼  -->
          </form>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>


   
  </div>
</div>

<%@ include file="../inc/footer.jsp" %>
