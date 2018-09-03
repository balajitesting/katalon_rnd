import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable


import internal.GlobalVariable as GlobalVariable
import java.sql.ResultSet

String aNumber= 'A80196'
String table = "u_ghcnvgene";
String query = "select count(*) from "+ table+ " where sampleid like '"+ aNumber +"%' and isSupportedCnvGene = '1'";

CustomKeywords.'com.gh.db.LimsOracleDBService.connectDB'(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd)

ResultSet rs = CustomKeywords.'com.gh.db.LimsOracleDBService.executeQuery'(query)

if(rs.next()) {
	
  String s = rs.getString(1);
  println 'Data fetched from DB: ' + s
  
}

while (rs.next()) {
	
	String reportS = rs.getString("GHCNVGENEID")
	rs.getRow()
}

CustomKeywords.'com.gh.db.LimsOracleDBService.closeDatabaseConnection'()

