package com.en.rule.engine.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.en.rule.engine.model.Rule;
import com.en.rule.engine.model.enums.StringValueType;

public class RuleRowMapper implements ResultSetExtractor<Rule>{

	@Override
	public Rule extractData(ResultSet rs) throws SQLException, DataAccessException {
		Rule rule = new Rule();
		while(rs.next()) {
			
			rule.setId(rs.getLong("id"));
			rule.setLowerBoundryOfDate(rs.getTimestamp("lower_boundry_date"));
			rule.setUpperBoundryOfDate(rs.getTimestamp("upper_boundry_date"));
			rule.setValue(StringValueType.valueOf(StringValueType.getValueByValueType(rs.getString("string_value_type"))));
			rule.setLowerBoundryOfInt(rs.getInt("lower_boundry_int"));
			rule.setUpperBoundryOfInt(rs.getInt("upper_boundry_int"));
		}
		
		return rule;
	}
	
}