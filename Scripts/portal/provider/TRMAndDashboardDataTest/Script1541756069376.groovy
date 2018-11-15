import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After

import org.testng.Assert

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

WebUI.comment('ENTSW-TC‌-3350')

String patientNameDashboard
String releasedDateDashboard
String cancerTypeDashboard
String patientNameTRM
String cancerTypeTRM
String releasedDateTRM

CustomKeywords.'com.gh.portal.Common.logon'('bridgesb@slhs.org', 'R9dwWsVuqf0RB1p2unfSZQ==')

patientNameDashboard = WebUI.getText(findTestObject('Portal/page_dataintegrity/patientnamedashboard')).toUpperCase()
releasedDateDashboard = WebUI.getText(findTestObject('Portal/page_dataintegrity/reportreleasedatedashboard'))
cancerTypeDashboard = WebUI.getText(findTestObject('Portal/page_dataintegrity/cancertypedashboard'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/selectpatient'))

WebUI.waitForPageLoad(15)

println patientNameDashboard

patientNameTRM = WebUI.getText(findTestObject('Object Repository/Portal/page_portalaccession/tooglepatientname'))

'Verifying patient name in dashboard and TRM'
Assert.assertEquals(patientNameDashboard, patientNameTRM)

WebUI.waitForElementVisible(findTestObject('Object Repository/Portal/page_portalaccession/tooglepatientname'),20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/tooglepatientname'))

cancerTypeTRM = WebUI.getText(findTestObject('Object Repository/Portal/page_dataintegrity/cancertypetrm'))

releasedDateTRM = WebUI.getText(findTestObject('Object Repository/Portal/page_dataintegrity/releasedatetrm'))

'Verifying cancer type in dashboard and TRM'
Assert.assertEquals(cancerTypeDashboard, cancerTypeTRM)

'Getting the first string for release date in dashboard'
Scanner firstString=new Scanner(releasedDateDashboard)
String releaseDateDashboard = firstString.next()

'Verifying release date in dashboard and TRM'
Assert.assertEquals(releaseDateDashboard, releasedDateTRM)

WebUI.verifyElementPresent(findTestObject('Portal/page_inprogressreport/profilemenu'), 10)
 
WebUI.click(findTestObject('Portal/page_inprogressreport/profilemenu'))
 
WebUI.click(findTestObject('Portal/page_inprogressreport/signout'))

WebUI.closeBrowser()

