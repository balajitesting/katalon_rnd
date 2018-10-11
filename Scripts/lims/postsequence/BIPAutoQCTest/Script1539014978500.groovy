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

String flowcellID_full = '180628_NB501054_0437_AHMN5YBGX5'

String flowcellID = 'HMN5YBGX5'

flowcellID = WebUI.callTestCase(findTestCase('lims/postsequence/BIPUploadTest'), [('flowcellID_full') : flowcellID_full], 
    FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.gh.lims.Common.logon'('cliauserreporting', '5Ed5CIkj9UQfaMZXAkDVaQ==')


WebUI.waitForElementClickable(findTestObject('LIMS/PostSequence/SeqQC Auto TramStop'), 5)
WebUI.click(findTestObject('LIMS/PostSequence/SeqQC Auto TramStop'))

WebUI.setText(findTestObject('Object Repository/LIMS/PostSequence/Page_SeqQCAutoPass/Search_Textbox'), flowcellID)

WebUI.click(findTestObject('Object Repository/LIMS/PostSequence/Page_SeqQCAutoPass/Search_OK_Button'))

WebUI.waitForPageLoad(4);

WebUI.waitForElementClickable(findTestObject('Object Repository/LIMS/PostSequence/Page_SeqQCAutoPass/Seq_QC Auto_Pass_Proceed_Button'), 5)
WebUI.click(findTestObject('Object Repository/LIMS/PostSequence/Page_SeqQCAutoPass/Seq_QC Auto_Pass_Proceed_Button'))

WebUI.waitForPageLoad(4);

WebUI.waitForElementClickable(findTestObject('Object Repository/LIMS/PostSequence/Page_SeqQCAutoPass/VerifySave_Button'), 5)
WebUI.click(findTestObject('Object Repository/LIMS/PostSequence/Page_SeqQCAutoPass/VerifySave_Button'))

WebUI.waitForPageLoad(30);

WebUI.waitForElementVisible(findTestObject('Object Repository/LIMS/PostSequence/Page_SeqQCAutoPass/Popup/OK_Button'), 30)
WebUI.waitForElementClickable(findTestObject('Object Repository/LIMS/PostSequence/Page_SeqQCAutoPass/Popup/OK_Button'), 30)
WebUI.click(findTestObject('Object Repository/LIMS/PostSequence/Page_SeqQCAutoPass/Popup/OK_Button'))

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()

return flowcellID



