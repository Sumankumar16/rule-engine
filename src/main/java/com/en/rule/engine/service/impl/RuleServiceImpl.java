package com.en.rule.engine.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.en.rule.engine.dao.IRuleDao;
import com.en.rule.engine.model.Rule;
import com.en.rule.engine.model.Signal;
import com.en.rule.engine.service.IRuleService;

@Service
public class RuleServiceImpl  implements IRuleService {
	
	private final Logger LOG = LoggerFactory.getLogger(RuleServiceImpl.class);

	@Autowired
	IRuleDao ruleDao;
	
	@Transactional
	@Override
	public Rule createRule(Rule rule) {
		return ruleDao.createRule(rule);
	}
	
	@Transactional
	@Override
	public List<Signal> applyRule(List<Signal> signals, Long ruleId) {
		Rule rule = ruleDao.fatchRuleForRuleID(ruleId);
		LOG.info("Rule___________    {}", rule);
		return null;
	}


	@Transactional
	@Override
	public List<Rule> fatchAllRules() {
		return ruleDao.fatchAllRules();
	}

	@Override
	public Rule fatchRuleForRuleId(Long ruleId) {
		return ruleDao.fatchRuleForRuleID(ruleId);
	}
	
}