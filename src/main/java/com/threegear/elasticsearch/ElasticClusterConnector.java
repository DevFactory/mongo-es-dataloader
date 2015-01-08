package com.threegear.elasticsearch;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public enum ElasticClusterConnector
{
	INSTANCE;

	private final Logger logger = Logger.getLogger( ElasticClusterConnector.class.getTypeName() );

	private Client client;

	private ElasticClusterConnector()
	{
		Settings settings = ImmutableSettings.settingsBuilder().put( "cluster.name", "elasticsearch" ).build();

		client = new TransportClient( settings ).addTransportAddress( new InetSocketTransportAddress( "127.0.0.1", 9300 ) );

		logger.log( Level.INFO, "Successfully connected to elastic cluster." );
	}

	public Client getClient()
	{
		return client;
	}

	public void shutdownClient()
	{
		client.close();
	}
}
