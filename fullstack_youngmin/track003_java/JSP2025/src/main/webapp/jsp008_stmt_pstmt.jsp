<%@page import="java.sql.*"%>
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
      <h3  class="card-header"> 001. Statement </h3>
     <pre class= "alert alert-warning">
     1. 매번 실행할 때마다 컴파일
     2. 반복실행 시 느려짐
     3. SQL 인젝션 위험 - 보안상 문제 있음. where  loc= 'INCHEON' → where loc='INCHEON' OR '1'='1'
     </pre>
     <% // 드커프리
     Connection conn = null; Statement stmt=null; ResultSet rset=null; 
     String driver = "oracle.jdbc.driver.OracleDriver";
     String url = "jdbc:oracle:thin:@localhost:1521:xe";
     String user = "scott";
     String password = "tiger";
     // 1. 드라이버 연동
     Class.forName("oracle.jdbc.driver.OracleDriver"); // 회사명. 프로젝트명. 클래스명
     // 2. 커넥션 (db연동)
     conn = DriverManager.getConnection(url,user,password);
     out.println("db연동성공~!");
     // 3. Statement 사용
     stmt = conn.createStatement();
     rset = stmt.executeQuery("select * from emp where ename='king' ");
     // 4. ResultSet 
     while(rset.next()) {
    	 out.println(rset.getInt("empno")+"/"+rset.getString("ename"));    	 
     }
     rset.close(); stmt.close(); conn.close();
     %>
   </div><!--  드커프리 -->
   
    <div class="container card  my-5">
      <h3  class="card-header"> 002. PreparedStatement </h3>
        <pre class= "alert alert-success">
        1. 1번만 준비시 컴파일, 이후 재사용
        2. ? 로 데이터 저장하고 값 바인딩
        3. SQL 인젝션 방지  where  loc=?
        </pre>
        <%
   // 드커프리 
/*           Connection conn = null; Statement stmt=null; ResultSet rset=null; 
     String dirver = "oracle.jbdc.driver.OracleDriver";
     String url = "jdbc:oracle:thin:@localhost:1521:xe";
     String user = "scott";
     String password = "tiger";  */
     PreparedStatement pstmt=null;
     // 1. 드라이버연동
     Class.forName(driver);
     //2. 커넥션
     conn = DriverManager.getConnection(url,user,password);
     //3. prepareStatement
     pstmt = conn.prepareStatement("select * from emp where ename=? ");
     pstmt.setString(1, "SCOTT"  );
     //4. ResultSet
     rset = pstmt.executeQuery();
     while(rset.next()){
     out.println(rset.getInt("empno") + "/" + rset.getString("ename"));
     }
     rset.close(); stmt.close(); conn.close();
      %>
     
     
     
     
   </div><!--  드커프리 -->
</body>
</html>