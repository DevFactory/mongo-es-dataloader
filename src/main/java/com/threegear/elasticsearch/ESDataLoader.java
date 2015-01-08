package com.threegear.elasticsearch;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.Client;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.threegear.model.IndexConfigModel;

public class ESDataLoader
{
	private final static Logger logger = Logger.getLogger( ESDataLoader.class.getTypeName() );

	public static void loadData( DBCursor cursor, IndexConfigModel configuration ) throws IOException
	{
		Client client = ElasticClusterConnector.INSTANCE.getClient();

		BulkRequestBuilder requestBuilder = client.prepareBulk();

		while ( cursor.hasNext() )
		{
			DBObject data = cursor.next();

			Object id = data.get( "_id" );

			IndexRequestBuilder indxReqBuilder;

			if ( id == null )
			{
				indxReqBuilder = client.prepareIndex( configuration.getIndex(), configuration.getIndexType() );
			}
			else
			{
				indxReqBuilder = client.prepareIndex( configuration.getIndex(), configuration.getIndexType(), id.toString() );
			}

			indxReqBuilder.setSource( data.toString() );

			requestBuilder.add( indxReqBuilder );
		}

		BulkResponse bulkResponse = requestBuilder.execute().actionGet();

		if ( bulkResponse.hasFailures() )
		{
			logger.log( Level.WARNING, bulkResponse.buildFailureMessage() );
		}
	}
}
