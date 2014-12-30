package com.threegear.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.threegear.model.IndexConfigModel;

public enum MongoESMapper
{
	INSTANCE;

	private final Logger logger = Logger.getLogger( this.getClass().getTypeName() );

	private List<IndexConfigModel> configuration;

	private MongoESMapper()
	{
		FileReader freader;
		try
		{
			freader = new FileReader( "mongo-es-mapping.json" );

			Type listType = new TypeToken<ArrayList<IndexConfigModel>>()
			{
			}.getType();

			configuration = new Gson().fromJson( freader, listType );
		}
		catch ( FileNotFoundException e )
		{
			e.printStackTrace();
			logger.log( Level.SEVERE, System.getProperty( "user.dir" ) );
			logger.log( Level.SEVERE, "Failed to read mongo-es-mapping." );
		}
	}

	public List<IndexConfigModel> getConfiguration()
	{
		return configuration;
	}
}
