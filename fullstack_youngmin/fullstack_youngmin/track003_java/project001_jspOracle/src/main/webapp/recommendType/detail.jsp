<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../inc/header.jsp" %>

<div class="container card my-5">
  <h3 class="card-header">📋 추천 상세보기</h3>
  <div class="container mt-3">

    <table class="table table-dark table-striped">
      <tr><th scope="row">추천 번호</th><td>${dto.tableId}</td></tr>
      <tr><th scope="row">사용자 ID</th><td>${dto.id}</td></tr>
      <tr><th scope="row">음식 ID</th><td>${dto.foodId}</td></tr>
      <tr><th scope="row">추천 유형</th><td>${dto.type}</td></tr>
      <tr><th scope="row">대분류</th><td>${dto.category}</td></tr>
      <tr><th scope="row">종류</th><td>${dto.kind}</td></tr>
      <tr><th scope="row">조리 방식</th><td>${dto.method}</td></tr>
      <tr><th scope="row">피드백</th><td>${dto.feedback}</td></tr>
      <tr><th scope="row">추천일시</th><td>${dto.createdAt}</td></tr>
      <tr>
        <th scope="row">관리</th>
        <td>        
          <a href="${pageContext.request.contextPath}/delete.recommend?tableId=${dto.tableId}" class="btn btn-danger">삭제</a>
        </td>
      </tr>
    </table>

  <a href="${pageContext.request.contextPath}/recommendAll.recommend" class="btn btn-secondary mt-3">← 목록으로 돌아가기</a>

  </div>
</div>

<%@ include file="../inc/footer.jsp" %>





<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../inc/header.jsp" %>

<div class="container card my-5">
  <h3 class="card-header">추천 상세보기</h3>
  		
   <table class="table table-dark table-striped">
      <thead>
        <tr>
          <th scope="col">NO</th>
          <th scope="col">사용자 ID</th>
          <th scope="col">음식 ID</th>
          <th scope="col">추천 유형</th>
          <th scope="col">피드백</th>
          <th scope="col">추천일시</th>
          <th scope="col">추천삭제</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="dto" items="${list}" varStatus="status">
			<tr>
			<td>${list.size() - status.index}  </td>
			<td>${dto.id}</td>
			<td>${dto.foodId}  </td>
			<td>${dto.type}  </td>
			<td>${dto.feedback}  </td>
			<td>${dto.createdAt}  </td>
			<td><a href="<%=request.getContextPath()%>/delete.recommend?recId=${dto.recId}" class= "btn btn-danger">
	      					추천삭제 
	      				</a>
 </td>
			
			</tr>
        </c:forEach>
      </tbody>
    </table>  
</div>

<%@ include file="../inc/footer.jsp" %> --%>