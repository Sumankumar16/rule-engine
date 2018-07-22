package com.en.rule.engine.dao;

import java.util.List;

import com.en.rule.engine.model.Rule;

/**
 * 
 * @author Suman Kumar
 *
 */
public interface IRuleDao {
	public Rule createRule(Rule rule);
	public List<Rule> fatchAllRules();
	public Rule fatchRuleForRuleID(Long Id);

}
