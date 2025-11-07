<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>

<div class="container card  my-5">
  <h3  class="card-header"> MBTI BOARD </h3>
	<div class="container mt-3">   
	  <table class="table table-dark table-striped">
	    <thead>
	      <tr>
	        <th scope="col">NO</th>
	        <th scope="col">TITLE</th>
	        <th scope="col">NAME</th>
	        <th scope="col">DATE</th>
	        <th scope="col">HIT</th>
	      </tr>
	    </thead>
      	<tbody> 
	      	<c:forEach  var="dto"  items="${list}"  varStatus="status">
	      		<tr>	
	      			<td>${ list.size() - status.index }</td>
	      			<td>
	      				<a href="<%=request.getContextPath()%>/detail.do?id=${dto.id}">
	      					${dto.title}
	      				</a>
	      			</td>
	      			<td>${dto.email}</td>
	      			<td>${dto.createdAt}</td>
	      			<td>${dto.hit}</td>
	      		</tr>
	      	</c:forEach>
      	</tbody>
	  </table>
	  <% if(email!=null){   %>
  		<P class="text-end" >
  		<a href="${pageContext.request.contextPath}/writeView.do" class="btn btn-primary">글쓰기</a>
  		</P>
  		<% }else{ %>
  		<p class="alert alert-primary">로그인을 하면 글쓰기 가능합니다 </p>
  		<% } %>
 </div>
</div>
   
<%@ include file="../inc/footer.jsp" %>

