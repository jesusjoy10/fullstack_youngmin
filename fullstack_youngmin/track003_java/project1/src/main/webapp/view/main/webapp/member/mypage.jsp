<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ include file="../inc/header.jsp" %>
<!-- Header --><!-- Header --><!-- Header --><!-- Header --><!-- Header --><!-- Header --><!-- Header --><!-- Header -->
<!-- Header --><!-- Header --><!-- Header --><!-- Header --><!-- Header --><!-- Header --><!-- Header --><!-- Header -->
<!-- Header --><!-- Header --><!-- Header --><!-- Header --><!-- Header --><!-- Header --><!-- Header --><!-- Header -->

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
      <h3  class="card-header">  </h3>
      <%@page import="java.sql.*"%>
      <%
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String pass = "tiger";
		String EMAIL=""; int MBTI_TYPE_ID=0; String CREATED_AT="";
		String mbti ="";
	 
		int App_USER_ID = Integer.parseInt(request.getParameter("APP_USER_ID"));
		
		try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pass);
		String sql = "select * from appuser where App_USER_ID=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, App_USER_ID);
		
		//pstmt.executeQuery() pstmt.executeUpdate()
		rset = pstmt.executeQuery();
		while(rset.next()){
			EMAIL = rset.getString("EMAIL");
			MBTI_TYPE_ID = rset.getInt("MBTI_TYPE_ID");
			CREATED_AT = rset.getString("CREATED_AT");
		}
		
		// Q1.MBTI_TYPE_ID 1이라면, 2라면, 3이라면		
		switch(MBTI_TYPE_ID){
	    case 1: mbti = "ISTJ"; break;
	    case 2: mbti = "ISFJ"; break;
	    case 3: mbti = "INFJ"; break;
	    case 4: mbti = "INTJ"; break;
	    case 5: mbti = "ISTP"; break;
	    case 6: mbti = "ISFP"; break;
	    case 7: mbti = "INFP"; break;
	    case 8: mbti = "INTP"; break;
	    case 9: mbti = "ESTP"; break;
	    case 10: mbti = "ESFP"; break;
	    case 11: mbti = "ENFP"; break;
	    case 12: mbti = "ENTP"; break;
	    case 13: mbti = "ESTJ"; break;
	    case 14: mbti = "ESFJ"; break;
	    case 15: mbti = "ENFJ"; break;
	    case 16: mbti = "ENTJ"; break;
	    default: mbti = "Unknown";
		}
		
		
		}catch(Exception e){e.getMessage();
		}finally{
			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}	
		%>
		
		  <table class="table table-striped table-bordered table-hover">
		    <thead class="table-dark">
		        <tr><th scope="row">Email</th> 	   <td><%=EMAIL%></td></tr>
		        <tr><th scope="row">MBTI TYPE</th> <td><%=mbti%></td></tr>
		        <tr><th scope="row">회원가입 날짜</th> <td><%=CREATED_AT%></td></tr>
		    </thead>
		  </table>
	</div>
</body>
</html>

<!-- Footer --><!-- Footer --><!-- Footer --><!-- Footer --><!-- Footer --><!-- Footer --><!-- Footer --><!-- Footer -->
<!-- Footer --><!-- Footer --><!-- Footer --><!-- Footer --><!-- Footer --><!-- Footer --><!-- Footer --><!-- Footer -->
<!-- Footer --><!-- Footer --><!-- Footer --><!-- Footer --><!-- Footer --><!-- Footer --><!-- Footer --><!-- Footer -->
<%@ include file="../inc/footer.jsp" %>