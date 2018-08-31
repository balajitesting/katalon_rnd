package database

import groovy.sql.Sql
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet
import java.sql.SQLException;
import java.sql.Statement
import java.util.Properties;

public class LIMSDBService {

	public static Connection connectionR;
	public static Sql connection;

	public Connection connectLimsDB(String dbUrl, String username, String password){

		Class.forName("oracle.jdbc.driver.OracleDriver")

		connection = DriverManager.getConnection(dbUrl, username, password);

		if (connection != null) {
			System.out.println("Connected with connection #2");
		}

		return connection;
	}

	public static Connection connectLimsDB2(String url, String username, String password) {

		String conn = "jdbc:oracle:thin:@" + url

		Class.forName("oracle.jdbc.OracleDriver");

		connectionR = DriverManager.getConnection(url, username, password);

		//Sql connection = Sql.newInstance(conn, username, password)
		//println ("MyData " + connection.firstRow('select * from s_request').values())
		//println ("MyData " + connection.firstRow(queryStr).values())

		return connection
	}

	public static connectLimsDB3(String url, String username, String password) {

		String conn = "jdbc:oracle:thin:@" + url

		Class.forName("oracle.jdbc.driver.OracleDriver")

		connection = Sql.newInstance(conn, username, password)
		//println ("MyData " + connection.firstRow('select * from s_request').values())
		//println ("MyData " + connection.firstRow(queryStr).values())

		//return connection
	}

	public static executeQuery(String queryStr) {

		//		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_UPDATABLE);
		//
		//		ResultSet result = statement.executeQuery(queryStr);

		println (connection.firstRow('select * from s_request').values())
		//connection.eachRow(queryStr) { row -> println "$row" }

	}

	public static ResultSet executeQueryStm(String queryStr) {

		Statement statement = connectionR.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_UPDATABLE);
		ResultSet result = statement.executeQuery(queryStr);

		return result;
	}
}
