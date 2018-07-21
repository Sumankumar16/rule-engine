package com.en.rule.engine.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * @author Suman Kumar
 *
 */
public class MetaData  {
	
	private String message;
	
	
	private int code;

	public MetaData() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int created) {
		this.code = created;
	}

	public MetaData(String message,  int code) {
		super();
		this.message = message;
		this.code = code;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
