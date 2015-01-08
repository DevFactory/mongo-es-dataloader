package com.threegear.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.threegear.model.FieldMappingModel;
import com.threegear.model.IndexConfigModel;

public class DatabaseUtil
{
	public static DBCursor getData( IndexConfigModel configModel )
	{
		DBCollection collection = MongoDBConnector.INSTANCE.getDatabase().getCollection( configModel.getCollection() );

		if ( configModel.getMappings() == null )
		{
			return null;
		}

		DBObject projections = new BasicDBObject();

		for ( FieldMappingModel mapping : configModel.getMappings() )
		{
			projections.put( mapping.getDbField(), true );
		}

		return collection.find( new BasicDBObject(), projections );
	}
}
