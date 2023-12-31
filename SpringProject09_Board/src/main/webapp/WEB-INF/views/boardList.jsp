<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="include/header.jsp"%>

<div class="container">
	<h3>게시판(${count })</h3>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${barr }" var="board" varStatus="st">
				<tr>
					<td>${rowNo-st.index }</td>
					<td><a href="view/${board.num }">${board.title }(${board.replyCnt })</a></td>
					<td>${board.writer}</td>
					<td><fmt:formatDate value="${board.regdate }"
							pattern="yyyy-MM-dd" /></td>
					<td>${board.hitcount }</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div class="container">
		<ul class="pagination">
			<!-- 이전 -->
			<c:if test="${p.startPage > p.blockPage } }">
			<li class="page-item">
			<a class="page-link" href="/list?pageNum=${p.startPage-p.blockPage}">Previous</a></li>
			</c:if>
			<!-- 페이지 번호 -->
			<c:forEach begin="${p.startPage }" end="${p.endPage}" var="i"> 
			<c:if test="${p.currentPage==i}">
			<li class="page-item active"><a class="page-link" href="/list?pageNum=${i}">${i}</a></li>
			</c:if>
			
			<c:if test="${p.currentPage!=i}">
			<li class="page-item"><a class="page-link" href="/list?pageNum=${i}">${i}</a></li>
			</c:if>
			</c:forEach>
			
			<!-- 다음 -->
			<c:if test="${p.endPage < p.totPage}">
			<li class="page-item">
			<a class="page-link" href="/list?pageNum=${p.endPage +1}">${p.endPage}</a></li>
			</c:if>
		</ul>
	</div>




	<form class="form-inline" action="/list" method="get">
	<select name="field" id="field" class="form-control mr-sm-1">
	<option value="writer">작성자</option>
	<option value="content">내용</option>
	</select>
	<input type="text" name="word" class="form-control" placeholder="Search">
	<button class="btn btn-secondary">Search</button>
	</form>
	
</div>
<%@ include file="include/footer.jsp"%>
