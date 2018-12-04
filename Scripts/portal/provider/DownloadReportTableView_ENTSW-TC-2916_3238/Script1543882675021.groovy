import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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

WebUI.comment('Run: ENTSW-TC-2916, ENTSW-TC-3282')

file  = 'Results/download/Guardant360-A90029-v12-Addendum-Additional-Info.pdf'

CustomKeywords.'com.gh.core.TestUtil.purgeFile'(file)

CustomKeywords.'com.gh.portal.Common.logon'('kimberly.schlesinger@rivhs.com', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.click(findTestObject('Portal/tableview/a_VIEW ALL REPORTS IN TABLE'))

WebUI.click(findTestObject('Portal/tableview/div_Practice_fa fa-download re'))

WebUI.click(findTestObject('Portal/tableview/a_Report Only'))

WebUI.click(findTestObject('Portal/tableview/div_Tappahannock Cancer Instit'))

WebUI.click(findTestObject('Portal/tableview/a_Report Only_1'))

WebUI.click(findTestObject('Portal/tableview/div_concat(Alabama Oncology-St'))

WebUI.click(findTestObject('Portal/tableview/a_Report  Additional Informati'))

CustomKeywords.'com.gh.portal.Common.logout'()

WebUI.closeBrowser()

Assert.assertTrue(new File(file).exists())