package com.en.rule.engine.service;

import java.util.List;

import com.en.rule.engine.model.Rule;
import com.en.rule.engine.model.Signal;

public interface IRuleService {
	public Rule createRule(Rule rule);
	public List<Rule> fatchAllRules();
	public Rule fatchRuleForRuleId(Long ruleId);
	public List<Signal> applyRule(List<Signal> signals, Long ruleId);
}
