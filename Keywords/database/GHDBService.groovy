package database

import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.sql.Connection;
import groovy.sql.Sql

import com.kms.katalon.core.annotation.Keyword
//import com.mysql.jdbc.Connection

/**
 * This class provides Keywords for:
 * Connect to GuardantHealth Mysql, Oracle and PostgreSql Databases.
 * Execute Query and non-query statement.
 * 
 * @author gxu
 * @date 07/18/2018
 * 
 */

public class GHDBService {

	private static Connection portalConnect = null;
	//private static Sql limsConnect = null;
	private static Sql ghdbConnect = null;

	private static Connection connection = null;

	/**
	 * Open and return a connection to database
	 * @param dataFile absolute file path
	 * @return an instance of java.sql.Connection
	 */

	//	@Keyword
	//	def connectPortalDB(String url, String username, String password) {
	//
	//		String conn = "jdbc:mysql://" + url
	//		Class.forName("com.mysql.cj.jdbc.Driver")
	//
	//		if (portalConnect != null && !portalConnect.isClosed()) {
	//			portalConnect.close()
	//		}
	//		portalConnect = DriverManager.getConnection(conn, username, password)
	//	}

	//	@Keyword
	//	def connectLimsDB(String url, String username, String password) {
	//
	//		String conn = "jdbc:oracle:thin:@" + url
	//
	//		//Class.forName("oracle.jdbc.driver.OracleDriver")
	//
	//		Sql connection = Sql.newInstance(conn, username, password)
	//		//println ("MyData " + limsConnect.firstRow('select * from s_request').values())
	//
	//		if(connection != null && !connection.isClosed()){
	//
	//		   connection.close()
	//
	//		}
	//
	//		connection = DriverManager.getConnection(conn, username, password)
	//
	//		return connection
	//	}

	//	@Keyword
	//	def connectGHDB(String url, String username, String password) {
	//		String conn = "jdbc:postgresql://" + url
	//		Class.forName("org.postgresql.Driver")
	//
	//		if (ghdbConnect != null && !ghdbConnect.isClosed()) {
	//			ghdbConnect.close()
	//		}
	//		ghdbConnect = DriverManager.getConnection(conn, username, password)
	//	}

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
	 */

	@Keyword
	def executeQuery(String queryString) {
		Statement stm = connection.createStatement()
		ResultSet rs = stm.executeQuery(queryString)
		return rs
	}

	@Keyword
	def queryLIMS(Sql connection, String queryString) {
		connection

		//limsConnect.firstRow(queryString){ row -> println row }

	}

	//	@Keyword
	//	def closeOracleDBConnection() {
	//		if (limsConnect != null) {
	//			limsConnect.close()
	//		}
	//		limsConnect = null
	//	}

	/**
	 * Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database
	 * @param queryString a SQL statement
	 * @return single value result of SQL statement
	 */
	//	@Keyword
	//	def execute(String queryString) {
	//		Statement stm = connection.createStatement()
	//		boolean result = stm.execute(queryString)
	//		return result
	//	}

	/**	
	 * Establishing a connection to the DataBase
	 * String conn = "jdbc:oracle:thin:@" + url + ":" + port + "/" + sid
	 * String conn = "jdbc:mysql://" + url + ":" + port + "/" + dbname
	 * String conn = "jdbc:postgresql://" + url + ":" + port + "/" + dbname
	 */

	//	@Keyword
	//	def connectDB(String url, String dbname, String port, String username, String password) {
	//
	//		String conn = "jdbc:mysql://" + url + ":" + port + "/" + dbname
	//
	//		if (connection != null && !connection.isClosed()) {
	//			connection.close()
	//		}
	//		connection = DriverManager.getConnection(conn, username, password)
	//	}

}
