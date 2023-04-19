<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<main>
	<h3>도서 수정 : ${idx }</h3>
	
	<form method="POST">
		<p><input type="text" name="name" value="${dto.name }" placeholder="이름" required autofocus></p>
		<p><input type="text" name="publisher" value="${dto.publisher }" placeholder="출판사" required></p>
		<p><input type="date" name="publishDate" value="${dto.publishDate }" required></p>
		<p><input type="number" name="price" value="${dto.price }" placeholder="가격" min="0" step="100" required></p>
		<p><input type="submit"></p>
	</form>
</main>

</body>
</html>