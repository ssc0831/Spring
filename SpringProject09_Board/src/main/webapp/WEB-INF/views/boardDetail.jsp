<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>

<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>BoardDetail</h1>
	</div>
</div>
<div class="container">
<input type="hidden" name="num" id="num" value="${board.num }"  />
	<table class="table table-hover">
		<tr>
			<th>글번호</th>
			<td>${board.num }</td>
			<th>조회수</th>
			<td>${board.readcount }</td>
		</tr>
		<tr>
			<th>글번호</th>
			<td>${board.num }</td>
			<th>조회수</th>
			<td>${board.readcount }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.userid }</td>
			<th>작성일</th>
			<td>${board.regdate }</td>
		</tr>
		<tr>
			<th>글제목</th>
			<td colspan="3">${board.subject }</td>
		</tr>
		<tr>
			<th>글내용</th>
			<td colspan="3">${board.content }</td>
		</tr>
	</table>
	<br />
	<c:if test="${sessionScope.suser.userid == board.userid }">
		<button class="btn btn-primary">수정</button>
		<button class="btn btn-secondary">삭제</button>
	</c:if>
	<div class="container">
		<div class="form-group">
			<label for="msg">msg:</label>
			<textarea class="form-control" rows="5" id="msg" name="msg"></textarea>
		</div>
   <button class="btn btn-success btn-sm" id="commentBtn">Comment Write</button>
	</div>
	<div class ="mt-3">댓글(<span class="cntSpan"></span>)</div>
	<div id= "result"></div>

</div>

<%@ include file="include/footer.jsp"%>
