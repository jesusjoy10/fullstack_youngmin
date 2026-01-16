<%@page import="com.company.jsp009Servlet.JavaBasic"%>
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
      <h3  class="card-header"> 001. JAVA </h3>
      <pre class= "alert alert-success">
      1. java 파일
      2. 사용
      예) Dto(전달), Dao(db연결-sql), DBManager, 필요한 api
      </pre>
      <% JavaBasic jb = new JavaBasic(10,3); %>
      <%=jb.add() %>
      
      <h3  class="card-header"> 002. SERVLET </h3>
      <pre class= "alert alert-success">
      1. java 파일- HttpServlet상속 : doGet, doPost (controller)
      2. Servlet 라이프사이클
      </pre>
      <p><a href="<%=request.getContextPath()%>/Hello1" class= "btn btn-danger">
      servlet001-GET </a>
      </p>
      <!--  post : action/method/name-->
      <form action="<%=request.getContextPath()%>/Hello1" method="post">
      <input type="submit" value="servlet001-GET" class="btn btn-danger"/>
      </form>
      <!-- lifecycle -->
      <p>
      <a href="<%=request.getContextPath()%>/ServletBasic3_LifeCycle" class= "btn btn-primary">
      LifeCycle</a>
      </p>
      
      <!-- frontcontroller -->
        <p>
      <a href="<%=request.getContextPath()%>/a.do" class= "btn btn-success">
      a.do</a>
      </p>
      
       <p>
      <a href="<%=request.getContextPath()%>/b.do" class= "btn btn-success">
      b.do</a>
      </p>
   </div>
</body>
</html>
<!--jsp009_java_servlet.jsp   -->