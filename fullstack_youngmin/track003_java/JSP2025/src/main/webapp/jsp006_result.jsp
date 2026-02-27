<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>로그인 결과</title>
  <!-- Latest compiled and minified CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Latest compiled JavaScript -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
  <div class="container card my-5">
    <h3 class="card-header">로그인 결과</h3>
    <pre class="alert alert-success my-3">
1. 처리할 경로 : jsp006_result.jsp
2. 주소표시줄에 노출 안됨 (POST 방식)
3. 보관용기 이름 : email / password
    </pre>

    <%
      String email = request.getParameter("email");
      String password = request.getParameter("password");
    %>
   
      <p>이메일:<%= email %></p>
      <p>비밀번호: <%= password %></p>
    </div>
  </div>
</body>
</html>
