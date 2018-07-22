package com.en.rule.engine.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.en.rule.engine.model.ApiResponseTemplate;
import com.en.rule.engine.model.Data;
import com.en.rule.engine.model.MetaData;
import com.en.rule.engine.model.Rule;
import com.en.rule.engine.model.Signal;
import com.en.rule.engine.service.IRuleService;

/**
 * <P>
 * Rule Controller is a an API interface , which allows user's to create a new rule
 * ,fetch all existing rules and apply the rule to streaming data.
 * </P>
 * 
 * @author Suman Kumar
 *
 */
@RestController
public class RuleController {
    
	private final Logger LOG = LoggerFactory.getLogger(RuleController.class);
	private static final List<? extends Object> CREATE_QUERY_PARAM = Arrays.asList("");
	
	@Autowired
	private IRuleService ruleService;
	
	/**
	 * This API will allow user to create a new rule.
	 * @param rule
	 * @param allRequestParameters
	 * @return
	 */
	@RequestMapping(value = "/createRule", method=RequestMethod.POST)
	public ResponseEntity<ApiResponseTemplate> createRule(@Valid @RequestBody Rule rule, @RequestParam(required = false) Map<String, List<? extends Object>> allRequestParameters) {
		List<? extends Object> extraQueryParams= allRequestParameters.keySet().stream().filter(e -> !CREATE_QUERY_PARAM.contains(e)).collect(Collectors.toList());
        if(extraQueryParams.size() > 0){
            throw new IllegalArgumentException("invalid Parameters passed " + extraQueryParams);
        }
        LOG.info("Creating a new rule..");
        rule = ruleService.createRule(rule);
		Data data = new Data(Arrays.asList(rule));
		MetaData metaData = new MetaData("Rule Created Successfully!", HttpStatus.CREATED.value());
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseTemplate(metaData, data));
	}
	
	/**
	 * This API will apply rules on incoming signal and returns those list which 
	 * violates the rule as a response.
	 * @param signals
	 * @param allRequestParameters
	 * @return
	 */
	@RequestMapping(value = "/applyRule/{ruleId}", method=RequestMethod.POST)
	public ResponseEntity<ApiResponseTemplate> applyRule(@Valid @RequestBody List<Signal> signals,@PathVariable(required = true) Long ruleId, @RequestParam(required = false) Map<String, List<? extends Object>> allRequestParameters) {
		List<? extends Object> extraQueryParams= allRequestParameters.keySet().stream().filter(e -> !CREATE_QUERY_PARAM.contains(e)).collect(Collectors.toList());
        if(extraQueryParams.size() > 0){
            throw new IllegalArgumentException("invalid Parameters passed " + extraQueryParams);
        }
        LOG.info("Applying rules..");
        signals = ruleService.applyRule(signals, ruleId);
		Data data = new Data();
		data.setRuleId("testid");
		MetaData metaData = new MetaData("Rule Applied Successfully!", HttpStatus.OK.value());
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseTemplate(metaData, data));
	}
	
	/**
	 * This API will fetch all existing rules
	 * @param allRequestParameters
	 * @return
	 */
	@RequestMapping(value = "/fetchRules", method=RequestMethod.GET)
	public ResponseEntity<ApiResponseTemplate> fatchAllRules(@RequestParam(required = false) Map<String, List<? extends Object>> allRequestParameters) {
		List<? extends Object> extraQueryParams= allRequestParameters.keySet().stream().filter(e -> !CREATE_QUERY_PARAM.contains(e)).collect(Collectors.toList());
        if(extraQueryParams.size() > 0){
            throw new IllegalArgumentException("invalid Parameters passed " + extraQueryParams);
        }
        LOG.info("Featching all existing rules..");
        List<Rule> rule = ruleService.fatchAllRules();
		Data data = new Data(rule);
		MetaData metaData = new MetaData("List of all existing rules", HttpStatus.OK.value());
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseTemplate(metaData, data));
	}
	
	
	/**
	 * This API will fetch one rules
	 * @param allRequestParameters
	 * @return
	 */
	@RequestMapping(value = "/fetchRuleById/{ruleId}", method=RequestMethod.GET)
	public ResponseEntity<ApiResponseTemplate> fatchRuleForRuleId(@PathVariable(required = true) Long ruleId, @RequestParam(required = false) Map<String, List<? extends Object>> allRequestParameters) {
		List<? extends Object> extraQueryParams= allRequestParameters.keySet().stream().filter(e -> !CREATE_QUERY_PARAM.contains(e)).collect(Collectors.toList());
        if(extraQueryParams.size() > 0){
            throw new IllegalArgumentException("invalid Parameters passed " + extraQueryParams);
        }
        LOG.info("Featching all existing rules..");
        Rule rule = ruleService.fatchRuleForRuleId(ruleId);
		Data data = new Data(Arrays.asList(rule));
		MetaData metaData = new MetaData("List of all existing rules", HttpStatus.OK.value());
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseTemplate(metaData, data));
	}
	
}
