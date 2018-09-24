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

String aNumber = WebUI.callTestCase(findTestCase('lims/accession/EnterDE2DataWithProblemCase'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserDagmar', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/Problem Resolution/Page_Iteration/td_sitemap_TramStopSelCell'))

WebUI.setText(findTestObject('Object Repository/LIMS/Problem Resolution/Page_Problem Cases Resolution/input_searchtext'), aNumber)

WebUI.click(findTestObject('LIMS/Problem Resolution/Page_Problem Cases Resolution/td_OK'))

edit = 'LIMS/Problem Resolution/Page_Problem Cases Resolution/div_Edit'

CustomKeywords.'com.gh.lims.Common.clickEdit'(edit)

WebUI.switchToFrame(findTestObject('Object Repository/LIMS/Problem Resolution/Page_Problem Cases Resolutionfor A0/iframe'), 10)

WebUI.selectOptionByValue(findTestObject('LIMS/Problem Resolution/Page_Problem Cases Resolutionfor A0/select_ActiveResolvedNA'), 
    'Resolved', true)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/Problem Resolution/Page_Problem Cases Resolutionfor A0/img'))

WebUI.switchToFrame(findTestObject('Object Repository/LIMS/Problem Resolution/Page_Problem Cases Resolutionfor A0/eSign_Frame'), 10)

WebUI.setText(findTestObject('Object Repository/LIMS/Problem Resolution/Page_Problem Cases Resolutionfor A0/eSign_Password'), 'abcd1234')

WebUI.click(findTestObject('Object Repository/LIMS/Problem Resolution/Page_Problem Cases Resolutionfor A0/eSign_Dropdown_Btn'))

WebUI.click(findTestObject('Object Repository/LIMS/Problem Resolution/Page_Problem Cases Resolutionfor A0/eSign_Select_Reason'))

WebUI.click(findTestObject('Object Repository/LIMS/Problem Resolution/Page_Problem Cases Resolutionfor A0/eSign_OK'))

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()

return aNumber