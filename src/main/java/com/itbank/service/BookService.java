package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BookDTO;
import com.itbank.repository.BookDAO;

@Service
public class BookService {

	@Autowired private BookDAO dao;

	public List<BookDTO> getList() {
		return dao.selectAll();
	}

	public List<BookDTO> getList(String searchType, String searchValue) {
		return dao.selectList(searchType, searchValue);
	}

	public int add(BookDTO dto) {
		return dao.insert(dto);
	}

	public int delete(int idx) {
		return dao.delete(idx);
	}

	public BookDTO selectOne(int idx) {
		return dao.selectOne(idx);
	}

	public int modify(BookDTO dto) {
		return dao.update(dto);
	}
}



