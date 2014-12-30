package com.threegear.elasticsearch;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;

public enum ElasticClusterConnector {

	INSTANCE;

	private final Logger logger = Logger
			.getLogger(ElasticClusterConnector.class.getTypeName());

	private Client client;

	private ElasticClusterConnector() {
		Node node = NodeBuilder.nodeBuilder().node();
		client = node.client();

		logger.log(Level.INFO, "Successfully connected to elastic cluster.");
	}

	public Client getClient() {
		return client;
	}
}
