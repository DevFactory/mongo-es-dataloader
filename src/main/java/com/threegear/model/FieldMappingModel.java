package com.threegear.model;

public class FieldMappingModel {

	private String dbField;

	private String esField;

	private String type;

	public String getDbField() {
		return dbField;
	}

	public void setDbField(String dbField) {
		this.dbField = dbField;
	}

	public String getEsField() {
		return esField;
	}

	public void setEsField(String esField) {
		this.esField = esField;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
