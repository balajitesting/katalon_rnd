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

WebUI.comment('Run: ENTSW-TC-2963')

String aNumber = WebUI.callTestCase(findTestCase('lims/accession/AcessionClinicalRequiredDataEntryTest'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserDagmar', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/DE2/Page_Iteration/td_Second DataEntry'))

CustomKeywords.'com.gh.lims.Acession.searchRequest'(aNumber)

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patmon'), 'JAN')

WebUI.setText(findTestObject('LIMS/DE1/Page_Iteration/input_patfname'), 'Katalon')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patlname'), 'Test')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patday'), '11')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patyear'), '1990')

WebUI.click(findTestObject('LIMS/DE2/Page_Iteration/input_patientgender'))

WebUI.click(findTestObject('LIMS/DE2/Page_Iteration/input_Initial Billing Verified'))

WebUI.acceptAlert()

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()

return aNumber

