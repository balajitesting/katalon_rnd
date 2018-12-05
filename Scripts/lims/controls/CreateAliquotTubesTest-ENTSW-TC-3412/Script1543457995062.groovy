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

WebUI.comment('ENTSW-TC-3412')

CustomKeywords.'com.gh.lims.Common.logon'('ResOpsRhea', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/Controls/ControlTubes/trmStop_ControlTubes'))

WebUI.click(findTestObject('LIMS/Controls/ControlTubes/btn_CreateAliquotTubes'))

WebDriver driver = DriverFactory.getWebDriver()

driver.switchTo().frame("dlg_frame0");

Thread.sleep(1000);

driver.switchTo().frame("promptfields_iframe");

WebUI.selectOptionByValue(findTestObject('LIMS/Controls/ControlTubes/select_ControlType'), 'AIO', true)

WebUI.selectOptionByValue(findTestObject('LIMS/Controls/ControlTubes/select_LotNo'), '11', true)

WebUI.setText(findTestObject('LIMS/Controls/ControlTubes/input_NoOfTubes'), '2')

WebUI.switchToDefaultContent()

driver.switchTo().frame("dlg_frame0");

WebUI.click(findTestObject('LIMS/ResOps Requests/AllRequests/btn_CreateAliquot_OK'))

WebUI.delay(2)

WebUI.acceptAlert()

WebUI.delay(2)

WebUI.click(findTestObject('LIMS/ResOps Requests/AllRequests/btn_CreateAliquot_OK'))

WebUI.click(findTestObject('LIMS/logout/img_Logout'))

WebUI.closeBrowser()
