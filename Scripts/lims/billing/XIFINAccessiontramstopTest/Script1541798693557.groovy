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

WebUI.comment('Run: ENTSW-TC-2890')

String A_Number = 'A0100253'

CustomKeywords.'com.gh.db.LimsDBDataReset.resetXIFINAccession'(A_Number)

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserBilling', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/Home/XIFINAccessionsTramStop'))

WebUI.switchToFrame(findTestObject('LIMS/Requests/AllRequests/list_iFrame'), 3)

assert WebUI.getText(findTestObject('LIMS/DataEntryBilling/XIFINAccession/requestNumber')).contains(A_Number ) == false

WebUI.closeBrowser()

WebUI.callTestCase(findTestCase('lims/report/fax_portal/PortalCorrectedReportForPrimaryPhysicianTest'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserBilling', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/Home/XIFINAccessionsTramStop'))

WebUI.switchToFrame(findTestObject('LIMS/Requests/AllRequests/list_iFrame'), 3)

assert WebUI.getText(findTestObject('LIMS/DataEntryBilling/XIFINAccession/requestNumber')).contains(A_Number ) == true

WebUI.click(findTestObject('LIMS/DataEntryBilling/XIFINAccession/requestCheckbox'))

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/DataEntryBilling/XIFINAccession/sendAccession'))

WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/logout/img'), 15)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/logout/img_Logout'))

WebUI.closeBrowser()