<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../inc/header.jsp" %>

<style>
.container {
  background: rgba(255, 255, 255, 0.9);
  border-radius: 16px;
  padding: 30px;
  box-shadow: 0 8px 20px rgba(0,0,0,0.15);
  transition: transform 0.3s ease;
}
.container:hover {
  transform: scale(1.02);
}

body {
  background: linear-gradient(135deg, #a8e6cf, #dcedc1, #f0fff4); /* 러닝크루 느낌 */
  font-family: 'Noto Sans KR', sans-serif;
  color: #2f4f2f;
  margin: 0;
  padding: 0;
}

h3 {
  color: #228b22; /* 숲 느낌의 녹색 */
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
  box-shadow: 0 4px 12px rgba(0,0,0,0.3);
}
</style>


<script>
$(function(){
   let result = '${success}';
   if(result == '비밀번호를 확인해주세요'){  
       alert(result);  
       history.go(-1); 
   } else if(result && result.length != 0){  
       alert(result); 
   }
});
</script>


   <script>
   $(function(){
	   let result = '${success}';
	   console.log(result); 
	   if(result == "글쓰기 실패"){   alert( result );   history.go(-1); }
	   else if(result == '비밀번호를 확인해주세요'){  alert( result  );  history.go(-1); }
	   else if(result.length  != 0 ){  alert(result); }  //아까 처음 값이없을때 공백 
   });
   
   </script>
   <div class="container card  my-5 p-4">
      <h3 class="card-header">Running Crew Board</h3>  
<%--       <div>${list}</div> 
      <div>${paging}</div>--%>
      <table class="table table-striped table-bordered table-hover">
      	<caption>Running Crew </caption>
      	<thead>
      		<tr>
      			<th scope="col">NO</th>
      			<th scope="col">TITLE</th>
      			<th scope="col">NAME</th>
      			<th scope="col">DATE</th>
      			<th scope="col">HIT</th>
      		</tr>	
      	</thead>
      	<tbody>  
      	  <c:forEach  var="dto"  items="${list}"  varStatus="status">  	
	  		<tr> 
	  			<td>${paging.listtotal -((paging.current-1) *10) -status.index} </td>
	  			<td> <a href="${pageContext.request.contextPath}/detail.quest?id=${dto.id}">
	  				${dto.btitle}
	  			</a> </td>
	  			<td>${dto.appUserId}</td>
	  			<td>${dto.createdAt}</td>
	  			<td>${dto.bhit}</td>
	  		 <tr>
	  	  </c:forEach>  
      	</tbody>
      	<tfoot>
      	  <tr><td colspan="5"><ul class="pagination  justify-content-center"> 
	      		<!-- 이전 -->	
	      		<c:if   test="${ paging.start >10 }">
	      			<li  class="page-item">
	      				<a  class="page-link"  href="?pstartno=${paging.start-1}">이전</a>
	      			</li>
	      		</c:if>
	      		
	      		<!-- 1,2,3,4,5,6,7,8,9,10 -->	
	      		<c:forEach  var="i" begin="${paging.start}"  end="${paging.end}" >
	      			<li  class="page-item  <c:if test="${i==paging.current}">  active  </c:if>">
	      				<a  class="page-link"  href="?pstartno=${i}">${i}</a>
	      			</li>
	      		</c:forEach>	 
	      		
	      		<!-- 다음 -->	
	      		<c:if   test="${ paging.pagetotal > paging.end }">
	      			<li  class="page-item">
	      				<a  class="page-link"  href="?pstartno=${paging.end+1}">다음</a>
	      			</li>
	      		</c:if> 
	      		
      	  </ul></td></tr>	
      	</tfoot>
      </table> 
      
		<p class="text-end">
			<a href="${pageContext.request.contextPath}/write.quest" class="btn btn-primary">글쓰기</a>
		</p>	 
		<p class="text-end alert alert-primary">로그인을 하면 글쓰기가능합니다.</p> 
		
	  <div class="mb-3 mt-3 alert alert-primary">
	    <label for="search" class="form-label">	SEARCH</label>
	    <input type="search" class="form-control" id="search"  placeholder="검색어를 입력해주세요" name="search">
	    <!-- 						 -->
	    <!-- 						 -->
	    <div  id="resultArea">
	      <table class="table table-striped table-bordered table-hover  my-3">
		    <caption>Running Crew</caption>
		    <thead>
		      <tr>
		        <th scope="col">NO</th>
		        <th scope="col">TITLE</th>
		        <th scope="col">NAME</th>
		        <th scope="col">DATE</th>
		        <th scope="col">HIT</th>
		      </tr> 
		    </thead>
		    <tbody>
		      <!-- AJAX 결과가 여기에 들어감 -->
		    </tbody>
		  </table> 
	    </div>
	    <!-- 						 -->
	    <!-- 						 -->	    	
	  </div>		
	  <script>
	  $(function(){
		  $("#search").on("keyup" , function(){    // keyup (키보드뗐을때)
				console.log( $(this).val().trim()  ); 
				let keyword = $(this).val().trim();
				/////////////////////////////////////////////
				if(keyword ===""){ //빈칸일때
					$("#resultArea  tbody")
					.empty()
					.append("<tr><td colspan='5'>검색어를 입력하세요.</td></tr>");
				}else{ // 서버요청
					$.ajax({
						url:"${pageContext.request.contextPath}/selectSearch",
						type:"GET",  //GET, POST,PUT
						data:{search:keyword},
						success:function( res ){ 
							console.log(res); 
							$("#resultArea  tbody").empty();  //초기화
							$.each( res , function( index, dto  ){ 
								let row = "<tr>"
								+"<td>"+(res.length-index)+"</td>"
								+"<td><a href='${pageContext.request.contextPath}/detail.quest?id="+dto.id+"'>"
								+dto.btitle+"</a></td>"
								+"<td>"+dto.appUserId+"</td>"
								+"<td>"+dto.createdAt+"</td>"
								+"<td>"+dto.bhit+"</td>"
								+"</tr>";
								$("#resultArea  tbody").append(row);
							});
						}
					});
				} 
				/////////////////////////////////////////////
		  });
	  });
	  </script>	
		
   </div>
   
<%@include file="../inc/footer.jsp" %>

<!-- [ Running Crew - list.jsp ]  -->