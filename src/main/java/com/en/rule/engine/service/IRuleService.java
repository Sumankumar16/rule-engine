package com.en.rule.engine.service;

import java.util.List;

import com.en.rule.engine.model.Rule;

public interface IRuleService {
	public Rule createRule(Rule rule);
	public List<Rule> fatchAllRules();
}
