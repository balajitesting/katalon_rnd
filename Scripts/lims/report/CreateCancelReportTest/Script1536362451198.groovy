import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.junit.After as After
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.gh.PDFCompare as PDFCompare
import com.gh.core.Properties as Properties
import com.gh.core.PDFCompare as PDFCompare
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

WebUI.callTestCase(findTestCase('lims/request/SearchRequestCancelReportTest'), [:], FailureHandling.STOP_ON_FAILURE)

'Enable following when run test case only'

String A_Number = 'A60204'
//String A_Number = 'A49000'

String ReportStatus = 'Cancelled'

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserReporting', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/DCO/Report/td_Cancel Request'))

WebUI.setText(findTestObject('LIMS/DCO/Report/input_searchtext'), A_Number)

WebUI.click(findTestObject('LIMS/DCO/Report/button_OK'))

runWorkflow = 'LIMS/DCO/Report/div_Run Workflow'

CustomKeywords.'com.gh.lims.Common.setClick'(runWorkflow)

WebUI.click(findTestObject('LIMS/DCO/Report/div_Generate Cancelled_Report'))

WebUI.click(findTestObject('LIMS/DCO/Report/button_OK_report'))

WebUI.click(findTestObject('LIMS/DCO/Report/Page_CNV/div_Release Report'))

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_rel_rep'), 120)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_rel_rep'))

WebUI.waitForElementPresent(findTestObject('LIMS/logout/img'), 10)

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()

CustomKeywords.'com.gh.core.PDFCompare.compareAndSave'(A_Number, ReportStatus)

return A_Number