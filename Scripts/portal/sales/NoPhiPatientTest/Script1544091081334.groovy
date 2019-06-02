import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.junit.After as After
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

String mrnNumber

String patientbirth

String gender

String patientname

String patientNameDashboard

WebUI.comment('ENTSW-TC-3460')

'Login to portal no PHI display on patient page'
CustomKeywords.'com.gh.portal.Common.logon'('jelders@guardanthealth.com ', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Portal/page_salesportal/acceptalert'))

WebUI.waitForPageLoad(10)

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/physiciansearchbar'), 'bridgesb@slhs.org')

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/physicianselect'))

WebUI.waitForPageLoad(10)

patientNameDashboard = WebUI.getText(findTestObject('Portal/page_salesportal/patientname'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/selectpatient'))

patientname = WebUI.getText(findTestObject('Object Repository/Portal/page_portalaccession/tooglepatientname'))

WebUI.verifyMatch(patientname, patientNameDashboard, true, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/tooglepatientname'), 10)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/tooglepatientname'))

mrnNumber = WebUI.getText(findTestObject('Object Repository/Portal/page_salesportal/mrnnumber'))

patientbirth = WebUI.getText(findTestObject('Object Repository/Portal/page_salesportal/patientbirth'))

gender = WebUI.getText(findTestObject('Object Repository/Portal/page_salesportal/patientgender'))

WebUI.verifyMatch(mrnNumber, '####', true, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(patientbirth, 'MMM-DD-YYYY', true, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(gender, '###', true, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(10)

CustomKeywords.'com.gh.portal.Common.portalLogout'()