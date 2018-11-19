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

WebUI.comment('Run ENTSW-TC-2861')

String aNumber = WebUI.callTestCase(findTestCase('lims/accession/DE1CreateProblemCaseTest'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserDagmar', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/DE2/Page_Iteration/td_Second DataEntry'))

CustomKeywords.'com.gh.lims.Accession.searchRequest'(aNumber)

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patmon'), 'JAN')

WebUI.setText(findTestObject('LIMS/DE1/Page_Iteration/input_patfname'), 'Katalon')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patlname'), 'Test')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patday'), '11')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patyear'), '1990')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_pataddr1'), '123 Test Drive')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_pataddr2'), 'Apt #501')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patcity'), 'Redwood City')

WebUI.click(findTestObject('LIMS/DE2/Page_Iteration/img_statelookup'))

WebUI.switchToWindowTitle('')

WebUI.click(findTestObject('LIMS/DE2/Page_/input_cb'))

WebUI.switchToDefaultContent()

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patzip'), '94040')

WebUI.setText(findTestObject('/LIMS/DE2/Page_Iteration/input_patphone'), '650-123-4567')

WebUI.setText(findTestObject('/LIMS/DE2/Page_Iteration/input_patemail'), 'gxu@guardanthealth.com')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patmrn'), '0123456789')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patcustpatientid'), '0123456789')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_treatmentnotes'), 'Notes')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_pathreporttype'), 'TestType')

WebUI.click(findTestObject('LIMS/DE2/Page_Iteration/input_patientgender'))

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_diagnosisdate'), '01/02/2018')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_otherdiagnosis'), 'Test')

WebUI.click(findTestObject('LIMS/DE2/Page_Iteration/table_Patient Contact Permissi'))

WebUI.setText(findTestObject('/LIMS/DE2/Page_Iteration/input_priorgenotypingdetail'), 'Test detail')

WebUI.click(findTestObject('LIMS/DE1/Page_Iteration/input_isprogrssingonrx'))

WebUI.click(findTestObject('LIMS/DE2/Page_Iteration/save_btn'))

WebUI.acceptAlert()

WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/logout/img'), 15)

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()

return aNumber
