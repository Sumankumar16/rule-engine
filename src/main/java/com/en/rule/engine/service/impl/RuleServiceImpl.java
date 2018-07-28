package com.en.rule.engine.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.en.rule.engine.dao.IRuleDao;
import com.en.rule.engine.model.Rule;
import com.en.rule.engine.model.Signal;
import com.en.rule.engine.model.enums.StringValueType;
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
		List<Signal> signalVoilatedByRule = new ArrayList<Signal>();
		Rule rule = ruleDao.fatchRuleForRuleID(ruleId);
		LOG.info("rule to be applied on signal {}", rule);
		for (int i = 0; i < signals.size(); i++) {
			if (signals.get(i).getValueType().equalsIgnoreCase("Datetime")) {
				Boolean isValid = validateDateRule(signals.get(i).getValue(), rule.getLowerBoundryOfDate(),rule.getUpperBoundryOfDate());
				if (!isValid) {
					signalVoilatedByRule.add(signals.get(i));
				}
			} else if (signals.get(i).getValueType().equalsIgnoreCase("Integer")) {
				Boolean isValid = validateIntegerRule(signals.get(i).getValue(), rule.getLowerBoundryOfInt(),rule.getUpperBoundryOfInt());
				if (!isValid) {
					signalVoilatedByRule.add(signals.get(i));
				}
			} else if (signals.get(i).getValueType().equalsIgnoreCase("String")) {
				Boolean isValid = validateStringRule(signals.get(i).getValue(), rule.getValue());
				if (!isValid) {
					signalVoilatedByRule.add(signals.get(i));
				}
			} else {
				signalVoilatedByRule.add(signals.get(i)); // everything else which doesn't match valueType.
			}
		}
		return signalVoilatedByRule;
	}
	
	/***
	 * This method validate rule for value_type as DateTime.
	 * Where rule can be anything in between lowerBoundryOfDate and upperBoundryOfDate.
	 * if only lowerBoundryOfDate is exist in rule which means all signal should be valid for date greater then lowerBoundryOfDate.
	 * if only upperBoundryOfDate is exist in rule which means all signal should be valid for date lower then upperBoundryOfDate.
	 * and if lowerBoundryOfDate and upperBoundryOfDate both exist in a rule then signal is valid when DateTime falls within this range.
	 * @param value
	 * @param lowerBoundryOfDate
	 * @param upperBoundryOfDate
	 * @return
	 * @throws ParseException 
	 */
	private Boolean validateDateRule(String dateValue, Date lowerBoundryOfDate, Date upperBoundryOfDate) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = (Date) sdf.parse(dateValue);
			if (null!= lowerBoundryOfDate && null!= upperBoundryOfDate) {
				return date.after(lowerBoundryOfDate) && date.before(upperBoundryOfDate);
			} else if (null!= lowerBoundryOfDate) {
				return date.after(lowerBoundryOfDate) && true;
			} else if (null!= upperBoundryOfDate) {
				return true && date.before(upperBoundryOfDate);
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
		return false;

	}

	/***
	 * his method validate rule for value_type as Integer.
	 * Where rule can be anything in between lowerBoundryOfInt and upperBoundryOfInt
	 * if only lowerBoundryOfInt is exist in rule which means all signal should be valid for Integer greater then lowerBoundryOfInt.
	 * if only upperBoundryOfInt is exist in rule which means all signal should be valid for Integer lower then upperBoundryOfInt.
	 * and if lowerBoundryOfInt and upperBoundryOfInt both exist in a rule then signal is valid when Integer falls within this range.
	 * @param value
	 * @param lowerBoundryOfInt
	 * @param upperBoundryOfInt
	 * @return
	 */
	private Boolean validateIntegerRule(String stringDoubleValue, Integer lowerBoundryOfInt, Integer upperBoundryOfInt) {
		try {
			Double doubleValue = Double.parseDouble(stringDoubleValue);
			Integer value = doubleValue.intValue();
			if (null!= lowerBoundryOfInt && null!= upperBoundryOfInt) {
				return value>=lowerBoundryOfInt && value<=upperBoundryOfInt;	
			} else if (null!= lowerBoundryOfInt ) {
				return value>=lowerBoundryOfInt;
			} else if (null!=upperBoundryOfInt) {
				return value<=upperBoundryOfInt;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}


	/***
	 * This method validate rule for value_type as string.
	 * A rule can be either HIGH or LOW and value can be anything. 
	 * @param value
	 * @param stringValueType
	 * @return
	 */
	private Boolean validateStringRule(String value, StringValueType stringValueType) {
		
		return value.equalsIgnoreCase(stringValueType.getValue());
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