<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card  my-5">
      <h3  class="card-header"> 로그인 </h3>
      <pre class="alert alert-success my-3">
      1. 처리할 경로 : jsp006_result.jsp
      2. 주소표시창줄에 노출 안됨
      3. 보관용기이름 :  email   / password
      </pre>
      
    <form action="jsp006_result.jsp" method="post" class="p-4">
      <div class="mb-3">
        <label for="email" class="form-label">이메일:</label>
        <input type="email" class="form-control" id="email" name="email" required placeholder="이메일 입력">
      </div>

      <div class="mb-3">
        <label for="password" class="form-label">비밀번호:</label>
        <input type="password" class="form-control" id="password" name="password" required placeholder="비밀번호 입력">
      </div>

      <button type="submit" class="btn btn-primary">로그인</button>
    </form>
  </div>
</body>
</html>
