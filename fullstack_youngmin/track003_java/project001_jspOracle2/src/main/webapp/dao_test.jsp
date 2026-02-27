<%@page import="com.thejoa703.dto.SerchDto"%>
<%@page import="com.thejoa703.dao.SerchDao"%>
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
      <h3  class="card-header">  INSERT</h3>
  <%--       <%
      PostDao dao = new PostDao();
      PostDto dto = new PostDto();
      dto.setId("user01");
      dto.setFoodId(100001);
      dto.setType("AI");
      dto.setFeedback("단백질부족");
      out.println(dao.insert(dto));      
      %>   --%>  
      <h3  class="card-header">SELECT</h3>
     <%--   <%
      PostDao dao = new PostDao();
      out.println(dao.selectAll());
      %>  --%>
       
      <h3  class="card-header">  SELECT</h3>
       <%-- <%
      PostDao dao = new PostDao(); 
      out.println(dao.selectByUser("user01"));
      %>    --%>
      <h3  class="card-header">  DELETE</h3>
      <%
      

                  SerchDao dao = new SerchDao(); // recId = 1 삭제
                  SerchDto dto = new SerchDto();
                  dto.setRecId(4);
            	  dto.setId(1);
            	  out.println(dao.delete(dto));
      %>  
      

   </div>
</body>
</html>

<!-- /* INSERT INTO Recommend_tb (recId, id, foodId, type, feedback)  
VALUES (RECOMMEND_TB_seq.nextval, 'user01', 100001, 'AI', '단백질부족' );

SELECT * FROM Recommend_tb order BY createdAt desc;

SELECT * FROM Recommend_tb where id = 'user01'  ;

DELETE FROM Recommend_tb where recId = 1;*/
 -->