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

import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.comment('Run: ENT-6677')

//Reset the aNumber status in DV and ProblemCase

String aNumber = 'A0121097'

CustomKeywords.'com.gh.db.LimsDBDataReset.resetDVStatus'(aNumber, '0')

CustomKeywords.'com.gh.db.LimsDBDataReset.resetProblemCase'(aNumber)

CustomKeywords.'com.gh.lims.Common.logon'('abaca', '5Ed5CIkj9UQfaMZXAkDVaQ==')

//Validation 1: Edit a request in DV‌ and add a problem case

WebUI.click(findTestObject('LIMS/Requests/DV1/DV1Request/dv1Tram'))

WebUI.click(findTestObject('LIMS/Requests/DV1/DV1Request/GHDVSearchButton'))

WebUI.setText(findTestObject('LIMS/Requests/DV1/DV1Request/dv1SearchTextBox'), aNumber)

WebUI.click(findTestObject('LIMS/Requests/DV1/DV1Request/td_OK'))

edit = 'LIMS/Problem Resolution/Page_Problem Cases Resolution/div_Edit'

CustomKeywords.'com.gh.lims.Common.setClick'(edit)

WebUI.switchToFrame(findTestObject('LIMS/Requests/DV2/Page_DV2/maint_iframe'), 10)

WebUI.click(findTestObject('LIMS/Requests/DV2/Page_DV2/addButton'))

WebUI.click(findTestObject('LIMS/Requests/DV2/Page_DV2/searchProbCaseIcon'))

WebDriver driver = DriverFactory.getWebDriver()

// Switch to Problem Case Window
String winHandleBefore = driver.getWindowHandle();

for(String winHandle : driver.getWindowHandles()){
	driver.switchTo().window(winHandle);
}

assert WebUI.getText(findTestObject('LIMS/Requests/DV2/DV2Request/searchBarText')).contains("Search Bar") == true

WebUI.setText(findTestObject('LIMS/Requests/DV2/Page_DV2/searchProblemCase/searchText'), 'R01')

WebUI.click(findTestObject('LIMS/Requests/DV2/Page_DV2/searchProblemCase/searchOk'))

WebUI.switchToFrame(findTestObject('LIMS/Requests/DV2/Page_DV2/listFrame'), 3)

Thread.sleep(2000) //Wait command is not working properly. Hence, implemented the same.

assert WebUI.getText(findTestObject('LIMS/Requests/DV2/Page_DV2/problemCaseValue')).contains("R01") == true

WebUI.click(findTestObject('LIMS/Requests/DV2/Page_DV2/problemCaseValue'))

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/img'))  

WebUI.switchToFrame(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Frame'), 10) 

WebUI.waitForElementVisible(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Password'), 10)

WebUI.setText(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Password'), 'abcd1234')

WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Dropdown_Btn'))

WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Select_Reason'))

WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_OK'))

WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/img'))

//Validation 2: Verify that the request is moved to PC.

WebUI.click(findTestObject('LIMS/Requests/Problemcases Resolution/tab_ProblemcasesResolution'))

Thread.sleep(3000) //Wait command is not working properly. Hence, implemented the same.

WebUI.setText(findTestObject('LIMS/PostSequence/TBReview/Search/input_Search_searchtext'), aNumber)

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/Search/td_OK'))

Thread.sleep(3000) //Wait command is not working properly. Hence, implemented the same.

WebUI.switchToFrame(findTestObject('LIMS/Requests/AllRequests/list_iFrame'), 3)

assert WebUI.getText(findTestObject('LIMS/Requests/Problemcases Resolution/column_Status')).contains('Ready') == true

WebUI.closeBrowser()

