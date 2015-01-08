package com.threegear;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.flush.FlushRequest;
import org.elasticsearch.client.Client;

import com.mongodb.DBCursor;
import com.threegear.common.MongoESMapper;
import com.threegear.elasticsearch.ESDataLoader;
import com.threegear.elasticsearch.ElasticClusterConnector;
import com.threegear.model.IndexConfigModel;
import com.threegear.mongo.DatabaseUtil;

public class MongoESMapperTest
{
	private final static Logger logger = Logger.getLogger( MongoESMapperTest.class.getTypeName() );

	public static void main( String[] args ) throws IOException
	{
		logger.log( Level.INFO, "Start time : " + new Date() );

		Client client = ElasticClusterConnector.INSTANCE.getClient();
		
		DeleteIndexResponse delete = client.admin().indices().delete( new DeleteIndexRequest( "atomconnect" ) ).actionGet();
		if ( !delete.isAcknowledged() )
		{
			logger.log( Level.SEVERE, "Index wasn't deleted" );
		}

		IndexConfigModel[] configs = MongoESMapper.INSTANCE.getConfiguration();

		for ( IndexConfigModel config : configs )
		{
			DBCursor cursor = DatabaseUtil.getData( config );

			ESDataLoader.loadData( cursor, config );
		}

		client.admin().indices().flush( new FlushRequest( "atomconnect" )).refresh( true ) ).actionGet();

		logger.log( Level.INFO, "End time : " + new Date() );
	}
}
