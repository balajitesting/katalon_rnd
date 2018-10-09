package com.gh.db

import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.sql.Connection;
import groovy.sql.Sql

import com.kms.katalon.core.annotation.Keyword

/**
 * Connect to GuardantHealth Oracle DB.
 * Execute Query and non-query statement.
 *
 * @author gxu
 * @date 08/18/2018
 *
 */


public class LimsOracleDBService {

	private static Connection connection = null;

	@Keyword
	def connectDB(String dbUrl, String username, String password) {

		String conn = "jdbc:oracle:thin:@" + dbUrl

		Class.forName("oracle.jdbc.driver.OracleDriver")

		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = DriverManager.getConnection(conn, username, password)

		return connection
	}

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

	@Keyword
	def execute(String query) {
		System.out.println(query);
		Statement stm = connection.createStatement();
		stm.execute(query);
		
	}
	
	@Keyword
	def executeUpdate(String query) {
		Statement stm = connection.createStatement();
		connection.setAutoCommit(false);
		String value = stm.executeUpdate(query);
		connection.commit();
		return Integer.parseInt(value);
	}

	@Keyword
	def closeDatabaseConnection() {

		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = null
	}
}


