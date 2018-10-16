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

WebUI.comment('ENT-6482')

String flowcellID_full = '170616_NB501068_0284_AHWCCHBGXY'

String flowcellID = 'HWCCHBGXY'

flowcellID = WebUI.callTestCase(findTestCase('lims/postsequence/BIPUploadTest'), [('flowcellID_full') : flowcellID_full], 
    FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.gh.db.ResetFlowCellStatus.reset'(flowcellID, 'ManualSeqQC')

CustomKeywords.'com.gh.lims.Common.logon'('cliauserreporting', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.waitForPageLoad(4)

WebUI.waitForElementClickable(findTestObject('Object Repository/LIMS/PostSequence/SeqQC_ManualTramStop'), 5)

WebUI.click(findTestObject('Object Repository/LIMS/PostSequence/SeqQC_ManualTramStop'))

WebUI.setText(findTestObject('Object Repository/LIMS/PostSequence/Page_SeqQCManualPass/Search_Textbox'), flowcellID)

WebUI.click(findTestObject('Object Repository/LIMS/PostSequence/Page_SeqQCManualPass/Search_OK_Button'))

WebUI.waitForPageLoad(4)

CustomKeywords.'com.gh.lims.Common.setClick'('Object Repository/LIMS/PostSequence/Page_SeqQCAutoPass/SingleClick_SeqQCButton')

WebUI.waitForPageLoad(4)

WebUI.waitForElementVisible(findTestObject('Object Repository/LIMS/PostSequence/Page_SeqQCAutoPass/Verify_SaveButton'), 30)
WebUI.waitForElementClickable(findTestObject('Object Repository/LIMS/PostSequence/Page_SeqQCAutoPass/Verify_SaveButton'), 30)
CustomKeywords.'com.gh.lims.Common.setClick'('Object Repository/LIMS/PostSequence/Page_SeqQCAutoPass/Verify_SaveButton')

WebUI.waitForPageLoad(4)

WebUI.waitForElementVisible(findTestObject('Object Repository/LIMS/PostSequence/Page_SeqQCAutoPass/Popup/OK_Button'), 30)
WebUI.waitForElementClickable(findTestObject('Object Repository/LIMS/PostSequence/Page_SeqQCAutoPass/Popup/OK_Button'), 30)
WebUI.click(findTestObject('Object Repository/LIMS/PostSequence/Page_SeqQCAutoPass/Popup/OK_Button'))

WebUI.waitForPageLoad(4)
WebUI.click(findTestObject('LIMS/logout/img'))
WebUI.closeBrowser()


