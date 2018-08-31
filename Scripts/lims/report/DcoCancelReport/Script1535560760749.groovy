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

WebUI.callTestCase(findTestCase('DCO/DCOAllRequest'), [('A_Number') : A_Number, ('ReportStatus') : ReportStatus, ('RunTest') : RunTest],
	FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'lims.service.Logon.logon'('CLIAUserReporting', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/DCO/Reporting/td_Cancel Request'))

WebUI.setText(findTestObject('LIMS/DCO/Reporting/input_searchtext'), A_Number)

WebUI.click(findTestObject('LIMS/DCO/Reporting/button_OK'))

Thread.sleep(1000)

WebUI.click(findTestObject('LIMS/DCO/Reporting/div_Run Workflow'))

Thread.sleep(2000)

WebUI.click(findTestObject('LIMS/DCO/Reporting/div_Generate Cancelled_Report'))

WebUI.click(findTestObject('LIMS/DCO/Reporting/button_OK_report'))

WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_CNV/div_Release Report'))

Thread.sleep(1000)

WebUI.click(findTestObject('LIMS/DCO/Reporting/button_OK_2'))

String filename = ((A_Number + '_') + ReportStatus) + '_report.pdf'

String file1 = CustomKeywords.'gh.core.Properties.getGetPDFBaseDir'() + filename

String file2 = CustomKeywords.'gh.core.Properties.getGetPDFDownloadDir'() + filename

if (CustomKeywords.'gh.core.PDFCompare.compareAndSave'(file1, file2)) {
	println('PDF Match!')
} else {
	println('Unmatched pdf found!')
}

WebUI.closeBrowser()
