import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

CustomKeywords.'com.gh.portal.Common.logon'('sqa_viewas@gmail.com', 'Pa22word')

WebUI.setText(findTestObject('Portal/Dashboard/input_view-as__search-bar'), 'Fidler')

WebUI.click(findTestObject('Portal/Dashboard/span_Fidler Mary'))

WebUI.click(findTestObject('Portal/Dashboard/a_fa fa-download request__data'))

WebUI.click(findTestObject('Portal/Dashboard/a_Report Only'))

WebUI.switchToWindowUrl(GlobalVariable.portalUrl + 'dashboard')

WebUI.click(findTestObject('Portal/Dashboard/Page_Guardant Health/i_fa fa-chevron-down admin-men'))

//WebUI.click(findTestObject('Portal/Dashboard/Page_Guardant Health/a_Sign Out'))

WebUI.closeBrowser()

