package com.en.rule.engine.model.enums;
public enum StringValueType {
	HIGH("HIGH"), LOW("LOW");
	
	final private String value;
	
	StringValueType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static String getValueByValueType(String value) {
        for (int i = 0; i < StringValueType.values().length; i++) {
            if (value.equals(StringValueType.values()[i].value))
                return StringValueType.values()[i].name();
        }
        return null;
    }
	
}