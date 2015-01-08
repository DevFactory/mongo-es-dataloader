package com.threegear.common;

import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.threegear.model.IndexConfigModel;

public enum MongoESMapper
{
	INSTANCE;

	private final Logger logger = Logger.getLogger( this.getClass().getTypeName() );

	private IndexConfigModel[] configuration;

	private MongoESMapper()
	{
		FileReader freader;
		try
		{
			freader = new FileReader( "mongo-es-mapping.json" );

			configuration = new Gson().fromJson( freader, IndexConfigModel[].class );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
			logger.log( Level.SEVERE, "Failed to read mongo-es-mapping." );
		}
	}

	public IndexConfigModel[] getConfiguration()
	{
		return configuration;
	}
}
