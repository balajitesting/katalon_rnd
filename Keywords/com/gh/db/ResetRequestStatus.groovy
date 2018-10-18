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


class ResetRequestStatus {


	/**
	 * Click element
	 * @param to Katalon test object
	 * 
	 * Valid status update value
	 * 
	 *  Sent To Nof1
	 Pending Clinical Diagnosis
	 Ready for Plasma Isolation
	 Redo Samples
	 CLS Review and Release Report
	 Sequencing QC
	 Hold Report Review
	 TB Review BIP Data
	 Ready for Release Report
	 Pending Queue
	 LD Review BIP Data
	 Released
	 Closed
	 Ready for Generate Report
	 Ready for IVD Review
	 Ready for IVD Report Generation and Release
	 Generate and Release Cancelled Report
	 */
	@Keyword
	def reset(String requestID, String status) {

		LimsOracleDBService db = new LimsOracleDBService();
		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);

		String query = "update s_request set u_ghrequeststatus = '"+status+"' where s_requestid = '"+requestID+"'";
		db.execute(query);
	}

	@Keyword
	def resetBilling(String requestID) {

		LimsOracleDBService db = new LimsOracleDBService();
		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);

		String updateBilling = "update s_request set u_billingverified = null,  u_abnstatus = null, u_releventnsclc = null, u_patientmedstatus = null, u_ispatientbenefitsauth = null where s_requestid = '"+requestID+"'";
		db.execute(updateBilling);

		String delBilling = "delete from u_ghbilling where  requestid = '"+requestID+"'";
		db.execute(delBilling);
	}
}