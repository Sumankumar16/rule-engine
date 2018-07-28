package com.en.rule.engine.model;

import java.util.List;

public class Data  {
	
	private Long ruleId;
	
	private List<Rule> rules;
	
	private List<Signal> signals;

	public Data() {
		super();
	}
	
	public Data(Long ruleId) {
		super();
		this.ruleId = ruleId;
	}
	
	public Data(List<Rule> rules) {
		this.rules = rules;
	}

	public Data(Long ruleId, List<Rule> rules, List<Signal> signals) {
		super();
		this.ruleId = ruleId;
		this.rules = rules;
		this.signals = signals;
	}

	public Long getRuleId() {
		return ruleId;
	}

	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}
	
	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	public List<Signal> getSignals() {
		return signals;
	}

	public void setSignals(List<Signal> signals) {
		this.signals = signals;
	}
}