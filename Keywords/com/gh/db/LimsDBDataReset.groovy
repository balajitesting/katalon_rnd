package com.gh.db

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class LimsDBDataReset {

	@Keyword
	def redoFinalReport(String requestId){

		LimsOracleDBService db = new LimsOracleDBService();

		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);

		String query = "update s_request set u_finalreportdate = '', u_latestreportdate = '' where s_requestid in ('"+requestId+"')";

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
