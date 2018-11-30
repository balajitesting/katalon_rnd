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

WebUI.comment('ENTSW-TC-2882')
System.out.println("flowcellID_full " + flowcellID_full);
CustomKeywords.'com.gh.lims.Common.logon'('cliauserreporting', '5Ed5CIkj9UQfaMZXAkDVaQ==')
//Manual QC
//String flowcellID_full = '170616_NB501068_0284_AHWCCHBGXY'  
//Auto QC
//String flowcellID_full = '180430_NB551146_0095_AH7NK7BGX5'
CustomKeywords.'com.gh.db.LimsDBDataReset.BIP_delete_by_flowcellID'(flowcellID_full)

WebUI.comment("ENT-6329")

String flowcellID = flowcellID_full.substring(flowcellID_full.length() - 9, flowcellID_full.length())

CustomKeywords.'com.gh.lims.PostSequence.uploadBIPData'(flowcellID)

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()

return flowcellID


