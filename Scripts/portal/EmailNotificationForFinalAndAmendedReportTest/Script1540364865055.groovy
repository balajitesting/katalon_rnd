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

String aNumber = 'A0126541'

WebUI.openBrowser('http://52.38.227.56:8025/#')

WebUI.waitForPageLoad(100)

WebUI.setText(findTestObject('Object Repository/Portal/mailhog_element/searchmail'), aNumber)

WebUI.click(findTestObject('Object Repository/Portal/mailhog_element/msgselect'))

WebUI.click(findTestObject('Object Repository/Portal/mailhog_element/mailselection'))

WebUI.scrollToElement(findTestObject('Object Repository/Portal/mailhog_element/searchmail'), 10)

WebUI.click(findTestObject('Object Repository/Portal/mailhog_element/searchmail'))

WebUI.closeBrowser()