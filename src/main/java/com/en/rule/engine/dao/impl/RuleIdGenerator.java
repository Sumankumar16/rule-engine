package com.en.rule.engine.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.en.rule.engine.dao.IdGenerator;

@Repository
public class RuleIdGenerator implements IdGenerator<Long>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Long generate() {
		return jdbcTemplate.queryForObject("Select nextval('rules_id_sequence')", Long.class);
	}

}

