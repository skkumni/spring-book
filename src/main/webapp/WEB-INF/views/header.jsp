<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day07</title>
<style>
	a {
		text-decoration: none;
		color: inherit;
	}
	a:hover {
		text-decoration: underline;
	}
	h1#logo {
		text-align: center;
	}
	nav {
		background-color: #eee;
	}
	nav > ul {
		display: flex;
		justify-content: center;
		width: 800px;
		margin: 0 auto;
		padding: 10px;
		list-style: none;
		padding-left: 0;
	}
	nav > ul > li {
		font-size: 20px;
		flex: 1;
		text-align: center;
	}
	main {
		margin: 0 auto;
		max-width: 1200px; 
	}
	
	table {
		border-collapse: collapse;
		border: 2px solid black;
	}
	td, th {
		border: 1px solid black;
		padding: 5px 10px;
	}
	thead {
		background-color: grey;
		color: white;
	}
	tbody > tr:hover {
		cursor: pointer;
		background-color: #eee;
	}
</style>
</head>
<body>

<header>
	<h1 id="logo">
		<a href="${cpath }">day07</a>
	</h1>
	<nav>
		<ul>
			<li><a href="${cpath }/list">목록</a></li>
			<li><a href="${cpath }/add">추가</a></li>
		</ul>
	</nav>
</header>

