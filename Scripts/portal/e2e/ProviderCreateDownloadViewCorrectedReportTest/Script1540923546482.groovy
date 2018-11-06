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
import org.testng.Assert

def A_Number = WebUI.callTestCase(findTestCase('lims/report/CreateCorrectedReportTest'), [:], FailureHandling.STOP_ON_FAILURE)

//A_Number = 'A86684' 
ReportStatus = 'CORRECTED'
WebUI.delay(120)

CustomKeywords.'com.gh.portal.Common.logon'('chaftj@mskcc.org', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/Corrected/Page_Guardant Health/div_LOAD MORE'))

WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/Corrected/Page_Guardant Health/a_Report Only_request__data re'))

WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/Corrected/Page_Guardant Health/a_Report  Additional Informati'))

CustomKeywords.'com.gh.portal.Common.logout'()

WebUI.closeBrowser()

def url = '/api/v1.0/guardanthealth/clinical/Report/' + A_Number
Map response = CustomKeywords.'com.gh.core.HttpClient.doGet'(url)

def revision = response.get("revision")

Assert.assertTrue(CustomKeywords.'com.gh.core.PDFCompare.isDownloaded'(A_Number, ReportStatus, revision, true))

return A_Number