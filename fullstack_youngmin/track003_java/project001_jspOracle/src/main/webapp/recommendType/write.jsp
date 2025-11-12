<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>

<div class="container card my-5">
  <h3 class="card-header">음식 추천 등록하기</h3>
  <form action="<%=request.getContextPath()%>/reg.recommend" method="post">
    <input type="hidden" name="id" value="101">
    <input type="hidden" name="foodId" value="100001">
  
     
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

    <div class="mb-3">
      <label for="feedback" class="form-label">피드백</label>
      <textarea class="form-control" id="feedback" name="feedback" placeholder="피드백을 입력해주세요 (추후 AI 연동)" rows="3"></textarea>
    </div>

    <button type="submit" class="btn btn-primary">추천 음식 보기</button>
    <a href="<%=request.getContextPath()%>/recommendAll.recommend" class="btn btn-secondary">목록보기</a>
  </form>
</div>

<%@ include file="../inc/footer.jsp" %>