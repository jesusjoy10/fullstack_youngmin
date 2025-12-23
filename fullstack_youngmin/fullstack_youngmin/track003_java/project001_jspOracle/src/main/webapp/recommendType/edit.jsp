<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container card my-5 p-4">
  <h3 class="card-header">추천 수정하기</h3>

  <form action="${pageContext.request.contextPath}/update.recommend" method="post">
    <!-- 추천 번호 -->
    <input type="hidden" name="tableId" value="${dto.tableId}" />


    <!-- 음식 ID -->
    <div class="mb-3">
      <label for="foodId" class="form-label">음식 ID:</label>
      <input type="number" class="form-control" id="foodId" name="foodId" value="${dto.foodId}" required />
    </div>

   <%--  <!-- 추천 유형 -->
    <div class="mb-3">
      <label for="type" class="form-label">추천 유형:</label>
      <select class="form-select" id="type" name="type" required>
        <option value="오늘의추천" ${dto.type == '오늘의추천' ? 'selected' : ''}>오늘의추천</option>
        <option value="재료기반" ${dto.type == '재료기반' ? 'selected' : ''}>재료기반</option>
        <option value="AI" ${dto.type == 'AI' ? 'selected' : ''}>AI</option>
      </select>
    </div> --%>
    
     <div class="mb-3">
      <label for="type" class="form-label">음식 대분류</label>
      <select class="form-select" id="type" name="type" required>
        <option value="한식">한식</option>
        <option value="양식">양식</option>
        <option value="일식">일식</option>
        <option value="중식">중식</option>
        <option value="분식">분식</option>
        <option value="디저트">디저트</option>
      </select>
    </div>

    <!-- 대분류 -->
       <div class="mb-3">
      <label for="type" class="form-label">음식 종류</label>
      <select class="form-select" id="category" name="category" required>
        <option value="육류">육류</option>
        <option value="해산물">해산물</option>
        <option value="면류">면류</option>
        <option value="채소류">채소류</option>   
      </select>
    </div>
   

      <div class="mb-3">
      <label for="type" class="form-label">음식 조리방식</label>
      <select class="form-select" id="kind" name="kind" required>
        <option value="볶음">볶음</option>
        <option value="구이">구이</option>
        <option value="튀김">튀김</option>
        <option value="찜">찜</option>   
        <option value="조림">조림</option>
        <option value="튀김">튀김</option>
      </select>
    </div>
    
     <div class="mb-3">
      <label for="type" class="form-label">상황/목적</label>
      <select class="form-select" id="method" name="method" required>
        <option value="간단식">간단식</option>
        <option value="가족식">가족식</option>
        <option value="건강식">건강식</option>
        <option value="야식">야식</option>   
        <option value="섹시푸드">섹시푸드</option>      
      </select>
    </div>

    <!-- 피드백 -->
    <div class="mb-3">
      <label for="feedback" class="form-label">피드백:</label>
      <textarea class="form-control" id="feedback" name="feedback" rows="6" placeholder="피드백을 입력해주세요">${dto.feedback}</textarea>
    </div>

    <!-- 버튼 -->
    <div class="mb-3 text-end">
      <button type="submit" class="btn btn-primary">추천 수정</button>
      <a href="${pageContext.request.contextPath}/detail.recommend?tableId=${dto.tableId}" class="btn btn-danger">돌아가기</a>
    </div>
  </form>
</div>

<%@ include file="../inc/footer.jsp" %>