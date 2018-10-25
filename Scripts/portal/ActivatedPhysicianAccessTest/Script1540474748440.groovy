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


String aNumber
CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserDagmar', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('Object Repository/Portal/page_limsaccession/allrequestbutton'))

WebUI.waitForPageLoad(5)

WebUI.setText(findTestObject('Object Repository/Portal/page_limsaccession/physicianlastname'),'feng')

WebUI.setText(findTestObject('Object Repository/Portal/page_limsaccession/practicename'), 'UH Seidman - Thoracic Oncology')

WebUI.click(findTestObject('Object Repository/Portal/page_limsaccession/okbutton'))

WebUI.switchToFrame(findTestObject('Object Repository/Portal/page_limsaccession/iframe'), 20)

String pCount=WebUI.getText(findTestObject('Object Repository/Portal/page_limsaccession/patientcount'))

println pCount

aNumber = WebUI.getText(findTestObject('Object Repository/Portal/page_limsaccession/requestid'))

println aNumber

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/Portal/page_limsaccession/logoff'))

CustomKeywords.'com.gh.portal.Common.logon'('yan.feng@uhhospitals.org', 'Pa22word')

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/viewtablereport'))

WebUI.back()

WebUI.waitForElementClickable(findTestObject('Portal/page_inprogressreport/profilemenu'),20)

WebUI.click(findTestObject('Portal/page_inprogressreport/profilemenu'))

WebUI.click(findTestObject('Portal/page_inprogressreport/signout'))

WebUI.closeBrowser()
















WebUI.closeBrowser()