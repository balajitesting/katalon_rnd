import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.testng.Assert
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

'Login to portal as a Pharma Admin'

CustomKeywords.'com.gh.portal.Common.logon'('uhh@symphogen.com', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(15)

String company_Name = WebUI.getText(findTestObject('Object Repository/Portal/page_pharmaportal/companyname'))

println(company_Name)

String company_Trials = WebUI.getText(findTestObject('Object Repository/Portal/page_pharmaportal/companytrialname'))

println(company_Trials)

String trials_Data = WebUI.getText(findTestObject('Object Repository/Portal/page_pharmaportal/trialsdata'))

Assert.assertEquals(company_Trials, trials_Data)

WebUI.delay(3)

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

WebUI.closeBrowser()



