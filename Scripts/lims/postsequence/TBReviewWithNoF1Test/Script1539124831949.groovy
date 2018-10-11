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

//Finish TB review workflow
WebUI.comment('Run: ENT-6483')

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserReporting', '5Ed5CIkj9UQfaMZXAkDVaQ==')

String requestID = 'A30101'

CustomKeywords.'com.gh.db.ResetRequestStatus.reset'(requestID, 'TB Review BIP Data')

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/Search/tab_TBReview'))

WebUI.setText(findTestObject('LIMS/PostSequence/TBReview/Search/input_Search_searchtext'), 'A30101')

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/Search/td_OK'))

Thread.sleep(3000) //Wait command is not working properly. Hence, implemented the same.

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/BeginWorkflow/btn_BeginWorkflow'))

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/CNVReview/btn_cnvReview'))

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/SNVReview/btn_snvReview'))

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/FusionReview/btn_FusionReview'))

Thread.sleep(3000) //Wait command is not working properly. Hence, implemented the same.

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/IndelReview/td_IndelReview'))

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/MSIReview/td_MSIReview'))

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/CompleteTBReview/td_CompleteReview'))

Thread.sleep(5000) //Wait command is not working properly. Hence, implemented the same.

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/CompleteTBReview/popupText'))

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/CompleteTBReview/buttonOK'))

//Status will get change to Ready of nof1

WebUI.click(findTestObject('LIMS/Header/img_AllTram'))

WebUI.click(findTestObject('LIMS/Home/icon_Request_AllRequest'))

Thread.sleep(3000) //Wait command is not working properly. Hence, implemented the same.

WebUI.setText(findTestObject('LIMS/PostSequence/TBReview/Search/input_Search_searchtext'), 'A30101')

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/Search/td_OK'))

Thread.sleep(3000) //Wait command is not working properly. Hence, implemented the same.

WebUI.switchToFrame(findTestObject('LIMS/Requests/AllRequests/list_iFrame'), 3)

assert WebUI.getText(findTestObject('LIMS/Requests/AllRequests/td_SentToNof1')).contains("Sent") == true

WebUI.closeBrowser()

