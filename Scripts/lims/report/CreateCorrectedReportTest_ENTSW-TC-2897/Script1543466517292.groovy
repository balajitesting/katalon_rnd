import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/**
 *
 * @author gxu
 *
 * This builds the LIMS fundation for viewing reports on Portal
 * ToDo:
 * 1. will add equivalent Jama Case ID later,
 * 2. Do PDF comparison later, will further modulize the PDF comparison part.
 *
 */

WebUI.comment('ENTSW-TC-2897')

A_Number = 'A86684'

String ReportStatus = 'CORRECTED'

CustomKeywords.'com.gh.lims.Common.logon'('abaca', '5Ed5CIkj9UQfaMZXAkDVaQ==')

CustomKeywords.'com.gh.lims.Report.searchRequest'(A_Number)

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_All Requests/select_TB Review BIP DataLD Re'), 60)

WebUI.selectOptionByValue(findTestObject('LIMS/DCO/Report/Page_All Requests/select_TB Review BIP DataLD Re'),
	'LD Review BIP Data', true)

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_All Requests/td_Save'), 60)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_All Requests/td_Save'))
Thread.sleep(2000);
WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_All Requests/a_LD Review'), 60)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_All Requests/a_LD Review'))

//WebUI.acceptAlert()

WebUI.setText(findTestObject('LIMS/DCO/Report/Page_Request List for LD Review/input_searchtext'), A_Number)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Request List for LD Review/td_OK'))


Thread.sleep(2000);
WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_Request List for CLS Review/td_Begin Workflow'), 60)
WebUI.click(findTestObject('LIMS/DCO/Report/Page_Request List for CLS Review/td_Begin Workflow'))

WebUI.click(findTestObject('LIMS/DCO/Report/Page_CNV/div_SNV Review'))

WebUI.click(findTestObject('LIMS/DCO/Report/Page_SNV/td_Fusion Review'))

WebUI.click(findTestObject('LIMS/DCO/Report/Page_INDEL/div_MSI Review'))

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_Select_Addendum/select_FINALAMENDEDCORRECTEDAD'), 30)

WebUI.selectOptionByValue(findTestObject('LIMS/DCO/Report/Page_Select_Addendum/select_FINALAMENDEDCORRECTEDAD'),
	'CORRECTED', true)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/td_Generate Report'))

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_gen_rep'), 120)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_gen_rep'))

Thread.sleep(3000)
WebUI.click(findTestObject('LIMS/DCO/Report/Page_All Requests/a_CLS Review'))

WebUI.setText(findTestObject('LIMS/DCO/Report/Page_Request List for CLS Review/input_searchtext'), A_Number)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Request List for CLS Review/td_OK'))

//CustomKeywords.'com.gh.lims.Common.setClick'(beginWorkFlow)

Thread.sleep(2000);
WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_Request List for CLS Review/td_Begin Workflow'), 60)
WebUI.click(findTestObject('LIMS/DCO/Report/Page_Request List for CLS Review/td_Begin Workflow'))

WebUI.click(findTestObject('LIMS/DCO/Report/Page_CNV/div_SNV Review'))

WebUI.click(findTestObject('LIMS/DCO/Report/Page_SNV/td_Fusion Review'))

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/td_Release Report'))

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_rel_rep'), 120)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_rel_rep'))

//WebUI.waitForElementPresent(findTestObject('LIMS/TMP/Page_Request List for CLS Review/img'), 10)

WebUI.maximizeWindow()

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()

CustomKeywords.'com.gh.core.PDFCompare.compareAndSave'(A_Number, ReportStatus)

return A_Number
