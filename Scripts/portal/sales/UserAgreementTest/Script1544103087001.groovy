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

WebUI.comment('ENTSW-TC-3461')

'Login to portal as a sales user and accept agreement'
CustomKeywords.'com.gh.portal.Common.logon'('jelders@guardanthealth.com ', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Portal/page_salesportal/acceptalert'))

WebUI.waitForPageLoad(10)

WebUI.verifyElementPresent(findTestObject('Portal/page_salesportal/dashboard'), 5)

CustomKeywords.'com.gh.portal.Common.portalLogout'()

