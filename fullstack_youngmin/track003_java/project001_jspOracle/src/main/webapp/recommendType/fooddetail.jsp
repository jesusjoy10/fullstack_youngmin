<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../inc/header.jsp" %>

<div class="container my-5">
  <h3 class="mb-4">🍽️ 음식 등록 완료</h3>
  <table class="table table-bordered">
    <tr><th>음식명</th><td>${dto.name}</td></tr>
    <tr><th>카테고리 ID</th><td>${dto.categoryId}</td></tr>
    <tr><th>칼로리</th><td>${dto.kcal} kcal</td></tr>
    <tr><th>단백질</th><td>${dto.protein} g</td></tr>
    <tr><th>탄수화물</th><td>${dto.carb} g</td></tr>
    <tr><th>지방</th><td>${dto.fat} g</td></tr>
    <tr><th>설명</th><td>${dto.recipe}</td></tr>
    <tr><th>이미지</th><td><img src="${dto.imageUrl}" width="200" /></td></tr>
  </table>
  <a href="${pageContext.request.contextPath}/foodList.recommend" class="btn btn-secondary">← 목록으로</a>
</div>

<%@ include file="../inc/footer.jsp" %>
