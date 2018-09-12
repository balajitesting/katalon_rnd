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

String A_Number = 'A80196'

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserReporting', '5xx1bkCcAlw=')

CustomKeywords.'com.gh.lims.Report.searchRequest'(A_Number)

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Reporting/Page_All Requests/select_TB Review BIP DataLD Re'), 60)

WebUI.selectOptionByValue(findTestObject('LIMS/DCO/Reporting/Page_All Requests/select_TB Review BIP DataLD Re'),
	'LD Review BIP Data', true)

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Reporting/Page_All Requests/td_Save'), 60)

WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_All Requests/td_Save'))

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Reporting/Page_All Requests/a_LD Review'), 60)

WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_All Requests/a_LD Review'))

WebUI.acceptAlert()

WebUI.setText(findTestObject('LIMS/DCO/Reporting/Page_Request List for LD Review/input_searchtext'), A_Number)

WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_Request List for LD Review/td_OK'))

CustomKeywords.'com.gh.lims.Report.clickBeginWorkflowLdReview'()

WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_CNV/div_SNV Review'))

WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_SNV/td_Fusion Review'))

WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_INDEL/td_Final Review'))

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Reporting/Page_Edit GHReportInfo/select_FINALAMENDEDCORRECTEDAD'), 180)

WebUI.selectOptionByValue(findTestObject('LIMS/DCO/Reporting/Page_Edit GHReportInfo/select_FINALAMENDEDCORRECTEDAD'),
	'AMENDED', true)

WebUI.verifyOptionSelectedByValue(findTestObject('LIMS/DCO/Reporting/Page_Edit GHReportInfo/select_FINALAMENDEDCORRECTEDAD'), 'AMENDED', true,
	30)

WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_Edit GHReportInfo/td_Generate Report'))

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Reporting/Page_Edit GHReportInfo/button_OK_gen_rep'), 120)

WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_Edit GHReportInfo/button_OK_gen_rep'))

Thread.sleep(3000)

WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_All Requests/a_CLS Review'))

WebUI.setText(findTestObject('LIMS/DCO/Reporting/Page_Request List for CLS Review/input_searchtext'), A_Number)

WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_Request List for CLS Review/td_OK'))

CustomKeywords.'com.gh.lims.Report.clickBeginWorkflowClsReview'()

WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_CNV/div_SNV Review'))

WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_Request List for CLS Review/td_Fusion Review'))

WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_Request List for CLS Review/td_Final Review'))

WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_Edit GHReportInfo/td_Release Report'))

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Reporting/Page_Edit GHReportInfo/button_OK_rel_rep'), 120)

WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_Edit GHReportInfo/button_OK_rel_rep'))

Thread.sleep(1000)

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()

Thread.sleep(2000)

String filename = ((A_Number + '_') + ReportStatus) + '_report.pdf'

String file1 = CustomKeywords.'com.gh.core.Properties.getGetPDFBaseDir'() + filename

String file2 = CustomKeywords.'com.gh.core.Properties.getGetPDFDownloadDir'() + filename

boolean val = CustomKeywords.'com.gh.core.PDFCompare.compareAndSave'(file1, file2)

CustomKeywords.'com.gh.core.PDFCompare.display'(val)
