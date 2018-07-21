package com.en.rule.engine.model;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * @author Suman Kumar
 */
public class ApiResponseTemplate  {
	
	private MetaData metadata;
	
	private Data data;

	public ApiResponseTemplate(MetaData metadata, Data data) {
		super();
		this.metadata = metadata;
		this.data = data;
	}
	
	public ApiResponseTemplate() {
		super();
	}

	public MetaData getMetadata() {
		return metadata;
	}

	public void setMetadata(MetaData metadata) {
		this.metadata = metadata;
	}

	public Data getData() {
		return data;
	}
	
	public void setData(Data data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
