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

	@Keyword
	def resetXIFINAccession(String requestID) {

		LimsOracleDBService db = new LimsOracleDBService();
		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);

		String updateFinalReportDate = "update s_request set u_finalreportdate = null where s_requestid = '"+requestID+"'";
		db.execute(updateFinalReportDate);
		
		String updateXIFINAccession = "update s_request set u_xifinaccession = null where s_requestid = '"+requestID+"'";
		db.execute(updateXIFINAccession);
	}

	/**
	 *
	 * Valid status update value
	 *
	 * AutoPass
	 * ManualSeqQC
	 */
	@Keyword
	def resetFlowCellStatus(String flowcellID, String status) {

		LimsOracleDBService db = new LimsOracleDBService();
		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);

		String query = "update u_ghflowcell set flowcellstatus = '"+status+"' where u_ghflowcellid = '"+flowcellID+"'";
		db.execute(query);
	}

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
	def resetRequestStatus(String requestID, String status) {

		LimsOracleDBService db = new LimsOracleDBService();
		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);

		String query = "update s_request set u_ghrequeststatus = '"+status+"' where s_requestid = '"+requestID+"'";
		db.execute(query);
	}
	/* valid value for status
	 * 
	 * status = '0'
	 * status = '1'
	 * 
	 */
	@Keyword
	def resetDVStatus(String requestID, String status) {

		LimsOracleDBService db = new LimsOracleDBService();
		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);

		String query = "update s_request set u_dvcheck = '"+status+"' where s_requestid = '"+requestID+"'";
		db.execute(query);
	}
	/* valid value for status
	 *
	 * status = '0'
	 * status = '1'
	 *
	 */
	@Keyword
	def resetDV2Status(String requestID, String status) {

		LimsOracleDBService db = new LimsOracleDBService();
		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);

		String query = "update s_request set u_dv2check = '"+status+"' where s_requestid = '"+requestID+"'";
		db.execute(query);
	}
	/* 
	 * It will removed all the problem case associated with the requestID 
	 */
	@Keyword
	def resetProblemCase(String requestID) {

		LimsOracleDBService db = new LimsOracleDBService();
		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);

		String query = "delete from u_ghreqfollowup where requestid = '"+requestID+"'";
		db.execute(query);
	}

	/**
	 *  valid status
	 *
	 Batched For Plasma Isolation
	 Failed
	 Redo Samples
	 Ready for Plasma Isolation
	 Analytics in progress
	 Ready for DNA Extraction
	 Freezer
	 Sample Archive
	 blank
	 Depleted
	 Closed
	 Ready for IVD Report Generation and Release
	 Ready for IVD Review
	 ReadyForDNAExtraction
	 Waiting for Pool
	 *
	 */
	@Keyword
	def resetSampleStatus(String sampleID, String status) {

		LimsOracleDBService db = new LimsOracleDBService();
		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);

		String query = "update s_sample set u_ghsamplestatus = '"+status+"' where s_sampleid = '"+sampleID+"'";
		db.execute(query);
	}

	@Keyword
	def resetStorageStatus(String sampleID) {

		LimsOracleDBService db = new LimsOracleDBService();
		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);

		String query1 = "update trackitem set currentstorageunitid = null where linkkeyid1 = '"+sampleID+"'";
		db.execute(query1);

		String query2 = "update s_sample set u_ghsamplestatus = 'Sample Archive' where s_sampleid = '"+sampleID+"'";
		db.execute(query2);
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def BIP_delete_by_flowcellID(String flowcellid) {


		LimsOracleDBService db = new LimsOracleDBService();
		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);

		String query = "Delete from U_Ghsnv Where Runid = '"+flowcellid+"'";
		int delete_count = 0;
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");

		query = "Delete from U_Ghcnvgene Where Runid = '"+flowcellid+"'";
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");

		query = "Delete from U_Ghfusion Where Runid = '"+flowcellid+"'";
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");

		query = "Delete from U_Ghindel Where Runid = '"+flowcellid+"'";
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");

		query = "Delete from U_Ghreportinfo Where Runid = '"+flowcellid+"'";
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");

		query = "Delete from u_ghboard Where Runid = '"+flowcellid+"'";
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");

		query = "Delete from u_ghlod Where Runid = '"+flowcellid+"'";
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");

		query = "Delete from U_GHMIRATIELIGIBILITY Where Runid = '"+flowcellid+"'";
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");


		String [] temp = flowcellid.split("_");
		if (temp.length != 4) {
			System.out.println("Invalid flowcellid");
			System.out.println(flowcellid);
			System.exit(1);
		}
		temp[3] = temp[3].substring(1, temp[3].length());


		query = "Delete from u_ghcontrolqc where flowcellid ='"+temp[3]+"'";
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");

		query = "delete from u_ghsampleqcmetrics Where flowcellid ='"+temp[3]+"'";
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");

		query = "delete from u_ghflowcell where u_ghflowcellid ='"+temp[3]+"'";
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");

		query = "delete from u_ghsampleqc Where Runid = '"+flowcellid+"'";
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");

		query = "delete from u_ghsamplecoverage Where Runid = '"+flowcellid+"'";
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");

		query = "delete from u_ghtmb Where Runid = '"+flowcellid+"'";
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");

		query = "delete from u_ghmsi where runid like '"+flowcellid+"'";
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");
	}

	@Keyword
	def BIP_delete_by_sampleID(String sampleID) {


		LimsOracleDBService db = new LimsOracleDBService();
		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);

		String query = "Delete from U_Ghsnv Where sampleid = '"+sampleID+"'";
		int delete_count = 0;
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");

		query = "Delete from U_Ghcnvgene Where sampleid = '"+sampleID+"'";
		delete_count = 0;
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");

		query = "Delete from U_Ghfusion Where sampleid = '"+sampleID+"'";
		delete_count = 0;
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");

		query = "Delete from U_Ghindel Where sampleid = '"+sampleID+"'";
		delete_count = 0;
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");

		query = "Delete from U_Ghreportinfo Where sampleid = '"+sampleID+"'";
		delete_count = 0;
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");

		query = "Delete from u_ghboard Where sampleid = '"+sampleID+"'";
		delete_count = 0;
		System.out.println(query);
		delete_count = db.executeUpdate(query);
		System.out.println("Deleted " + delete_count + " rows");
	}
}
