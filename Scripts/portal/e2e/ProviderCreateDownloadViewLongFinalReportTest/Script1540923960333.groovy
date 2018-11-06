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
import groovy.json.JsonSlurper

WebUI.comment('Run: ENTSW-TC-2911 Final-Additional Information')

def A_Number = WebUI.callTestCase(findTestCase('lims/report/CreateFinalReportTest'), [:], FailureHandling.STOP_ON_FAILURE)

String ReportStatus = 'FINAL'

WebUI.delay(150)

CustomKeywords.'com.gh.portal.Common.logon'('kimberly.schlesinger@rivhs.com', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.click(findTestObject('Portal/page_guardanthealth/a_Show reports_fa fa-download'))

WebUI.click(findTestObject('Portal/Dashboard/a_Report  Additional Informati'))

CustomKeywords.'com.gh.portal.Common.logout'()

CustomKeywords.'com.gh.core.PDFCompare.compareAndSave'(A_Number, ReportStatus)

WebUI.closeBrowser()

def url = '/api/v1.0/guardanthealth/clinical/Report/' + A_Number
Map response = CustomKeywords.'com.gh.core.HttpClient.doGet'(url)

def revision = response.get("revision")
def isLong = true

CustomKeywords.'com.gh.core.PDFCompare.compareAndSave'(A_Number, ReportStatus, revision, isLong)
