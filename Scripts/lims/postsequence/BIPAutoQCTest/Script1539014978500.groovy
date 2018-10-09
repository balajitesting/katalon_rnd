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

WebUI.comment('ENT-6481')

String flowcellID_full = '180628_NB501054_0437_AHMN5YBGX5';

String flowcellID = WebUI.callTestCase(findTestCase('lims/postsequence/BIPUploadTest'), [('flowcellID_full') : flowcellID_full], 
    FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.gh.lims.Common.logon'('cliauserreporting', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('Object Repository/LIMS/PostSequence/SeqQCAutoPass/td_SeqQC Manual_sitemap_TramSt'))

WebUI.setText(findTestObject('Object Repository/LIMS/PostSequence/SeqQCAutoPass/input_Search_searchtext'), flowcellID)

WebUI.click(findTestObject('Object Repository/LIMS/PostSequence/SeqQCAutoPass/td_OK'))

