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


String A_Number = 'A60204'
String ReportStatus = 'Cancelled'

CustomKeywords.'com.gh.lims.Common.logon'('Cliacls', '5xx1bkCcAlw=')

CustomKeywords.'com.gh.lims.Requests.searchRequest'(A_Number)

WebUI.click(findTestObject('LIMS/DCO/Request/td_Save'))

CustomKeywords.'com.gh.lims.Requests.cancelReport'(A_Number)

WebUI.closeBrowser()

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserReporting', '5xx1bkCcAlw=')

WebUI.click(findTestObject('LIMS/DCO/Reporting/td_Cancel Request'))

WebUI.setText(findTestObject('LIMS/DCO/Reporting/input_searchtext'), A_Number)

WebUI.click(findTestObject('LIMS/DCO/Reporting/button_OK'))

Thread.sleep(1000)

WebUI.click(findTestObject('LIMS/DCO/Reporting/div_Run Workflow'))

Thread.sleep(2000)

WebUI.click(findTestObject('LIMS/DCO/Reporting/div_Generate Cancelled_Report'))

WebUI.click(findTestObject('LIMS/DCO/Reporting/button_OK_report'))

WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_CNV/div_Release Report'))

Thread.sleep(3000)

WebUI.click(findTestObject('LIMS/DCO/Reporting/button_OK_2'))

Thread.sleep(1000)

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()

String filename = ((A_Number + '_') + ReportStatus) + '_report.pdf'

String file1 = CustomKeywords.'com.gh.core.Properties.getGetPDFBaseDir'() + filename

String file2 = CustomKeywords.'com.gh.core.Properties.getGetPDFDownloadDir'() + filename

if (CustomKeywords.'com.gh.core.PDFCompare.compareAndSave'(file1, file2)) {
    println('PDF Match!')
} else {
    println('Unmatched pdf found!')
}





