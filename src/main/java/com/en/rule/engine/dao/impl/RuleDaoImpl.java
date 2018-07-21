package com.en.rule.engine.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.en.rule.engine.dao.IRuleDao;
import com.en.rule.engine.model.Rule;
/**
 * 
 * @author Suman Kumar
 *
 */
@Repository
public class RuleDaoImpl  implements IRuleDao {
	
	private static final Logger LOG = LoggerFactory.getLogger(RuleDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Rule createRule(Rule rule) {
		this.jdbcTemplate.update(RuleQueries.CREATE_RULE, rule.getLowerBoundryOfDate(),rule.getUpperBoundryOfDate(),
				rule.getValue(),rule.getLowerBoundryOfInt(), rule.getUpperBoundryOfDate());
		return null;
	}

	@Override
	public List<Rule> fatchAllRules() {
		return null;
	}
}