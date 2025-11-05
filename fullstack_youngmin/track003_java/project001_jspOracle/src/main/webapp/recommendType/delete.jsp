<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../inc/header.jsp" %>

<div class="container card my-5">
  <h3 class="card-header">📋 추천 상세 정보</h3>
  <form action="recommend.recommend" method="post">
    <c:choose>
      <c:when test="${empty dto}">
        <div class="alert alert-danger mt-3">추천 데이터를 찾을 수 없습니다.</div>
        <div class="mb-3">
          <a href="${pageContext.request.contextPath}/recommendAll.recommend" class="btn btn-secondary form-control">목록으로</a>
        </div>
      </c:when>
      <c:otherwise>
        <div class="mb-3 mt-3">
          <label for="recId" class="form-label">추천 번호</label>
          <input type="text" class="form-control" id="recId" name="recId" readonly value="${dto.recId}">
        </div>
        <div class="mb-3">
          <label for="id" class="form-label">사용자 ID</label>
          <input type="text" class="form-control" id="id" name="id" readonly value="${dto.id}">
        </div>
        <div class="mb-3">
          <label for="foodId" class="form-label">음식 ID</label>
          <input type="text" class="form-control" id="foodId" name="foodId" readonly value="${dto.foodId}">
        </div>
        <div class="mb-3">
          <label for="type" class="form-label">추천 유형</label>
          <input type="text" class="form-control" id="type" name="type" readonly value="${dto.type}">
        </div>
        <div class="mb-3">
          <label for="feedback" class="form-label">피드백</label>
          <textarea class="form-control" id="feedback" name="feedback" readonly>${dto.feedback}</textarea>
        </div>
        <div class="mb-3">
          <label for="createdAt" class="form-label">추천 일시</label>
          <input type="text" class="form-control" id="createdAt" name="createdAt" readonly value="${dto.createdAt}">
        </div>

        <div class="mb-3">
          <a href="${pageContext.request.contextPath}/recommendAll.recommend" class="btn btn-secondary form-control">목록으로</a>
        </div>
        <div class="mb-3">
          <a href="${pageContext.request.contextPath}/updateForm.recommend?recId=${dto.recId}" class="btn btn-warning form-control">수정하기</a>
        </div>
        <div class="mb-3">
          <a href="${pageContext.request.contextPath}/delete.recommend?recId=${dto.recId}" class="btn btn-danger form-control">삭제하기</a>
        </div>
      </c:otherwise>
    </c:choose>
  </form>
</div>

<%@ include file="../inc/footer.jsp" %>