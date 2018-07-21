package com.en.rule.engine.dao.impl;
public class RuleQueries {
	public static final String CREATE_RULE = "INSERT INTO "
											+ "rules ( "
											+ "lower_boundry_date,"
											+ "upper_boundry_date,"
											+ "string_value_type,"
											+ "lower_boundry_int,"
											+ "upper_boundry_int )"
											+ "VALUES(?, ?, ?, ?, ?)";

}
