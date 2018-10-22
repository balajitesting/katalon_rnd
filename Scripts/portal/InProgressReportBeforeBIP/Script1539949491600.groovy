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

//String aNumber = 'A0120946'
String aNumber = WebUI.callTestCase(findTestCase('lims/accession/DE2UpdateProblemCaseForPortalTest'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.gh.portal.Common.logon'('sqa_viewas@gmail.com', 'Pa22word')

WebUI.setText(findTestObject('Object Repository/Portal/inprogressreportelement/searchpatient'), 'Bridges')

WebUI.click(findTestObject('Object Repository/Portal/inprogressreportelement/selectpatient'))

WebUI.setText(findTestObject('Object Repository/Portal/inprogressreportelement/searchid'), aNumber)

WebUI.click(findTestObject('Object Repository/Portal/inprogressreportelement/selsearch'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Portal/inprogressreportelement/inprogressimg'), 10)

WebUI.click(findTestObject('Object Repository/Portal/inprogressreportelement/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/inprogressreportelement/signout'))

WebUI.closeBrowser()

aNumber =WebUI.callTestCase(findTestCase('lims/request/DataVerificationWithProblemCaseTest'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.gh.portal.Common.logon'('sqa_viewas@gmail.com', 'Pa22word')

WebUI.setText(findTestObject('Object Repository/Portal/inprogressreportelement/searchpatient'), 'Bridges')

WebUI.click(findTestObject('Object Repository/Portal/inprogressreportelement/selectpatient'))

WebUI.setText(findTestObject('Object Repository/Portal/inprogressreportelement/searchid'), aNumber)

WebUI.click(findTestObject('Object Repository/Portal/inprogressreportelement/selsearch'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Portal/inprogressreportelement/inprogressimg'), 10)

WebUI.click(findTestObject('Object Repository/Portal/inprogressreportelement/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/inprogressreportelement/signout'))

WebUI.closeBrowser()

WebUI.callTestCase(findTestCase('lims/request/DV2RequestsWithProblemCaseTest'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.gh.portal.Common.logon'('sqa_viewas@gmail.com', 'Pa22word')

WebUI.setText(findTestObject('Object Repository/Portal/inprogressreportelement/searchpatient'), 'Bridges')

WebUI.click(findTestObject('Object Repository/Portal/inprogressreportelement/selectpatient'))

WebUI.setText(findTestObject('Object Repository/Portal/inprogressreportelement/searchid'), aNumber)

WebUI.click(findTestObject('Object Repository/Portal/inprogressreportelement/selsearch'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Portal/inprogressreportelement/inprogressimg'), 10)

WebUI.click(findTestObject('Object Repository/Portal/inprogressreportelement/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/inprogressreportelement/signout'))

WebUI.closeBrowser()