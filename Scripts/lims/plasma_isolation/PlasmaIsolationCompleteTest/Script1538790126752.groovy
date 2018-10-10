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

WebUI.comment('Run: ENTSW-TC-2878 , ENTSW-TC-2879')

//String sampleID = WebUI.callTestCase(findTestCase('lims/plasma_isolation/CreateBatchedPlasmaTest'), [:], FailureHandling.STOP_ON_FAILURE)

'Enable when run this test alone'	
String sampleID = 'A011245901'
CustomKeywords.'com.gh.db.ResetSampleStatus.reset'(sampleID, 'Batched For Plasma Isolation')


String strCheck
String strHeaderCheck

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserDagmar', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/Plasma_Isolation/Batched_PlasmaTramStop'))

WebUI.setText(findTestObject('LIMS/Plasma_Isolation/Page_Batched Plasma Tube List/Search_TextBox'), sampleID)

WebUI.waitForElementClickable(findTestObject('LIMS/Plasma_Isolation/Page_Batched Plasma Tube List/Search_OK_Button'), 
    2)

WebUI.click(findTestObject('LIMS/Plasma_Isolation/Page_Batched Plasma Tube List/Search_OK_Button'))

WebUI.switchToFrame(findTestObject('Object Repository/LIMS/Plasma_Isolation/Page_Batched Plasma Tube List/list_iframe'), 2, FailureHandling.CONTINUE_ON_FAILURE)

Thread.sleep(1000)

WebUI.click(findTestObject('LIMS/Plasma_Isolation/Page_Batched Plasma Tube List/first batched sample checkbox'))

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/Plasma_Isolation/Page_Batched Plasma Tube List/Tubes Verified Button'))

WebUI.switchToFrame(findTestObject('LIMS/Plasma_Isolation/Page_Plasma Tube List/list_iframe'), 2)

WebUI.waitForElementPresent(findTestObject('LIMS/Plasma_Isolation/Page_Batched Plasma Tube List/operationSuccessful Text'), 
    5)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/Plasma_Isolation/Page_Batched Plasma Tube List/Plasma_Isolation Complete Button'))

WebUI.waitForElementPresent(findTestObject('LIMS/Plasma_Isolation/Page_Batched Plasma Tube List/PlasmaIsolationCompletePopup/button_OK'),  2)

WebUI.click(findTestObject('LIMS/Plasma_Isolation/Page_Batched Plasma Tube List/PlasmaIsolationCompletePopup/button_OK'))

//Need a way to ask Katalon to download the file, skip the log out from now. 

//WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/logout/img'), 10)
//WebUI.click(findTestObject('Object Repository/LIMS/logout/img'))

WebUI.closeBrowser()

return sampleID