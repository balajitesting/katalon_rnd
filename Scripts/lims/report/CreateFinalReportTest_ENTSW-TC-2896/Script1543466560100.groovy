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

WebUI.comment('ENTSW-TC-2896')

A_Number = 'A0112848'

CustomKeywords.'com.gh.db.LimsDBDataReset.redoFinalReport'(A_Number)

String ReportStatus = 'FINAL'

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserReporting', '5Ed5CIkj9UQfaMZXAkDVaQ==')

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

//beginWorkFlow = 'LIMS/DCO/Report/Page_Request List for CLS Review/td_Begin Workflow'

//CustomKeywords.'com.gh.lims.Common.setClick'(beginWorkFlow)



WebUI.click(findTestObject('LIMS/DCO/Report/Page_CNV/div_SNV Review'))

WebUI.click(findTestObject('LIMS/DCO/Report/Page_SNV/td_Fusion Review'))

//WebUI.click(findTestObject('LIMS/DCO/Report/Page_FUSION/div_Indel Review'))

WebUI.click(findTestObject('LIMS/DCO/Report/Page_INDEL/div_MSI Review'))

//WebUI.click(findTestObject('LIMS/DCO/Report/Page_MSI/div_Final Review'))

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/td_Generate Report'))

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_gen_rep'), 30)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_gen_rep'))

//WebUI.waitForElementPresent(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_gen_rep'), 30)

WebUI.waitForElementPresent(findTestObject('LIMS/DCO/Report/Page_Request List for LD Review/a_CLS Review'), 30)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Request List for LD Review/a_CLS Review'))

WebUI.setText(findTestObject('LIMS/DCO/Report/Page_Request List for CLS Review/input_Search_searchtext'), A_Number)

WebUI.click(findTestObject('LIMS/DCO/report/Page_Request List for CLS Review/td_OK'))

beginWorkFlow = 'LIMS/DCO/report/Page_Request List for LD Review/div_Begin Workflow'

CustomKeywords.'com.gh.lims.Common.setClick'(beginWorkFlow)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_SNV/td_Fusion Review'))

WebUI.click(findTestObject('LIMS/DCO/Report/Page_INDEL/div_MSI Review'))

//WebUI.click(findTestObject('LIMS/DCO/Report/Page_MSI/div_Final Review'))

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/td_Release Report'))

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_rel_rep'), 120)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_rel_rep'))

WebUI.maximizeWindow()

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()

CustomKeywords.'com.gh.core.PDFCompare.compareAndSave'(A_Number, ReportStatus)

return A_Number