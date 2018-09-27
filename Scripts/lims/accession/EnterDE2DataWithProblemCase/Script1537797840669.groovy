import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.junit.After as After
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import internal.GlobalVariable as GlobalVariable

String aNumber = WebUI.callTestCase(findTestCase('lims/accession/DE2WithProblemCaseTest'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.gh.lims.Common.logon'('admin', 'RAIVpflpDOg=')

WebUI.click(findTestObject('LIMS/DE2/Page_Iteration/td_Second DataEntry'))

WebUI.setText(findTestObject('LIMS/DE2/Page_Patient Data Entry List/input_searchtext'), aNumber)

Thread.sleep(1000)
WebUI.click(findTestObject('LIMS/DE2/Page_Patient Data Entry List/td_OK'))

Thread.sleep(1000)

WebUI.verifyElementClickable(findTestObject('Other_OR/Page_Patient Data Entry List/img'))

WebUI.click(findTestObject('Other_OR/Page_Patient Data Entry List/img'))
Thread.sleep(1000)

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patmon'), 'JAN')

WebUI.setText(findTestObject('LIMS/DE1/Page_Iteration/input_patfname'), 'Katalon')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patlname'), 'Test')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patday'), '11')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patyear'), '1990')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/Page_Iteration/input_pataddr1'), '123 Test Drive')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_pataddr2'), 'Apt #501')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patcity'), 'Redwood City')

WebUI.click(findTestObject('LIMS/DE2/Page_Iteration/Page_Iteration/img_statelookup'))

WebUI.switchToWindowTitle('')

WebUI.click(findTestObject('LIMS/DE2/Page_/input_cb'))

WebUI.switchToWindowUrl(GlobalVariable.limsUrl + '/rc?command=page&page=MainAccession_P&multisdimode=EditSet&navigatornodeid=EditSet')

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

WebUI.click(findTestObject('Other_OR/DE2/save_btn'))

WebUI.closeBrowser()

return aNumber

