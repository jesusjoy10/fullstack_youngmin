<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천 등록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card my-5">
      <h3 class="card-header">추천 등록</h3>
      <div class="card-body">
         <form action="/recommend/insert" method="post">
            <div class="mb-3">
                <label class="form-label">사용자 ID</label>
                <input type="text" name="id" class="form-control">
            </div>
            <div class="mb-3">
                <label class="form-label">음식 ID</label>
                <input type="text" name="foodId" class="form-control">
            </div>
            <div class="mb-3">
                <label class="form-label">추천 유형</label>
                <input type="text" name="type" class="form-control">
            </div>
            <div class="mb-3">
                <label class="form-label">피드백</label>
                <input type="text" name="feedback" class="form-control">
            </div>
            <button type="submit" class="btn btn-primary">추천 등록</button>
         </form>
      </div>
   </div>
</body>
</html>
