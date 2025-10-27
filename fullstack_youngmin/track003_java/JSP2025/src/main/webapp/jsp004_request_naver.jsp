<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REQUEST-요청</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card  my-5">
      <h3  class="card-header">  REQUEST-요청</h3>
      <pre class="alert alert-success" >
      https://search.naver.com/search.naver?sm=tab_sug.top&where=nx&ssc=tab.nx.all&query=apple&oquery=%ED%86%A0%EB%81%BC&tqi=jn8jrwqo1LVssZT7p7dssssst8K-272339&acq=apple&acr=2&qdt=0&ackey=4mv8hen5
      1. 처리컨테이너 (해결사:action) - https://search.naver.com/search.naver 
      2. 처리방식 (GET 검색/POST 삽입: method)  - get 
      3. 보관용기(념겨줄 데이터 - 쿼리스트링: name) -  query
      </pre>
	      <form action="https://search.naver.com/search.naver "   method="get">
	  <div class="mb-3 mt-3">
	    <label for="search" class="form-label">NAVER에 물어보세요~! 검색어</label>
	    <input type="search" class="form-control" id="search" placeholder="검색어를 입력해주세요" name="query">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
   </div>
</body>
</html>
<!-- 
  CLIENT (요청 : request ) ↔ SEVER(응답 : response)
 -->