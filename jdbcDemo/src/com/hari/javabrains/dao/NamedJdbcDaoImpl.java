package com.hari.javabrains.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class NamedJdbcDaoImpl extends NamedParameterJdbcDaoSupport{

	public int getCircleCount(){
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		return this.getJdbcTemplate().queryForObject(sql,Integer.class);
	}
}
