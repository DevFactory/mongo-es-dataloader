package com.threegear.model;

import java.util.List;

public class IndexConfigModel
{

	private String collection;

	private String index;

	private String indexType;

	private List<FieldMappingModel> mappings;

	public String getCollection()
	{
		return collection;
	}

	public void setCollection( String collection )
	{
		this.collection = collection;
	}

	public String getIndex()
	{
		return index;
	}

	public void setIndex( String index )
	{
		this.index = index;
	}

	public String getIndexType()
	{
		return indexType;
	}

	public void setIndexType( String indexType )
	{
		this.indexType = indexType;
	}

	public List<FieldMappingModel> getMappings()
	{
		return mappings;
	}

	public void setMappings( List<FieldMappingModel> mappings )
	{
		this.mappings = mappings;
	}
}
