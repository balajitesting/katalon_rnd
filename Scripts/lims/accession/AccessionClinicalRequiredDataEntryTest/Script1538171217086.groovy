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

import org.junit.After
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.common.WebUiCommonHelper

import org.openqa.selenium.WebDriver as WebDriver

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

import internal.GlobalVariable as GlobalVariable

WebUI.comment('Run ENTSW-TC-2854')

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserDagmar', '5Ed5CIkj9UQfaMZXAkDVaQ==')

String orDE1 = 'LIMS/DE1/'

WebUI.click(findTestObject(orDE1 + 'Page_Iteration/td_Accession Clinical'))

String barCode = CustomKeywords.'com.gh.core.TestUtil.getRandom'()

WebUI.setText(findTestObject(orDE1 + 'Page_Iteration/input_trfbarcode'), barCode)

WebUI.setText(findTestObject(orDE1 + 'Page_Iteration/input_trfversion'), 'TST-TRF-001 V7')

WebUI.setText(findTestObject(orDE1 + 'Page_Iteration/input_trackingno'), CustomKeywords.'com.gh.core.TestUtil.getRandom'())

WebUI.setText(findTestObject(orDE1 + 'Page_Iteration/input_tubebarcode01'), barCode)

WebUI.setText(findTestObject(orDE1 + 'Page_Iteration/input_tubebarcode02'), barCode)

WebUI.setText(findTestObject('LIMS/DE1/Page_Iteration/input_tubebarcode03'), barCode)

WebUI.setText(findTestObject('LIMS/DE1/Page_Iteration/input_tubebarcode04'), barCode)

String date = CustomKeywords.'com.gh.core.TestUtil.setDate'()

WebUI.setText(findTestObject(orDE1 + 'Page_Iteration/input_bloodcolldate'), date)

WebUI.setText(findTestObject(orDE1 + 'Page_Iteration/input_noofpages'), '2')

WebUI.scrollToPosition(430, 662)

WebUI.click(findTestObject(orDE1 + 'Page_Iteration/input_searchbutton'))

WebUI.switchToWindowTitle('')

WebUI.setText(findTestObject(orDE1 + 'Page_/input_firstnamesrch'), 'SQAPortalPhysician')

WebUI.click(findTestObject(orDE1 + 'Page_/input_Search'))

WebUI.click(findTestObject(orDE1 + 'Page_/input_cb'))

WebUI.switchToDefaultContent()

WebUI.setText(findTestObject(orDE1 + 'Page_Iteration/input_secsearchstr'), 'sqa')

WebUI.click(findTestObject(orDE1 + 'Page_Iteration/input_searchbuttonsr'))

WebUI.switchToDefaultContent()

WebUI.scrollToElement(findTestObject('LIMS/DE1/Page_Iteration/input_saveAccession01'), 15)

CustomKeywords.'com.gh.core.JSHandler.JClick'(findTestObject('LIMS/DE1/Page_Iteration/input_saveAccession01'), 15)

aNumber = WebUI.getAttribute(findTestObject(orDE1 + 'Page_Iteration/input_requestid'), 'value')

println(aNumber)

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()




return aNumber
