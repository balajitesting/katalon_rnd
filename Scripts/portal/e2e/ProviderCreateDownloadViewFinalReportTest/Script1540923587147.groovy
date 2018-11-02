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


WebUI.comment('Run: ENTSW-TC-2911 Final Report Only')

def A_Number = WebUI.callTestCase(findTestCase('lims/report/CreateFinalReportTest'), [:], FailureHandling.STOP_ON_FAILURE)

//def A_Number = 'A0112848'
String ReportStatus = 'FINAL'

WebUI.delay(120)

CustomKeywords.'com.gh.portal.Common.logon'('kimberly.schlesinger@rivhs.com', 'Pa22word')

WebUI.click(findTestObject('Portal/Dashboard/provider/Page_Guardant Health/a_Show reports_fa fa-download'))

WebUI.click(findTestObject('Portal/Dashboard/provider/Page_Guardant Health/a_Report Only'))

/**

WebUI.click(findTestObject('Portal/Dashboard/provider/Page_Guardant Health/div_0'))

WebUI.click(findTestObject('Portal/Dashboard/provider/Page_Guardant Health/div_2'))

WebUI.click(findTestObject('Portal/Dashboard/provider/Page_Guardant Health/a_VIEW ALL REPORTS IN TABLE'))

WebUI.click(findTestObject('Portal/Dashboard/provider/Page_Guardant Health/div_OCT-29-2018 Reported'))
*/

WebUI.click(findTestObject('Object Repository/Portal/Dashboard/logout/Page_Guardant Health/i_PERMISSIONS_fa fa-chevron-do'))

WebUI.click(findTestObject('Object Repository/Portal/Dashboard/logout/Page_Guardant Health/a_Sign Out'))

WebUI.closeBrowser()

def url = '/api/v1.0/guardanthealth/clinical/Report/' + A_Number
Map response = CustomKeywords.'com.gh.core.HttpClient.doGet'(url)

def revision = response.get("revision")

Assert.assertTrue(CustomKeywords.'com.gh.core.PDFCompare.isDownloaded'(A_Number, revision, false))



