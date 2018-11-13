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


WebUI.comment('ENTC-2935')
WebUI.comment('ENTC-2936')


CustomKeywords.'com.gh.db.LimsDBDataReset.resetResOpsGenerateRelease'()

String current = new java.io.File(".").getCanonicalPath();

CustomKeywords.'com.gh.core.TestUtil.purgeDirectory'(current + "/Results/download");

CustomKeywords.'com.gh.lims.Common.logon'('ResOpsRhea', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('Object Repository/LIMS/ResOps Reporting/ResOps Project List Tramstop'))
WebUI.waitForPageLoad(6);

WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/ResOps Reporting/ResOpsProjectList/Generate Report Button'), 10)
WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/ResOps Reporting/ResOpsProjectList/Release Report Button'), 10)

WebUI.click(findTestObject('Object Repository/LIMS/ResOps Reporting/ResOpsProjectList/Generate Report Button'))

WebDriver driver = DriverFactory.getWebDriver();

driver.switchTo().frame("dlg_frame0");
Thread.sleep(1000);
driver.switchTo().frame("promptfields_iframe");

driver.findElement(By.xpath("//input[@id='filename']")).sendKeys(current + "/Resources/data/ResOps_sample_input_file_report_generation.csv");

WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/ResOps Reporting/ResOpsProjectList/Generate Report Popup/dlg_frame0/promptfields_iframe/Upload Button'), 10)
WebUI.click(findTestObject('Object Repository/LIMS/ResOps Reporting/ResOpsProjectList/Generate Report Popup/dlg_frame0/promptfields_iframe/Upload Button'))


assert WebUI.getText(findTestObject('Object Repository/LIMS/ResOps Reporting/ResOpsProjectList/Generate Report Popup/dlg_frame0/promptfields_iframe/Successfully uploaded text')).contains("Successfully uploaded to") == true 


driver.switchTo().defaultContent();
driver.switchTo().frame("dlg_frame0");

WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/ResOps Reporting/ResOpsProjectList/Generate Report Popup/dlg_frame0/OK Button'), 10)
WebUI.click(findTestObject('Object Repository/LIMS/ResOps Reporting/ResOpsProjectList/Generate Report Popup/dlg_frame0/OK Button'))

Thread.sleep(1000);
WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/ResOps Reporting/ResOpsProjectList/Confirmation_OK Button'), 10)
WebUI.click(findTestObject('Object Repository/LIMS/ResOps Reporting/ResOpsProjectList/Confirmation_OK Button'))

//Assert file generated succesfully and the csv generated successfully.
String date = CustomKeywords.'com.gh.core.TestUtil.getDate'("yyyyMMdd");
System.out.println(date);
String filepath = current + "/Results/download/"+date+"_GNE_01_5Samples_G360Report.csv";
assert CustomKeywords.'com.gh.core.TestUtil.waitUntilFileExist'(filepath, 5) == true;


WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/ResOps Reporting/ResOpsProjectList/Release Report Button'), 10)
WebUI.click(findTestObject('Object Repository/LIMS/ResOps Reporting/ResOpsProjectList/Release Report Button'))

Thread.sleep(1000);
driver.switchTo().defaultContent();
driver.switchTo().frame("dlg_frame2");
Thread.sleep(1000);
driver.switchTo().frame("promptfields_iframe");

driver.findElement(By.xpath("//input[@id='filename']")).sendKeys(filepath);
Thread.sleep(1000);
WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/ResOps Reporting/ResOpsProjectList/Generate Report Popup/dlg_frame0/promptfields_iframe/Upload Button'), 10)
WebUI.click(findTestObject('Object Repository/LIMS/ResOps Reporting/ResOpsProjectList/Generate Report Popup/dlg_frame0/promptfields_iframe/Upload Button'))

assert WebUI.getText(findTestObject('Object Repository/LIMS/ResOps Reporting/ResOpsProjectList/Generate Report Popup/dlg_frame0/promptfields_iframe/Successfully uploaded text')).contains("Successfully uploaded to") == true

driver.switchTo().defaultContent();
driver.switchTo().frame("dlg_frame2");

WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/ResOps Reporting/ResOpsProjectList/Generate Report Popup/dlg_frame0/OK Button'), 10)
WebUI.click(findTestObject('Object Repository/LIMS/ResOps Reporting/ResOpsProjectList/Generate Report Popup/dlg_frame0/OK Button'))

Thread.sleep(2000);

//assert the report is changed to released status
String sql = "select count(*) from s_request where S_REQUESTID in ('A85139','A85140','A85141','A85142','A85143') and u_ghrequeststatus = 'Released'";
String value = CustomKeywords.'com.gh.db.LimsDBOperation.getCount'(sql);
assert value.equals("5");

//assert u_finalreportdate is getting updated.
 sql = "select count(*) from s_request where S_REQUESTID in ('A85139','A85140','A85141','A85142','A85143') and u_finalreportdate is not null";
 value = CustomKeywords.'com.gh.db.LimsDBOperation.getCount'(sql); 
 assert value.equals("5");
 
 //assert u_latestreportdate is getting updated.
 sql = "select count(*) from s_request where S_REQUESTID in ('A85139','A85140','A85141','A85142','A85143') and u_latestreportdate is not null";
 value = CustomKeywords.'com.gh.db.LimsDBOperation.getCount'(sql);
 assert  value.equals("5");
 

WebUI.closeBrowser()
