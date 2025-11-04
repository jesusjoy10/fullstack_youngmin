<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.thejoa703.dto.PostDto" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천 목록</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

 <div class="container my-5">
    <h2>추천 목록</h2>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>추천번호</th>
                <th>사용자ID</th>
                <th>음식ID</th>
                <th>추천유형</th>
                <th>피드백</th>
                <th>추천일시</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<PostDto> list = (List<PostDto>) request.getAttribute("list");
            for (PostDto dto : list) {
        %>
            <tr>
                <td><%= dto.getRecId() %></td>
                <td><%= dto.getId() %></td>
                <td><%= dto.getFoodId() %></td>
                <td><%= dto.getType() %></td>
                <td><%= dto.getFeedback() %></td>
                <td><%= dto.getCreatedAt() %></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
