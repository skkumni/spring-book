package com.itbank.repository;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itbank.model.BookDTO;

@Repository
public class BookDAO {

	@Autowired private JdbcTemplate jt;
	
	// DB의 book 테이블에 접근하여 한 줄을 자바 객체로 변환하려면 다음과 같이 변환해야 한다 
	// (맵핑 규칙을 명시하는 객체 mapper)
	private RowMapper<BookDTO> mapper = (ResultSet rs, int rowNum) -> {
		BookDTO dto = new BookDTO();
		dto.setIdx(rs.getInt("idx"));
		dto.setName(rs.getString("name"));
		dto.setPublisher(rs.getString("publisher"));
		dto.setPublishDate(rs.getDate("publishDate"));
		dto.setPrice(rs.getInt("price"));
		return dto;
	};

	public List<BookDTO> selectAll() {
		String sql = "select * from book order by idx";
		List<BookDTO> list = jt.query(sql, mapper);
		return list;
	}

	public List<BookDTO> selectList(String searchType, String searchValue) {
		String sql = "select * from book where %s like '%%%s%%' order by idx";
		sql = String.format(sql, searchType, searchValue);
		List<BookDTO> list = jt.query(sql, mapper);
		return list;
	}

	public int insert(BookDTO dto) {
		// PreparedStatement
		String sql = "insert into book (name, publisher, publishDate, price)";
		sql += " values (?, ?, ?, ?)";
		
		// 자료형에 상관없이 값을 순서대로 저장할 수 있는 배열
		Object[] args = {
				dto.getName(), dto.getPublisher(), dto.getPublishDate(), dto.getPrice()
		};
		
		int row = jt.update(sql, args);	// pstmt.executeQuery();	// select
										// pstmt.executeUpdate();	// insert, update, delete
		return row;
	}

	public int delete(int idx) {
		String sql = "delete from book where idx = ?";
		Object[] args = { idx };
		int row = jt.update(sql, args); 
		return row;
	}

	public BookDTO selectOne(int idx) {
		String sql = "select * from book where idx = ?";
		Object[] args = { idx };
		
		BookDTO dto = jt.queryForObject(sql, mapper, args);
		// sql을 실행할 때 ?의 개수와 순서에 맞게 args값을 넣어서 실행한다
		// 결과는 반드시 단일 객체로만 나오기 때문에, 반환형이 List가 아닌 BookDTO로 정해져있다
		// Relations의 데이터를 Object로 Mapping하는 규칙은 이전에 작성한 mapper와 동일하다
		
		return dto;
	}

	public int update(BookDTO dto) {
		String sql = "update book set name=?, publisher=?, publishDate=?, price=?";
		sql += " where idx=?";
		Object[] args = {
			dto.getName(), dto.getPublisher(), dto.getPublishDate(), 
			dto.getPrice(), dto.getIdx()
		};
		int row = jt.update(sql, args);
		return row;
	}
}










