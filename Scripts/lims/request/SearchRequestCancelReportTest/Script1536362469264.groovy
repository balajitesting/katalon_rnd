import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After

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

String A_Number = 'A60204'

CustomKeywords.'com.gh.lims.Common.logon'('Cliacls', '5Ed5CIkj9UQfaMZXAkDVaQ==')

CustomKeywords.'com.gh.lims.Requests.searchRequest'(A_Number)

orEdit = 'LIMS/DCO/Request/div_Edit'
//CustomKeywords.'com.gh.lims.Common.clickEdit'(orEdit)

CustomKeywords.'com.gh.lims.Common.setClick'(orEdit)

WebUI.click(findTestObject('LIMS/DCO/Request/td_Save'))

WebUI.setEncryptedText(findTestObject('LIMS/DCO/Request/eSign/input_Password_checkpassword'), '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/DCO/Request/eSign/img'))

WebUI.click(findTestObject('LIMS/DCO/Request/eSign/td_Added comment'))

WebUI.click(findTestObject('LIMS/DCO/Request/eSign/td_OK'))

CustomKeywords.'com.gh.core.JSHandler.J2Click'(findTestObject('LIMS/DCO/Request/Page_All_Requests/img'), 20)

WebUI.acceptAlert()

Thread.sleep(1000)

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()
