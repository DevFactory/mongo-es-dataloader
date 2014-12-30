package com.threegear.elasticsearch.common;

import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;

public enum ElasticClusterConnector {

	INSTANCE;

	private Client client;

	private ElasticClusterConnector() {
		Node node = NodeBuilder.nodeBuilder().node();
		client = node.client();
	}

	public Client getClient() {
		return client;
	}
}
