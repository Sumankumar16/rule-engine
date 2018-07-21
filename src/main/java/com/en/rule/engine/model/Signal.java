package com.en.rule.engine.model;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.en.rule.engine.constants.JsonConstants;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * @author Suman Kumar
 */

public class Signal extends Entity<Long> {
	private static final long serialVersionUID = -6300193276812199003L;
	
	@JsonProperty(value = JsonConstants.SIGNAL)
	@NotNull
	private String signal;
	
	@JsonProperty(value = JsonConstants.VALUE_TYPE)
	@NotNull
	private String valueType;
	
	@JsonProperty(value = JsonConstants.VALUE)
	@NotNull
	private String value;

	public String getSignal() {
		return signal;
	}

	public void setSignal(String signal) {
		this.signal = signal;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
