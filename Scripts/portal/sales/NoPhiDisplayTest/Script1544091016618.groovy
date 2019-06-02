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

String patientName

WebUI.comment('ENTSW-TC-3459')

'Login to portal no PHI display on Dashboard'
CustomKeywords.'com.gh.portal.Common.logon'('jelders@guardanthealth.com ', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Portal/page_salesportal/acceptalert'))

WebUI.waitForPageLoad(10)

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/physiciansearchbar'), 'bridgesb@slhs.org')

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/physicianselect'))

WebUI.verifyElementPresent(findTestObject('Portal/page_salesportal/dashboard'), 5)

patientName = WebUI.getText(findTestObject('Portal/page_salesportal/patientname'))

if (patientName.contains('.')) {
	println('No PHI Information is present in dashboard' + patientName)
}

WebUI.waitForPageLoad(10)

CustomKeywords.'com.gh.portal.Common.portalLogout'()