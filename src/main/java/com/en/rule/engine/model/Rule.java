package com.en.rule.engine.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.en.rule.engine.model.enums.StringValueType;

public class Rule extends Entity<Long> {
	
	private static final long serialVersionUID = 1L;

	private Date lowerBoundryOfDate;
	
	private Date upperBoundryOfDate;
	
	private Integer lowerBoundryOfInt;
	
	private Integer upperBoundryOfInt;
	
	private StringValueType value;

	public Date getLowerBoundryOfDate() {
		return lowerBoundryOfDate;
	}

	public void setLowerBoundryOfDate(Date lowerBoundryOfDate) {
		this.lowerBoundryOfDate = lowerBoundryOfDate;
	}

	public Date getUpperBoundryOfDate() {
		return upperBoundryOfDate;
	}

	public void setUpperBoundryOfDate(Date upperBoundryOfDate) {
		this.upperBoundryOfDate = upperBoundryOfDate;
	}

	public Integer getLowerBoundryOfInt() {
		return lowerBoundryOfInt;
	}

	public void setLowerBoundryOfInt(Integer lowerBoundryOfInt) {
		this.lowerBoundryOfInt = lowerBoundryOfInt;
	}

	public Integer getUpperBoundryOfInt() {
		return upperBoundryOfInt;
	}

	public void setUpperBoundryOfInt(Integer upperBoundryOfInt) {
		this.upperBoundryOfInt = upperBoundryOfInt;
	}

	public StringValueType getValue() {
		return value;
	}

	public void setValue(StringValueType value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
