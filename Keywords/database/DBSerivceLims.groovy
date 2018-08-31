package database

import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import com.kms.katalon.core.annotation.Keyword
import groovy.sql.Sql
//import com.mysql.jdbc.Connection

public class DBSerivceLims {

	private static Sql connection = null;

	/**
	 * @author gxu
	 * 
	 * Open and return a connection to database
	 * @param dataFile absolute file path
	 * @return an instance of java.sql.Connection
	 * 
	 */

	//Establishing a connection to the DataBase

	@Keyword
	def Sql connectLimsDB(String dbUrl, String username, String password) {

		String conn = "jdbc:oracle:thin:@" + dbUrl

		Class.forName("oracle.jdbc.driver.OracleDriver")

		Sql connection = Sql.newInstance(conn, username, password)
		println ("\nTable: " + connection.firstRow('select * from s_request').keySet())
		println ("\nFirst Row data: " + connection.firstRow('select * from s_request').values())

		return conn
	}

	/**
	 * execute a SQL query on database
	 * @param queryString SQL query string
	 * @return a reference to returned data collection, an instance of java.sql.ResultSet
	 */

	//Executing the constructed Query and Saving results in resultset

	@Keyword

	def executeQuery(String queryString) {

		Statement stm = connection.createStatement()

		ResultSet rs = stm.executeQuery(queryString)

		return rs

	}

	//Closing the connection

	@Keyword

	def closeDatabaseConnection() {

		if(connection != null && !connection.isClosed()){

			connection.close()

		}

		connection = null

	}

	/**
	 * Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database
	 * @param queryString a SQL statement
	 * @return single value result of SQL statement
	 */

	@Keyword

	def execute(String queryString) {

		Statement stm = connection.createStatement()

		boolean result = stm.execute(queryString)

		return result

	}
}
