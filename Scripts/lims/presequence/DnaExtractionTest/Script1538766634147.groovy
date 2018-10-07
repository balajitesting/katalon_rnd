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


WebUI.comment('ENTSW-TC-2881')

//String aNumber = WebUI.callTestCase(findTestCase('lims/accession/BatchedPlasmaTest'), [:], FailureHandling.STOP_ON_FAILURE)

'Enable when run this test alone'
String aNumber = 'A010001401'

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserDagmar', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('Object Repository/LIMS/dnaExtraction/Page_Iteration/td_Failed Fax List_sitemap_Tra'))

WebUI.setText(findTestObject('Object Repository/LIMS/dnaExtraction/Page_Ready For DNA Extraction/input_Search_searchtext'), 
    aNumber)

WebUI.click(findTestObject('Object Repository/LIMS/dnaExtraction/Page_Ready For DNA Extraction/td_OK'))

WebUI.switchToFrame(findTestObject('LIMS/dnaExtraction/Page_Ready For DNA Extraction/iframe'), 2)

WebUI.click(findTestObject('Object Repository/LIMS/dnaExtraction/Page_Ready For DNA Extraction/input_Sample StatusReady for D'))

WebUI.switchToDefaultContent()

WebUI.verifyElementClickable(findTestObject('Object Repository/LIMS/dnaExtraction/Page_Ready For DNA Extraction/div_Generate Accession_ID_CSV'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/LIMS/dnaExtraction/Page_Ready For DNA Extraction/div_Generate Accession_ID_CSV'))

WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/logout/img'), 10)

WebUI.click(findTestObject('Object Repository/LIMS/logout/img'))

WebUI.closeBrowser()

return aNumber