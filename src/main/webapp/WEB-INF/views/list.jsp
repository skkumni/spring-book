<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<main>
	
	<h3>도서 목록</h3>
	<c:set var="tName" value="${param.searchType == 'name'}" />
	<c:set var="tPublisher" value="${param.searchType == 'publisher'}" />
	<form method="POST">
		<p>
			<select name="searchType">
				
				<option value="name" ${tName ? 'selected' : '' }>도서이름</option>
				<option value="publisher" ${tPublisher ? 'selected' : '' }>출판사</option>
			</select>
			<input type="search" name="searchValue" placeholder="검색어를 입력하세요" value="${param.searchValue }">
			<input type="submit" value="검색">
		</p>
	</form>
	
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>도서이름</th>
				<th>출판사</th>
				<th>출판날짜</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.idx }</td>
				<td><strong>${dto.name }</strong></td>
				<td>${dto.publisher }</td>
				<td>
					<fmt:formatDate value="${dto.publishDate }" pattern="yyyy년 MM월 dd일" />
				</td>
				<td>
					<fmt:formatNumber value="${dto.price }" pattern="#,###원" />
				</td>
				<td>
					<a href="${cpath }/modify/${dto.idx}"><button>수정</button></a>
				</td>
				<td>
					<button class="delete" idx="${dto.idx }">삭제</button>
				</td>
			</tr>
			</c:forEach>		
		</tbody>
	</table>
	
</main>

<script>
	const deleteBtnList = document.querySelectorAll('.delete');
	
	deleteBtnList.forEach(btn => {
		btn.onclick = event => {
			const idx = event.target.getAttribute('idx');
			const flag = confirm(idx + '번 도서를 삭제하시겠습니까?');
			if(flag) {
				location.href = '${cpath}/delete/' + idx;
			}
		};
	});
</script>


</body>
</html>