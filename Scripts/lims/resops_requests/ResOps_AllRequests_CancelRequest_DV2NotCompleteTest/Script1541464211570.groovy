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

import org.junit.After
import org.openqa.selenium.By as By
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor;

WebUI.comment('ENT-2932')

String requestID = 'A0120749'; //'A92990';

CustomKeywords.'com.gh.db.LimsDBDataReset.resetDVStatus'(requestID, '0');
CustomKeywords.'com.gh.db.LimsDBDataReset.resetDV2Status'(requestID, '0');
CustomKeywords.'com.gh.db.LimsDBDataReset.resetRequestStatus'(requestID, 'Ready for Plasma Isolation');

CustomKeywords.'com.gh.lims.Common.logon'('ResOpsRhea', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/ResOps Requests/AllRequests TramStop'))

WebUI.setText(findTestObject('LIMS/PostSequence/TBReview/Search/input_Search_searchtext'), requestID)

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/Search/td_OK'))

Thread.sleep(2000) //Katalon wait not working

WebUI.click(findTestObject('Object Repository/LIMS/ResOps Requests/DV/Edit Button'))

Thread.sleep(2000) //Katalon wait not working

WebUI.switchToFrame(findTestObject('LIMS/Requests/DV2/Page_DV2/maint_iframe'), 10)

WebDriver driver = DriverFactory.getWebDriver()

WebUI.click(findTestObject('LIMS/ResOps Requests/EditRequest/SearchCancel'))

Thread.sleep(2000) //Wait command is not working properly. Hence, implemented the same.

// Switch to Cancel Reason Window
String winHandleBefore = driver.getWindowHandle();

for(String winHandle : driver.getWindowHandles()){
	driver.switchTo().window(winHandle);
}

Thread.sleep(2000)

assert WebUI.getText(findTestObject('LIMS/Requests/DV2/DV2Request/searchBarText')).contains("Search Bar") == true

WebUI.setText(findTestObject('LIMS/Requests/DV2/Page_DV2/searchProblemCase/searchText'), '200')

WebUI.click(findTestObject('LIMS/Requests/DV2/Page_DV2/searchProblemCase/searchOk'))

WebUI.switchToFrame(findTestObject('LIMS/Requests/DV2/Page_DV2/listFrame'), 3)

Thread.sleep(2000) //Wait command is not working properly. Hence, implemented the same.

assert WebUI.getText(findTestObject('LIMS/Requests/DV2/Page_DV2/problemCaseValue')).contains("200") == true

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

Thread.sleep(2000) //Wait command is not working properly. Hence, implemented the same.

WebUI.click(findTestObject('LIMS/ResOps Requests/EditRequest/btn_CancelRequest'))

Thread.sleep(2000) //Wait command is not working properly. Hence, implemented the same.

WebUI.acceptAlert()

Thread.sleep(2000); //Katalon wait not working.

//assert WebUI.getAlertText().contains('DV Check not completed') == true

assert WebUI.getText(findTestObject('LIMS/ResOps Requests/EditRequest/msg_div2Verification')).contains('DV Check not completed') == true

WebUI.click(findTestObject('Object Repository/LIMS/ResOps Requests/DV/Return To List Button'))

Thread.sleep(2000); //Katalon wait not working.

WebUI.click(findTestObject('Object Repository/LIMS/ResOps Requests/DV/Return To List Button'))

Thread.sleep(3000) //Wait command is not working properly. Hence, implemented the same.

WebUI.setText(findTestObject('LIMS/PostSequence/TBReview/Search/input_Search_searchtext'), requestID)

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/Search/td_OK'))

Thread.sleep(3000) //Wait command is not working properly. Hence, implemented the same.

WebUI.switchToFrame(findTestObject('LIMS/Requests/AllRequests/list_iFrame'), 3)

assert WebUI.getText(findTestObject('LIMS/ResOps Requests/Search/status')).contains('Ready for Plasma Isolation') == true

WebUI.closeBrowser()

