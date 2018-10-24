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

WebUI.comment('ENT-2932')

String requestID = 'A0120749';

CustomKeywords.'com.gh.db.LimsDBDataReset.resetDVStatus'(requestID, '0');

CustomKeywords.'com.gh.lims.Common.logon'('ResOpsRhea', '5Ed5CIkj9UQfaMZXAkDVaQ==')



WebUI.click(findTestObject('Object Repository/LIMS/ResOps Requests/DV2 TramStop'))

WebUI.waitForPageLoad(6);
WebUI.waitForElementClickable(findTestObject('LIMS/ResOps Requests/DV/GHDVResOpsSearch Link'), 30)
WebUI.click(findTestObject('LIMS/ResOps Requests/DV/GHDVResOpsSearch Link'))

WebUI.setText(findTestObject('Object Repository/LIMS/ResOps Requests/DV/requestID Search TextBox'), requestID)
WebUI.click(findTestObject('Object Repository/LIMS/ResOps Requests/DV/OK Button'))


WebUI.waitForPageLoad(6);

WebUI.switchToFrame(findTestObject('Object Repository/LIMS/ResOps Requests/DV/list_iframe/list_iframe'), 10)
Thread.sleep(2000) //Katalon wait not working
WebUI.waitForElementVisible(findTestObject('Object Repository/LIMS/ResOps Requests/DV/list_iframe/Request Type selector Radio Button'), 10)
WebUI.waitForElementClickable(findTestObject('Object Repository/LIMS/ResOps Requests/DV/list_iframe/Request Type selector Radio Button'), 30)
WebUI.click(findTestObject('Object Repository/LIMS/ResOps Requests/DV/list_iframe/Request Type selector Radio Button'))

WebUI.switchToDefaultContent()

WebUI.waitForPageLoad(6);
WebUI.waitForElementClickable(findTestObject('Object Repository/LIMS/ResOps Requests/DV/OK Button'), 30)
WebUI.click(findTestObject('Object Repository/LIMS/ResOps Requests/DV/Edit Button'))

WebUI.waitForPageLoad(6);
Thread.sleep(2000) //Katalon wait not working
//WebUI.waitForElementVisible(findTestObject('Object Repository/LIMS/ResOps Requests/DV/maint_iframe/maint_iframe'), 10)
//WebUI.switchToFrame(findTestObject('Object Repository/LIMS/ResOps Requests/DV/maint_iframe/maint_iframe'), 10)

WebDriver driver = DriverFactory.getWebDriver();
driver.switchTo().frame("maint_iframe");

WebUI.waitForElementVisible(findTestObject('Object Repository/LIMS/ResOps Requests/DV/maint_iframe/DV Verified CheckBox'), 10)
WebUI.waitForElementClickable(findTestObject('Object Repository/LIMS/ResOps Requests/DV/maint_iframe/DV Verified CheckBox'), 30)
WebUI.click(findTestObject('Object Repository/LIMS/ResOps Requests/DV/maint_iframe/DV Verified CheckBox'))

driver.switchTo().defaultContent();

WebUI.click(findTestObject('Object Repository/LIMS/ResOps Requests/DV/Save Button'))

WebUI.switchToFrame(findTestObject('Object Repository/LIMS/DV1/eSign/iFrame'), 10)

WebUI.setText(findTestObject('Object Repository/LIMS/DV1/eSign/password'), 'abcd1234')

WebUI.click(findTestObject('Object Repository/LIMS/DV1/eSign/dropdown_Btn'))

WebUI.click(findTestObject('Object Repository/LIMS/DV1/eSign/select_Reason'))

WebUI.click(findTestObject('Object Repository/LIMS/DV1/eSign/eSign_OK'))

WebUI.switchToDefaultContent()

WebUI.waitForPageLoad(6);
Thread.sleep(2000); //Katalon wait not working. 

WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/ResOps Requests/DV/Return To List Button'), 15)
WebUI.waitForElementClickable(findTestObject('Object Repository/LIMS/ResOps Requests/DV/Return To List Button'), 30)
WebUI.click(findTestObject('Object Repository/LIMS/ResOps Requests/DV/Return To List Button'))
Thread.sleep(2000);
WebUI.waitForPageLoad(6);
WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/logout/img'), 15)
WebUI.click(findTestObject('LIMS/logout/img'))
WebUI.waitForPageLoad(6);
WebUI.closeBrowser()

