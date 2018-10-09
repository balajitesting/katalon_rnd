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

WebUI.comment('Run: ENTSW-TC-2863')

//String aNumber = WebUI.callTestCase(findTestCase('lims/request/DataVerificationTest'), [:], FailureHandling.STOP_ON_FAILURE)

String aNumber = WebUI.callTestCase(findTestCase('lims/accession/DE2UpdateProblemCaseTest'), [:], FailureHandling.STOP_ON_FAILURE)
'Enable when run this test alone'
//String aNumber = 'A0120020'

CustomKeywords.'com.gh.lims.Common.logon'('abaca', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('Object Repository/LIMS/Billing/Page_Iteration/td_Billing'))

WebUI.setText(findTestObject('Object Repository/LIMS/Billing/Page_Billing List/input_searchtext'), aNumber)

WebUI.click(findTestObject('Object Repository/LIMS/Billing/Page_Billing List/td_OK'))

edit = 'LIMS/Problem Resolution/Page_Problem Cases Resolution/div_Edit'

CustomKeywords.'com.gh.lims.Common.setClick'(edit)

WebUI.setText(findTestObject('Object Repository/LIMS/Billing/Page_Iteration/input_icdcode01'), '123543')

WebUI.setText(findTestObject('Object Repository/LIMS/Billing/Page_Iteration/input_icdcode02'), '34562')

WebUI.setText(findTestObject('Object Repository/LIMS/Billing/Page_Iteration/input_icdcode03'), '1236543')

WebUI.click(findTestObject('Object Repository/LIMS/Billing/Page_Iteration/input_billingverified'))

WebUI.selectOptionByValue(findTestObject('Object Repository/LIMS/Billing/Page_Iteration/select_001  002  003  004  005'),
	'001', true)

WebUI.click(findTestObject('Object Repository/LIMS/Billing/Page_Iteration/input_abnstatus'))

WebUI.click(findTestObject('Object Repository/LIMS/Billing/Page_Iteration/input_releventnsclc'))

WebUI.click(findTestObject('Object Repository/LIMS/Billing/Page_Iteration/input_patientmedstatus'))

WebUI.click(findTestObject('Object Repository/LIMS/Billing/Page_Iteration/input_patientbenefitsauthoriza'))

WebUI.click(findTestObject('Object Repository/LIMS/Billing/Page_Iteration/input_button'))

WebUI.switchToWindowIndex(1)

WebUI.click(findTestObject('Object Repository/LIMS/Billing/Page_Iteration/primary_payor'))

WebUI.switchToDefaultContent()

WebUI.setText(findTestObject('Object Repository/LIMS/Billing/Page_Iteration/input_subscriberid_p'), '23145')

WebUI.click(findTestObject('Object Repository/LIMS/Billing/Page_Iteration/input_saveAccession02'))

WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/logout/img'), 15)

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()

return aNumber

