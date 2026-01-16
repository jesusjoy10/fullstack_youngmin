<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../inc/header.jsp"%>
<!-- 	header		 --> 
<div class="container mt-5">
	<h3>유저정보수정</h3>
	<form action="${pageContext.request.contextPath}/security/update.users" 	
		method="post"  encType="multipart/form-data" > 
	    <input type="hidden"   name="appUserId"  value="${dto.appUserId}">  
	    <input  type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
		<div class="mb-3 mt-3">
			<label  for="email" class="form-label">Email:</label> 
			<input  type="email" class="form-control" id="email"
					placeholder="이메일을 입력해주세요" required  name="email"  value="${dto.email}"  readonly>
		</div>
		<div class="mb-3">
			<label for="password" class="form-label">Password:</label> 
			<input type="password" class="form-control" id="password"
					placeholder="비밀번호를 입력해주세요" name="password">
		</div>
		  <div class="mb-3">
		    <label for="file" class="form-label">프로필이미지 수정</label>
		    <input type="file" class="form-control" id="file" placeholder="파일을 입력해주세요" name="file">
		</div>
		  <div class="mb-3">
		  	<input type="text" class="form-control" id="ufile"   readonly  name="ufile"  value="${dto.ufile}">
		  </div>			
		<div class="mb-3">
			<label class="form-check-label"  for="region">지역 : </label>  
			<select   name="region"  id="region"  class="form-control">
				<option value="서울">서울</option>
				<option value="인천">인천</option>
				<option value="경기">경기</option>
				<option value="강원">강원</option>
				<option value="충청">충청</option>
				<option value="경상">경상</option>
				<option value="전라">전라</option>
			</select>
		</div>
		<button type="submit" class="btn btn-primary">정보수정-비밀번호/지역</button>
	</form>
</div>
<!-- ctrl + shift + f -->
<!-- 	footer		 --> 
<%@ include file="../inc/footer.jsp"%>






