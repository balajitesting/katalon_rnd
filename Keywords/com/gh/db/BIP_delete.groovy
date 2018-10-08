package com.gh.db
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class BIP_delete {


	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def delete_data(String flowcellid) {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String serverName = "10.4.80.106";
		String portNumber = "1521";
		String sid = "orclgh";
		String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
		String username = GlobalVariable.oracleDBuser;
		String password = GlobalVariable.oracleDBpwd;
		Connection con = DriverManager.getConnection(url, username, password);

		Statement st= con.createStatement();

		con.setAutoCommit(false);

		String query = "Delete from U_Ghsnv Where Runid = '"+flowcellid+"'";
		int delete_count = 0;
		System.out.println(query);
		//output.write(query+"\n");
		delete_count = st.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");
		//output.write("Deleted " + delete_count + " rows"+"\n");
		con.commit();

		query = "Delete from U_Ghcnvgene Where Runid = '"+flowcellid+"'";
		System.out.println(query);
		//output.write(query+"\n");

		delete_count = st.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");
		//output.write("Deleted " + delete_count + " rows");
		con.commit();

		query = "Delete from U_Ghfusion Where Runid = '"+flowcellid+"'";
		System.out.println(query);
		//output.write(query+"\n");
		delete_count = st.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");
		//output.write("Deleted " + delete_count + " rows"+"\n");
		con.commit();


		query = "Delete from U_Ghindel Where Runid = '"+flowcellid+"'";
		System.out.println(query);
		delete_count = st.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");
		con.commit();


		query = "Delete from U_Ghreportinfo Where Runid = '"+flowcellid+"'";
		System.out.println(query);
		//output.write(query+"\n");
		delete_count = st.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");
		//output.write("Deleted " + delete_count + " rows"+"\n");
		con.commit();

		query = "Delete from u_ghboard Where Runid = '"+flowcellid+"'";
		System.out.println(query);
		//output.write(query+"\n");
		delete_count = st.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");
		//output.write("Deleted " + delete_count + " rows"+"\n");
		con.commit();

		query = "Delete from u_ghlod Where Runid = '"+flowcellid+"'";
		System.out.println(query);
		//output.write(query+"\n");
		delete_count = st.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");
		//output.write("Deleted " + delete_count + " rows"+"\n");
		con.commit();

		query = "Delete from U_GHMIRATIELIGIBILITY Where Runid = '"+flowcellid+"'";
		System.out.println(query);
		//output.write(query+"\n");
		delete_count = st.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");
		//output.write("Deleted " + delete_count + " rows"+"\n");
		con.commit();


		String [] temp = flowcellid.split("_");
		if (temp.length != 4)
		{
			System.out.println("Invalid flowcellid");
			System.out.println(flowcellid);
			System.exit(1);
		}
		temp[3] = temp[3].substring(1, temp[3].length());

		//
		query = "Delete from u_ghcontrolqc where flowcellid ='"+temp[3]+"'";
		System.out.println(query);
		//output.write(query+"\n");
		delete_count = st.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");
		//output.write("Deleted " + delete_count + " rows"+"\n");
		con.commit();
		//
		query = "Delete from u_ghsampleqcmetrics Where flowcellid ='"+temp[3]+"'";
		System.out.println(query);
		//output.write(query+"\n");
		delete_count = st.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");
		//output.write("Deleted " + delete_count + " rows"+"\n");
		con.commit();

		//

		query = "Delete from u_ghflowcell where u_ghflowcellid ='"+temp[3]+"'";
		System.out.println(query);
		//output.write(query+"\n");
		delete_count = st.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");
		//output.write("Deleted " + delete_count + " rows"+"\n");
		con.commit();

		con.close();
	}

}