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

String requestID = 'A0129187'; //'A92990';

CustomKeywords.'com.gh.db.LimsDBDataReset.resetDVStatus'(requestID, '1');
CustomKeywords.'com.gh.db.LimsDBDataReset.resetDV2Status'(requestID, '1');
CustomKeywords.'com.gh.db.LimsDBDataReset.resetRequestStatus'(requestID, 'Ready for Plasma Isolation');

CustomKeywords.'com.gh.lims.Common.logon'('ResOpsRhea', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/ResOps Requests/AllRequests TramStop'))

CustomKeywords.'com.gh.lims.ResOpsRequests.searchRequest'(requestID)

WebUI.click(findTestObject('Object Repository/LIMS/ResOps Requests/DV/Edit Button'))

Thread.sleep(2000) //Katalon wait not working

WebUI.switchToFrame(findTestObject('LIMS/Requests/DV2/Page_DV2/maint_iframe'), 10)

WebUI.click(findTestObject('LIMS/ResOps Requests/EditRequest/SearchCancel'))

WebUI.delay(1)

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.gh.lims.Common.switchToWindows'(driver)

WebUI.delay(1)

CustomKeywords.'com.gh.lims.Common.selectValueInPopUp'('200')

CustomKeywords.'com.gh.lims.ResOpsRequests.enterESign'('abcd1234')

WebUI.delay(2)

WebUI.click(findTestObject('LIMS/ResOps Requests/EditRequest/btn_CancelRequest'))

WebUI.delay(2)

WebUI.acceptAlert()

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/LIMS/ResOps Requests/DV/Return To List Button'))

WebUI.delay(3)

CustomKeywords.'com.gh.lims.ResOpsRequests.searchRequest'(requestID)

WebUI.switchToFrame(findTestObject('LIMS/Requests/AllRequests/list_iFrame'), 3)

assert WebUI.getText(findTestObject('LIMS/ResOps Requests/Search/status')).contains('Generate and Release Cancelled Report') == true

WebUI.closeBrowser()

