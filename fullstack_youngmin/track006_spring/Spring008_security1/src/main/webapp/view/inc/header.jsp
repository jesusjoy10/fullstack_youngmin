<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap 5 Website Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
.fakeimg {
	height: 200px;
	background: #aaa;
}

.my-container {
	background: rgba(255, 255, 255, 0.9);
	border-radius: 16px;
	padding: 30px;
	box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
	transition: transform 0.3s ease;
}

.my-container:hover {
	transform: scale(1.02);
}

body {
	background: linear-gradient(135deg, #a8e6cf, #dcedc1, #f0fff4);
	font-family: 'Noto Sans KR', sans-serif;
	color: #2f4f2f;
	margin: 0;
	padding: 0;
}

h3 {
	color: #228b22;
	font-weight: bold;
	text-align: center;
}

.btn-primary {
	background: linear-gradient(90deg, #4caf50, #81c784);
	border: none;
	border-radius: 30px;
	padding: 12px 24px;
	color: #fff;
	font-weight: bold;
	transition: all 0.3s ease;
}

.btn-primary:hover {
	background: linear-gradient(90deg, #81c784, #4caf50);
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<div class="p-5 bg-success text-white text-center"
		style="background:url(${pageContext.request.contextPath}/images/map2.png)">
		<h1>Running Crew Board</h1>
		<p>함께 달리고 기록을 공유하는 러닝크루 커뮤니티</p>
	</div>
	<%@ taglib uri="http://www.springframework.org/security/tags"
		prefix="sec"%>
	<!-- ## -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<sec:authorize access="isAnonymous()">
					<li class="nav-item"><a class="nav-link" href="#"
						data-bs-toggle="modal" data-bs-target="#loginModal">LOGIN</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/security/join">JOIN</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<!-- ## 로그인을 했다면 -->
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/list.users">유저관리</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/security/mypage"> <sec:authentication
								property="principal.dto.email" />
					</a></li>
				</sec:authorize>
			<%-- 	<sec:authorize access="isAnonymous()">
					<!-- ## 아무나다 접근가능하게 -->
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/security/login">LOGIN</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/security/join">JOIN</a></li>
				</sec:authorize> --%>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/list.quest">러닝크루 게시판</a></li>
				<li class="nav-item">
					<form action="${pageContext.request.contextPath}/security/logout"
						method="post">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button type="submit"
							class="nav-link text-danger border-0 bg-transparent">로그아웃</button>
						<!-- <input type="submit" value="로그아웃" class="btn btn-danger btn-sm" /> -->
					</form>
				</li>
			</ul>
		</div>
	</nav>
	<!-- 로그인 모달 -->
<div class="modal fade" id="loginModal" tabindex="-1">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">로그인</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>
      <div class="modal-body">
        <form action="${pageContext.request.contextPath}/security/login" method="post">
          <!-- CSRF 토큰 -->
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
          
          <div class="mb-3">
            <label for="loginEmail" class="form-label">이메일</label>
            <input type="email" class="form-control" id="loginEmail" name="username">
          </div>
          <div class="mb-3">
            <label for="loginPassword" class="form-label">비밀번호</label>
            <input type="password" class="form-control" id="loginPassword" name="password">
          </div>
          <button type="submit" class="btn btn-primary w-100">로그인</button>
        </form>
      </div>
    </div>
  </div>
</div>
	<!-- header -->
	<!-- header -->
	<!-- header -->