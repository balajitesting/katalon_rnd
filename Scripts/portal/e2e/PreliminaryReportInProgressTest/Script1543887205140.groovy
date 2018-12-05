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

WebUI.comment('ENTSW-TC-2913')

'Enable when run this test alone'
String A_Number = 'A0131290'

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserReporting', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Iteration/td_All Requests'))

WebUI.setText(findTestObject('LIMS/DCO/Report/Page_Request List/input_searchtext'), A_Number)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Request List/td_OK'))

WebUI.delay(2)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Request List/td_Edit'))

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_All Requests/select_TB Review BIP DataLD Re'), 60)

WebUI.selectOptionByValue(findTestObject('LIMS/DCO/Report/Page_All Requests/select_TB Review BIP DataLD Re'), 'LD Review BIP Data',
	true)

String PhysicianEmail = WebUI.getAttribute(findTestObject('LIMS/DCO/Report/Page_All Requests/physicianemail'), 'value')

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_All Requests/td_Save'), 60)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_All Requests/td_Save'))

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_All Requests/a_LD Review'), 60)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_All Requests/a_LD Review'))

WebUI.delay(2)

WebUI.setText(findTestObject('LIMS/DCO/Report/Page_Request List for LD Review/input_searchtext'), A_Number)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Request List for LD Review/td_OK'))

def workflow = 'LIMS/DCO/Report/Page_Request List for CLS Review/td_Begin Workflow'

CustomKeywords.'com.gh.lims.Common.setClick'(workflow)

WebUI.waitForElementPresent(findTestObject('LIMS/DCO/Report/Page_CNV/div_SNV Review'), 10)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_CNV/div_SNV Review'))

WebUI.click(findTestObject('LIMS/DCO/Report/Page_SNV/td_Fusion Review'))

if (WebUI.verifyElementPresent(findTestObject('Object Repository/LIMS/DCO/Report/Page_INDEL/indelreview'), 20, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/LIMS/DCO/Report/Page_INDEL/indelreview'))
}

WebUI.click(findTestObject('LIMS/DCO/Report/Page_INDEL/div_MSI Review'))

if (WebUI.verifyElementPresent(findTestObject('Object Repository/LIMS/DCO/Report/page_final/div_finalreview'), 20, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/LIMS/DCO/Report/page_final/div_finalreview'))
}

WebUI.delay(2)

WebUI.selectOptionByValue(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/select_FINALAMENDEDCORRECTEDAD'), 'AMENDED',
	true)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/td_Generate Report'))

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_gen_rep'), 120)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_gen_rep'))

WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/logout/img'), 10)

WebUI.delay(3)

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()

'Login to portal to search for A_Number'
CustomKeywords.'com.gh.portal.Common.logon'('tvo@guardanthealth.com', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(5)

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/physiciansearchbar'),PhysicianEmail)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/physicianselect'))

WebUI.waitForPageLoad(5)

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/searchid'),A_Number)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/selectsearch'))

Thread.sleep(3000)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/tooglepatientname'))

assert WebUI.getText(findTestObject('Portal/page_inprogressreport/test/verifyStatus')).equalsIgnoreCase('In Progress') == true

WebUI.delay(3)

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

WebUI.closeBrowser()