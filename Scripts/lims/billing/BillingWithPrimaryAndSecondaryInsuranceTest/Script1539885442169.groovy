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

WebUI.comment('Run: ENTSW-TC-2864')

//String aNumber = WebUI.callTestCase(findTestCase('lims/accession/DE2NoPlasmaHoldTest'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.gh.lims.Common.logon'('abaca', '5Ed5CIkj9UQfaMZXAkDVaQ==')

//Resetting the Billing Status
String requestID = 'A0131242'

CustomKeywords.'com.gh.db.LimsDBDataReset.resetBilling'(requestID)

//Search for the RequestId in the Billing Screen

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/Search/td_dataentrybilling_billing'))

WebUI.setText(findTestObject('LIMS/DataEntryBilling/Billing/Search/input_Search_searchtext'), requestID)

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/Search/td_OK'))

Thread.sleep(3000) //Wait command is not working properly. Hence, implemented the same.

//Billing Screen

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/Search/td_Edit'))

WebUI.setText(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_icdcode01'), '123543')

WebUI.setText(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_icdcode02'), '34562')

WebUI.setText(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_icdcode03'), '1236543')

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_billingverified'))

WebUI.selectOptionByValue(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/promotion_code'),
	'001', true)

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_abnstatus'))

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_releventnsclc'))

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_patientmedstatus'))

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_patientbenefitsauthoriza'))

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_button'))

WebUI.switchToWindowIndex(1)

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/primary_payor'))

WebUI.switchToDefaultContent()

WebUI.setText(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_subscriberid_p'), '23145')

WebUI.selectOptionByValue(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/sec_relation_to_patient'),
	'Self', true)

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/secondary_payor'))

WebUI.switchToWindowIndex(1)

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/payor2'))

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_save'))

//Search Screen to verify the Result

WebUI.setText(findTestObject('LIMS/DataEntryBilling/Billing/Search/input_Search_searchtext'), requestID)

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/Search/td_OK'))

WebUI.switchToFrame(findTestObject('LIMS/Requests/AllRequests/list_iFrame'), 3)

assert WebUI.getText(findTestObject('LIMS/DataEntryBilling/Billing/Search/searchResult')).contains("No rows found.") == true

WebUI.closeBrowser()
