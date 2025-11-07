<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../inc/header.jsp" %>

<div class="container card my-5">
  <h3 class="card-header">추천 상세보기</h3>
  		
   <table class="table table-dark table-striped">
      <thead>
        <tr>
           <th scope="col">NO</th>
          <th scope="col">음식 ID</th>
          <th scope="col">피드백</th>
          <th scope="col">추천 음식</th>         
          <th scope="col">추천일시</th>
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

<%@ include file="../inc/footer.jsp" %>