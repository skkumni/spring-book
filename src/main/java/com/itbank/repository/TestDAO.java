package com.itbank.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {
	
	@Autowired private JdbcTemplate jdbcTemplate;

	public String getDBversion() {
		String sql = "select banner from v$version";
		String version = jdbcTemplate.queryForObject(sql, String.class);
		return version;
	}

}
