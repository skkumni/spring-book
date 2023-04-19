<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>




<main>
	<h3>도서 추가</h3>
	
	<form method="POST">
		<p><input type="text" name="name" placeholder="이름" required autofocus></p>
		<p><input type="text" name="publisher" placeholder="출판사" required></p>
		<p><input type="date" name="publishDate" value="2023-01-01" required></p>
		<p><input type="number" name="price" placeholder="가격" min="0" step="100" required></p>
		<p><input type="submit"></p>
	</form>
</main>

</body>
</html>