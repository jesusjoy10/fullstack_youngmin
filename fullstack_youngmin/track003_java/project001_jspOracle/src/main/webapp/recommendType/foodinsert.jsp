<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../inc/header.jsp" %>

<div class="container my-5">
  <h3 class="mb-4">🍽️ 음식 등록</h3>

  <form action="${pageContext.request.contextPath}/insert.food" method="post">
    <div class="form-group mb-2">
      <input type="text" name="name" class="form-control" placeholder="음식명" required />
    </div>
    <div class="form-group mb-2">
      <input type="number" name="categoryId" class="form-control" placeholder="카테고리 ID" required />
    </div>
    <div class="form-group mb-2">
      <input type="number" name="kcal" class="form-control" placeholder="칼로리" required />
    </div>
    <div class="form-group mb-2">
      <input type="number" step="0.1" name="protein" class="form-control" placeholder="단백질" required />
    </div>
    <div class="form-group mb-2">
      <input type="number" step="0.1" name="carb" class="form-control" placeholder="탄수화물" required />
    </div>
    <div class="form-group mb-2">
      <input type="number" step="0.1" name="fat" class="form-control" placeholder="지방" required />
    </div>
    <div class="form-group mb-2">
      <textarea name="recipe" class="form-control" placeholder="조리법" rows="3"></textarea>
    </div>
    <div class="form-group mb-3">
      <input type="text" name="imageUrl" class="form-control" placeholder="이미지 URL" />
    </div>
    <button type="submit" class="btn btn-primary">등록</button>
  </form>
</div>

<%@ include file="../inc/footer.jsp" %>