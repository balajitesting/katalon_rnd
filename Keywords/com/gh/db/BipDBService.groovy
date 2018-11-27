package com.gh.db

import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.sql.Connection;
import groovy.sql.Sql

import internal.GlobalVariable

import com.kms.katalon.core.annotation.Keyword

/**
 * Connect to Portal DB.
 * Execute Query and non-query statement.
 *
 * @author gxu
 * @date 11/26/2018
 *
 */


public class BipDBService {

	private static Connection connection = null;

	@Keyword
	def connectDB(String dbUrl, String username, String password) {

		String conn = "jdbc:postgresql://" + dbUrl

		Properties props = new Properties();

		props.setProperty("user", username);
		props.setProperty("password", password);

		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = DriverManager.getConnection(conn, username, password)

		return connection
	}


	//	String url = "jdbc:postgresql://localhost/test";
	//	Properties props = new Properties();
	//	props.setProperty("user","fred");
	//	props.setProperty("password","secret");
	//	props.setProperty("ssl","true");
	//	Connection conn = DriverManager.getConnection(url, props);
	//
	//	String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
	//	Connection conn = DriverManager.getConnection(url);

	/**
	 * execute a SQL query on database
	 * @param queryString SQL query string
	 * @return a reference to returned data collection, an instance of java.sql.ResultSet
	 *
	 */

	@Keyword
	def executeQuery(String queryString) {
		Statement stm = connection.createStatement()
		ResultSet rs = stm.executeQuery(queryString)
		return rs
	}

}
