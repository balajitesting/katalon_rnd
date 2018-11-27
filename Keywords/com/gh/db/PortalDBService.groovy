package com.gh.db

import internal.GlobalVariable
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.sql.Connection;
import groovy.sql.Sql
import com.kms.katalon.core.annotation.Keyword


/**
 * 
 * @author gxu
 * @date 11/26/2018
 *
 */

public class PortalDBService {

	private static Connection connection = null;

	@Keyword
	public connectGhODS(String dbUrl, String usr, String pwd){

		Class.forName("com.mysql.jdbc.Driver");

		if(connection != null && !connection.isClosed()){
			connection.close()
		}

		connection = DriverManager.getConnection(
				"jdbc:mysql://" + dbUrl + ":3306/ghods", usr, pwd);
	}

	@Keyword
	public connectGhPortalODS(String dbUrl, String usr, String pwd){

		Class.forName("com.mysql.jdbc.Driver");

		if(connection != null && !connection.isClosed()){
			connection.close()
		}

		connection = DriverManager.getConnection(
				"jdbc:mysql://" + dbUrl + ":3306/gh_portal_ods", usr, pwd);
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
}
