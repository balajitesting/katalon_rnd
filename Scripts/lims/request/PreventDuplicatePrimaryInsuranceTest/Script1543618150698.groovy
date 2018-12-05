import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.junit.After as After
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

import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.comment('ENTSW-TC-2948')

String requestID = 'A0131697'

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserDagmar', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/Problem Resolution/Page_Iteration/td_sitemap_TramStopSelCell'))

WebUI.setText(findTestObject('Object Repository/LIMS/Problem Resolution/Page_Problem Cases Resolution/input_searchtext'), requestID)

WebUI.click(findTestObject('LIMS/Problem Resolution/Page_Problem Cases Resolution/td_OK'))

CustomKeywords.'com.gh.lims.Common.setClick'('LIMS/Problem Resolution/Page_Problem Cases Resolution/div_Edit')

WebUI.switchToFrame(findTestObject('LIMS/Requests/DV2/Page_DV2/maint_iframe'), 10)

WebUI.click(findTestObject('LIMS/Requests/Problemcases Resolution/tab_InsDetails'))

WebUI.click(findTestObject('LIMS/Requests/Problemcases Resolution/btn_Ins_Add'))

WebUI.selectOptionByValue(findTestObject('LIMS/Requests/Problemcases Resolution/drpdwn_InsType0'), 'Primary', true)

WebUI.selectOptionByValue(findTestObject('LIMS/Requests/Problemcases Resolution/drpdwn_Relationship0'),'Self', true)

WebUI.selectOptionByValue(findTestObject('LIMS/Requests/Problemcases Resolution/drpdwn_gender0'), 'Male', true)

WebUI.click(findTestObject('LIMS/Requests/Problemcases Resolution/btn_Ins_Add'))

WebUI.selectOptionByValue(findTestObject('LIMS/Requests/Problemcases Resolution/drpdwn_InsType1'), 'Primary', true)

WebUI.selectOptionByValue(findTestObject('LIMS/Requests/Problemcases Resolution/drpdwn_Relationship0'), 'Self', true)

WebUI.selectOptionByValue(findTestObject('LIMS/Requests/Problemcases Resolution/drpdwn_gender0'), 'Male', true)

CustomKeywords.'com.gh.lims.ResOpsRequests.enterESign'('eSign_Frame2', 'abcd1234', 'Added comment')

assert WebUI.getText(findTestObject('LIMS/Requests/Problemcases Resolution/msg_Error')).contains('ERROR !! Cannot Save') == true

WebUI.click(findTestObject('LIMS/Requests/Problemcases Resolution/btn_Close'))

WebUI.switchToDefaultContent()

CustomKeywords.'com.gh.lims.Common.waitAndClick'('LIMS/Problem Resolution/returnToList/div_Return To List')

WebUI.waitForElementPresent(findTestObject('LIMS/logout/img'), 15)

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()

return requestID