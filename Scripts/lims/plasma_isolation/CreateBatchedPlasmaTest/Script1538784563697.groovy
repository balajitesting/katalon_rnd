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

//Create Batch Plasma
WebUI.comment('Run: ENTSW-TC-2877')

//String aNumber = WebUI.callTestCase(findTestCase('lims/accession/VerifyDV2Test'), [:], FailureHandling.STOP_ON_FAILURE)

'Enable when run this test alone'
String sampleID = 'A011245901'

CustomKeywords.'com.gh.db.ResetSampleStatus.reset'(sampleID, 'Ready for Plasma Isolation')

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserDagmar', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('Object Repository/LIMS/plasmaIsolation/Page_Iteration/td_sitemap_TramStopSelCell'))

WebUI.setText(findTestObject('Object Repository/LIMS/plasmaIsolation/Page_Plasma Tube List/input_searchtext'), sampleID)

WebUI.click(findTestObject('Object Repository/LIMS/plasmaIsolation/Page_Plasma Tube List/td_OK'))

WebUI.switchToFrame(findTestObject('Object Repository/LIMS/plasmaIsolation/Page_Plasma Tube List/iframe'), 2, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/LIMS/plasmaIsolation/Page_Plasma Tube List/input_group1'))

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/LIMS/plasmaIsolation/Page_Plasma Tube List/div_Create PlasmaBatch'))

WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/logout/img'), 10)

WebUI.click(findTestObject('Object Repository/LIMS/logout/img'))

WebUI.closeBrowser()

return sampleID