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

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.testng.Assert as Assert
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

String accountName

String headerPhysicianName

String headerPracticeName

WebUI.comment('ENTSW-TC‌-3522')

'Display Practice name next to Physician- In new Tab'
CustomKeywords.'com.gh.portal.Common.logon'('gracesitemgr@gmail.com', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/selectpatient'), 10)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/selectpatient'))

WebUI.waitForPageLoad(20)

WebUI.waitForElementPresent(findTestObject('Object Repository/Portal/page_portalaccession/tooglepatientname'), 10)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/tooglepatientname'))

accountName = WebUI.getText(findTestObject('Object Repository/Portal/page_displaypracticename/accountname'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/dashboardclick'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Portal/page_displaypracticename/headersphysicianname'), 15)

headerPhysicianName = WebUI.getText(findTestObject('Object Repository/Portal/page_displaypracticename/headersphysicianname'))

headerPracticeName = headerPhysicianName.substring(headerPhysicianName.indexOf('(') + 1, headerPhysicianName.lastIndexOf(
		')'))

Assert.assertEquals(accountName, headerPracticeName)

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('Portal/page_inprogressreport/profilemenu'), 10)

WebUI.click(findTestObject('Portal/page_inprogressreport/profilemenu'))

WebUI.click(findTestObject('Portal/page_inprogressreport/signout'))

WebUI.closeBrowser()