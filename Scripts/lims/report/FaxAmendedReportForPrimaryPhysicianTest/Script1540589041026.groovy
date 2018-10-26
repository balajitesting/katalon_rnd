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

import com.gh.db.LimsOracleDBService
import java.sql.ResultSet

WebUI.comment('Run: ENTC-2855')

String A_Number = 'A80196'

'Get the count of records in Fax table Prior to releasing the report'

String query = "select COUNT(*) as count from U_GHFAX U, S_REQUEST S WHERE U.REQUESTID = '"+A_Number+"' AND S.S_REQUESTID = U.REQUESTID ORDER BY S.MODDT DESC"

int countBeforeRelease = CustomKeywords.'com.gh.db.LimsDBOperation.getCount'(query)

//Validation 1: CLS releases Amended report to primary whose delivery method is "Fax"

String ReportStatus = 'AMENDED'

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserReporting', '5Ed5CIkj9UQfaMZXAkDVaQ==')

CustomKeywords.'com.gh.lims.Report.searchRequest'(A_Number)

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_All Requests/select_TB Review BIP DataLD Re'), 60)

WebUI.selectOptionByValue(findTestObject('LIMS/DCO/Report/Page_All Requests/select_TB Review BIP DataLD Re'),
	'LD Review BIP Data', true)

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_All Requests/td_Save'), 60)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_All Requests/td_Save'))

Thread.sleep(2000); //Wait command is not working properly. Hence, implemented the same.

WebUI.click(findTestObject('LIMS/DCO/Report/Page_All Requests/returnToList'))

Thread.sleep(1000); //Wait command is not working properly. Hence, implemented the same.

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_All Requests/a_LD Review'), 60)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_All Requests/a_LD Review'))

WebUI.setText(findTestObject('LIMS/DCO/Report/Page_Request List for LD Review/input_searchtext'), A_Number)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Request List for LD Review/td_OK'))

beginWorkFlow = 'LIMS/DCO/Report/Page_Request List for CLS Review/td_Begin Workflow'

CustomKeywords.'com.gh.lims.Common.setClick'(beginWorkFlow)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_CNV/div_SNV Review'))

WebUI.click(findTestObject('LIMS/DCO/Report/Page_SNV/td_Fusion Review'))

WebUI.click(findTestObject('LIMS/DCO/Report/Page_INDEL/div_MSI Review'))

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/select_FINALAMENDEDCORRECTEDAD'), 180)

WebUI.selectOptionByValue(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/select_FINALAMENDEDCORRECTEDAD'),
	'AMENDED', true)

WebUI.verifyOptionSelectedByValue(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/select_FINALAMENDEDCORRECTEDAD'), 'AMENDED', true,
	30)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/td_Generate Report'))

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_gen_rep'), 120)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_gen_rep'))

Thread.sleep(3000) //Wait command is not working properly. Hence, implemented the same.

WebUI.click(findTestObject('LIMS/DCO/Report/Page_All Requests/a_CLS Review'))

WebUI.setText(findTestObject('LIMS/DCO/Report/Page_Request List for CLS Review/input_searchtext'), A_Number)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Request List for CLS Review/td_OK'))

CustomKeywords.'com.gh.lims.Common.setClick'(beginWorkFlow)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_CNV/div_SNV Review'))

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Request List for CLS Review/td_Fusion Review'))

WebUI.click(findTestObject('LIMS/DCO/Report/Page_INDEL/div_MSI Review'))

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/td_Release Report'))

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_rel_rep'), 120)

Thread.sleep(2000) //Wait command is not working properly. Hence, implemented the same.

assert WebUI.getText(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/alert_msg')).contains('Fax was sent successfully') == true

Thread.sleep(2000) //Wait command is not working properly. Hence, implemented the same.

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_rel_rep'))

Thread.sleep(2000) //Wait command is not working properly. Hence, implemented the same.

WebUI.click(findTestObject('LIMS/DCO/Report/Page_All Requests/tab_AllRequests'))

WebUI.setText(findTestObject('LIMS/DCO/Report/Page_Request List/input_searchtext'), A_Number)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Request List/td_OK'))

Thread.sleep(2000) //Wait command is not working properly. Hence, implemented the same.

WebUI.switchToFrame(findTestObject('LIMS/Requests/AllRequests/list_iFrame'), 3)

assert WebUI.getText(findTestObject('LIMS/DCO/Report/Page_All Requests/reqStatus')).contains("Released") == true

WebUI.closeBrowser()

//Validation2: Verify record count in u_ghfax table

int countAfterRelease = CustomKeywords.'com.gh.db.LimsDBOperation.getCount'(query)

assert (countAfterRelease - countBeforeRelease).equals(1) 
