<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>

<div class="container card my-5">
  <h3 class="card-header">📋 추천 목록</h3>
  <div class="container mt-3">
    <a href="regForm.recommend" class="btn btn-primary mb-3">추천 등록하기</a>

    <table class="table table-dark table-striped">
      <thead>
        <tr>
          <th scope="col">NO</th>
          <th scope="col">사용자 ID</th>
          <th scope="col">음식 ID</th>
          <th scope="col">추천 유형</th>
          <th scope="col">피드백</th>
          <th scope="col">추천일시</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="dto" items="${list}" varStatus="status">
          <tr>
            <td>${ list.size() - status.index }</td>
            <td>${dto.id}</td>
            <td>${dto.foodId}</td>
            <td>${dto.type}</td>
            <td>
              <a href="<%=request.getContextPath()%>/recommend.recommend?id=${dto.recId}">
                ${dto.feedback}
              </a>
            </td>
            <td>${dto.createdAt}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <% if(email != null){ %>
      <p class="text-end">
        <a href="${pageContext.request.contextPath}/writeView.do" class="btn btn-primary">글쓰기</a>
      </p>
    <% } else { %>
      <p class="alert alert-primary">로그인 해주세요</p>
    <% } %>
  </div>
</div>

<%@ include file="../inc/footer.jsp" %>