package com.en.rule.engine.model;

import java.util.List;

public class Data  {
	
	private String ruleId;
	
	private List<Rule> rules;

	public Data() {
		super();
	}
	
	public Data(String ruleId) {
		super();
		this.ruleId = ruleId;
	}
	
	public Data(List<Rule> rules) {
		this.rules = rules;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	
	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}
}