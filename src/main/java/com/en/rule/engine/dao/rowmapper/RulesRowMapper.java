package com.en.rule.engine.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.en.rule.engine.model.Rule;
import com.en.rule.engine.model.enums.StringValueType;

public class RulesRowMapper implements ResultSetExtractor<List<Rule>>{

	@Override
	public List<Rule> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		List<Rule> rules = new ArrayList<>();
		Rule rule = null;
		while(rs.next()) {
			rule = new Rule();
			rule.setId(rs.getLong("id"));
			rule.setLowerBoundryOfDate(rs.getTimestamp("lower_boundry_date"));
			rule.setUpperBoundryOfDate(rs.getTimestamp("upper_boundry_date"));
			rule.setValue(StringValueType.valueOf(StringValueType.getValueByValueType(rs.getString("string_value_type"))));
			rule.setLowerBoundryOfInt(rs.getInt("lower_boundry_int"));
			rule.setUpperBoundryOfInt(rs.getInt("upper_boundry_int"));
			rules.add(rule);
		}
		
		return rules;
	}
	
}