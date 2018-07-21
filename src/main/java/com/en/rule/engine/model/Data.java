package com.en.rule.engine.model;

import java.util.List;

public class Data  {
	
	private String ruleId;
	
	private List<Rule> rule;

	public Data() {
		super();
	}
	
	public Data(String ruleId) {
		super();
		this.ruleId = ruleId;
	}
	
	public Data(List<Rule> rule) {
		this.rule = rule;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	
	public List<Rule> getRule() {
		return rule;
	}

	public void setRule(List<Rule> rule) {
		this.rule = rule;
	}
}