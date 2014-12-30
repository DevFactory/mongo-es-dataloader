package com.threegear.elasticsearch.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public enum MongoDBConnector {
	INSTANCE;

	private final Logger logger = Logger.getLogger(MongoDBConnector.class
			.getTypeName());

	private Properties dbProperties;

	private MongoClient mongoClient;

	private DB dataBase;

	private MongoDBConnector() {
		try {
			loadDbProperties();

			mongoClient = new MongoClient(getDBIpAddress(), getDBPort());
			dataBase = mongoClient.getDB(getDBName());
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "Failed to open connection to DB : "
					+ getDBName() + " at IP : " + getDBIpAddress()
					+ " and Port : " + getDBPort());

			throw new RuntimeException(e);
		}
	}

	private void loadDbProperties() throws IOException {
		FileInputStream fin = new FileInputStream("dbConfig.properties");

		dbProperties = new Properties();
		dbProperties.load(fin);
	}

	private String getDBName() {
		return dbProperties.getProperty(Constants.DB_NAME);
	}

	private int getDBPort() {
		return Integer.parseInt(dbProperties.getProperty(Constants.DB_PORT));
	}

	private String getDBIpAddress() {
		return dbProperties.getProperty(Constants.DB_IPADDRESS);
	}

	public DB getDatabase() {
		return dataBase;
	}
}
