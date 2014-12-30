package com.threegear.model;

import java.util.List;

public class IndexConfigModel {
	
	private String collection;
	
	private String index;
	
	private List<FieldMappingModel> mappings;

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public List<FieldMappingModel> getMappings() {
		return mappings;
	}

	public void setMappings(List<FieldMappingModel> mappings) {
		this.mappings = mappings;
	}
}
