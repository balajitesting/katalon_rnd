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

import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.comment('Run: ENTSW-TC-3077')

String aNumber = 'A0100125'

CustomKeywords.'com.gh.lims.Common.logon'('ResOpsRhea', '5Ed5CIkj9UQfaMZXAkDVaQ==')

//Validation 1: Verify change in Resops -> All Requests page results in list of reasons presented.

WebUI.click(findTestObject('LIMS/ResOps Requests/AllRequests TramStop'))

WebUI.setText(findTestObject('LIMS/PostSequence/TBReview/Search/input_Search_searchtext'), aNumber)

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/Search/td_OK'))

WebUI.delay(1)

WebUI.click(findTestObject('LIMS/Problem Resolution/Page_Problem Cases Resolution/div_Edit'))

WebUI.switchToFrame(findTestObject('LIMS/Requests/DV2/Page_DV2/maint_iframe'), 10)

WebUI.click(findTestObject('LIMS/Requests/AllRequests/expediteCheckbox'))

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/img'))

WebUI.switchToFrame(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Frame'), 10)

WebUI.waitForElementVisible(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Password'), 10)

WebUI.setText(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Password'), 'abcd1234')

WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Dropdown_Btn'))

WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Select_Reason'))

WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_OK'))

WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/img'))

WebUI.delay(2); 

WebUI.click(findTestObject('Object Repository/LIMS/ResOps Requests/DV/Return To List Button'))

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/logout/img_Logout'))

WebUI.closeBrowser()