package com.en.rule.engine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.en.rule.engine.dao.IRuleDao;
import com.en.rule.engine.model.Rule;
import com.en.rule.engine.service.IRuleService;

@Service
public class RuleServiceImpl  implements IRuleService {

	@Autowired
	IRuleDao ruleDao;
	
	@Transactional
	@Override
	public Rule createRule(Rule rule) {
		return ruleDao.createRule(rule);
	}

	@Transactional
	@Override
	public List<Rule> fatchAllRules() {
		return ruleDao.fatchAllRules();
	}
	
}