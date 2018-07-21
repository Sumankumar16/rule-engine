package com.en.rule.engine.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.en.rule.engine.constants.JsonConstants;
import com.en.rule.engine.model.enums.StringValueType;
import com.en.rule.engine.serializer.FlexDateDeserializer;
import com.en.rule.engine.serializer.FlexDateSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Rule extends Entity<Long> {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = JsonConstants.LOWER_BOUNDRY_OF_DATE)
	@JsonDeserialize(using = FlexDateDeserializer.class)
	@JsonSerialize(using = FlexDateSerializer.class)
	private Date lowerBoundryOfDate;
	
	@JsonProperty(value = JsonConstants.UPPER_BOUNDRY_OF_DATE)
	@JsonDeserialize(using = FlexDateDeserializer.class)
	@JsonSerialize(using = FlexDateSerializer.class)
	private Date upperBoundryOfDate;
	
	@JsonProperty(value = JsonConstants.LOWER_BOUNDRY_OF_INT)
	private Integer lowerBoundryOfInt;
	
	@JsonProperty(value = JsonConstants.UPPER_BOUNDRY_OF_INT)
	private Integer upperBoundryOfInt;
	
	@JsonProperty(value = JsonConstants.STRING_VALUE_TYPE)
	@NotNull
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
