<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../inc/header.jsp" %>

<div class="container card my-5">
  <h3 class="card-header text-danger">추천 삭제 확인</h3>
  <form action="delete.recommend" method="post">
    <c:choose>
      <c:when test="${empty dto}">
        <div class="alert alert-danger mt-3">삭제할 추천 데이터를 찾을 수 없습니다.</div>
        <div class="mb-3">
          <a href="${pageContext.request.contextPath}/recommendAll.recommend" class="btn btn-secondary form-control">목록으로</a>
        </div>
      </c:when>
      <c:otherwise>
        <div class="alert alert-warning mt-3">
          <strong>${dto.recId}</strong>번 추천을 정말 삭제하시겠습니까?
        </div>

        <input type="hidden" name="recId" value="${dto.recId}">

        <div class="mb-3 mt-4">
          <button type="submit" class="btn btn-danger form-control">삭제하기</button>
        </div>
        <div class="mb-3">
          <a href="${pageContext.request.contextPath}/recommend.recommend?recId=${dto.recId}" class="btn btn-secondary form-control">취소</a>
        </div>
      </c:otherwise>
    </c:choose>
  </form>
</div>

<%@ include file="../inc/footer.jsp" %>
