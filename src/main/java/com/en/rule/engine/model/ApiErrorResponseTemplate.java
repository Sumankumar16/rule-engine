package com.en.rule.engine.model;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * @author Suman Kumar
 *
 */
public class ApiErrorResponseTemplate  {
	
	private MetaData metadata;

	public ApiErrorResponseTemplate(MetaData metadata) {
		super();
		this.metadata = metadata;
	}

	public ApiErrorResponseTemplate() {
		super();
	}

	public MetaData getMetadata() {
		return metadata;
	}

	public void setMetadata(MetaData metadata) {
		this.metadata = metadata;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
