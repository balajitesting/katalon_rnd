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

WebUI.comment('Run: ENTSW-TC-2873')

String aNumber = WebUI.callTestCase(findTestCase('lims/request/ResolveProblemCaseTest'), [:], FailureHandling.STOP_ON_FAILURE)

'Enable when run this test alone'
//String aNumber = 'A0120296'

CustomKeywords.'com.gh.lims.Common.logon'('abaca', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('Object Repository/LIMS/DV1/Page_Iteration/td_Data Verification'))

WebUI.click(findTestObject('Object Repository/LIMS/DV1/Page_Data Verification Request List/a_GHDVSearch'))

WebUI.setText(findTestObject('Object Repository/LIMS/DV1/Page_Data Verification Request List/input_GHDVSearch_arg1'), aNumber)

WebUI.click(findTestObject('Object Repository/LIMS/DV1/Page_Iteration/search_btn_ok'))

edit = 'LIMS/Problem Resolution/Page_Problem Cases Resolution/div_Edit'

CustomKeywords.'com.gh.lims.Common.setClick'(edit)

WebUI.switchToFrame(findTestObject('Object Repository/LIMS/Problem Resolution/Page_Problem Cases Resolutionfor A0/iframe'),
	10)

WebUI.click(findTestObject('LIMS/DV1/Page_DV Check/input_pr0_u_dvcheck'))

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/LIMS/Problem Resolution/Page_Problem Cases Resolutionfor A0/img'))

WebUI.switchToFrame(findTestObject('Object Repository/LIMS/DV1/eSign/iFrame'), 10)

WebUI.setText(findTestObject('Object Repository/LIMS/DV1/eSign/password'), 'abcd1234')

WebUI.click(findTestObject('Object Repository/LIMS/DV1/eSign/dropdown_Btn'))

WebUI.click(findTestObject('Object Repository/LIMS/DV1/eSign/select_Reason'))

WebUI.click(findTestObject('Object Repository/LIMS/DV1/eSign/eSign_OK'))

WebUI.switchToDefaultContent()

Thread.sleep(1000)

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()

return aNumber
