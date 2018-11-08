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


WebUI.comment('ENTSW-TC-2931')


CustomKeywords.'com.gh.db.LimsDBDataReset.deleteEManifest'('GASTRO-346', '58103_Baseline', 'GHI_02', '58103', '450000001901')
CustomKeywords.'com.gh.db.LimsDBDataReset.deleteEManifest'('GASTRO-346', '58103_Baseline', 'GHI_02', '58103', '450000001902')
CustomKeywords.'com.gh.db.LimsDBDataReset.deleteEManifest'('GASTRO-346', '58104_Baseline', 'GHI_02', '58103', '53001901')
CustomKeywords.'com.gh.db.LimsDBDataReset.deleteEManifest'('GASTRO-346', '58104_Baseline', 'GHI_02', '58103', '53001902')
CustomKeywords.'com.gh.db.LimsDBDataReset.deleteEManifest'('GASTRO-346', '58104_Baseline', 'GHI_02', '58103', '46001901')
CustomKeywords.'com.gh.db.LimsDBDataReset.deleteEManifest'('GASTRO-346', '58104_Baseline', 'GHI_02', '58103', '46001902')

CustomKeywords.'com.gh.lims.Common.logon'('ResOpsRhea', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('Object Repository/LIMS/ResOps Accession/EManifest SingleTube Accession TramStop'))
WebUI.waitForPageLoad(6);
WebUI.waitForElementPresent(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/Upload Button'), 10)
WebUI.click(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/Upload Button'))

WebDriver driver = DriverFactory.getWebDriver();
driver.switchTo().frame("dlg_frame0");
Thread.sleep(1000);
driver.switchTo().frame("promptfields_iframe");
String current = new java.io.File(".").getCanonicalPath();

WebUI.sendKeys(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/UploadFilePopup/Upload File Object'), current + '/Resources/data/Emanifest_input_file.xlsx')
WebUI.waitForPageLoad(6);
WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/UploadFilePopup/dlg_frame0/promtfields_iframe/Upload Button'), 10)
WebUI.click(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/UploadFilePopup/dlg_frame0/promtfields_iframe/Upload Button'))
WebUI.waitForPageLoad(6);
driver.switchTo().defaultContent();
driver.switchTo().frame("dlg_frame0");

WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/UploadFilePopup/dlg_frame0/OK Button'), 10)
WebUI.click(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/UploadFilePopup/dlg_frame0/OK Button'))

//assert WebUI.getText(findTestObject('Object Repository/LIMS/PostSequence/Page_BipUploadBySample/Operation Successful Text')).contains("Operation Successful") == true
driver.switchTo().frame('list_iframe')
By item = By.xpath("//*[@id='__ruleErrorTable']/tbody/tr[2]/td/table/tbody/tr/td[2]");
WebDriverWait wait = new WebDriverWait(driver, 80);
wait.until(ExpectedConditions.visibilityOfElementLocated(item));

String success = driver.findElement(item).getText();

assert success.contentEquals("Operation Successful") == true;
driver.switchTo().defaultContent();

String studyid = "GASTRO-346";
String customersampleid = "58103_Baseline";
String projectid = "GHI_02";
String patientid = "58103";
String tubebarcode =  "450000001901";

String query = "select count(*) from u_ghemanifest where studyid = '"+studyid+"' and customersampleid = '"+customersampleid+"' and ProjectID = '"+projectid+"' and PatientID = '"+patientid+"' and tubebarcode = '"+tubebarcode+"'";
int count = CustomKeywords.'com.gh.db.LimsDBOperation.getCount'(query);
assert count == 1;

studyid = "GASTRO-346";
customersampleid = "58103_Baseline";
projectid = "GHI_02";
patientid = "58103";
tubebarcode =  "450000001902";

 query = "select count(*) from u_ghemanifest where studyid = '"+studyid+"' and customersampleid = '"+customersampleid+"' and ProjectID = '"+projectid+"' and PatientID = '"+patientid+"' and tubebarcode = '"+tubebarcode+"'";
 count = CustomKeywords.'com.gh.db.LimsDBOperation.getCount'(query);
assert count == 1;


studyid = "GASTRO-346";
customersampleid = "58104_Baseline";
projectid = "GHI_02";
patientid = "58103";
tubebarcode =  "53001901";

 query = "select count(*) from u_ghemanifest where studyid = '"+studyid+"' and customersampleid = '"+customersampleid+"' and ProjectID = '"+projectid+"' and PatientID = '"+patientid+"' and tubebarcode = '"+tubebarcode+"'";
 count = CustomKeywords.'com.gh.db.LimsDBOperation.getCount'(query);
assert count == 1;

studyid = "GASTRO-346";
customersampleid = "58104_Baseline";
projectid = "GHI_02";
patientid = "58103";
tubebarcode =  "53001902";

 query = "select count(*) from u_ghemanifest where studyid = '"+studyid+"' and customersampleid = '"+customersampleid+"' and ProjectID = '"+projectid+"' and PatientID = '"+patientid+"' and tubebarcode = '"+tubebarcode+"'";
 count = CustomKeywords.'com.gh.db.LimsDBOperation.getCount'(query);
assert count == 1;

studyid = "GASTRO-346";
customersampleid = "58104_Baseline";
projectid = "GHI_02";
patientid = "58103";
tubebarcode =  "46001901";

 query = "select count(*) from u_ghemanifest where studyid = '"+studyid+"' and customersampleid = '"+customersampleid+"' and ProjectID = '"+projectid+"' and PatientID = '"+patientid+"' and tubebarcode = '"+tubebarcode+"'";
 count = CustomKeywords.'com.gh.db.LimsDBOperation.getCount'(query);
assert count == 1;

studyid = "GASTRO-346";
customersampleid = "58104_Baseline";
projectid = "GHI_02";
patientid = "58103";
tubebarcode =  "46001902";

 query = "select count(*) from u_ghemanifest where studyid = '"+studyid+"' and customersampleid = '"+customersampleid+"' and ProjectID = '"+projectid+"' and PatientID = '"+patientid+"' and tubebarcode = '"+tubebarcode+"'";
 count = CustomKeywords.'com.gh.db.LimsDBOperation.getCount'(query);
assert count == 1;

query = "select u_ghemanifestid from u_ghemanifest where studyid = '"+studyid+"' and customersampleid = '"+customersampleid+"' and ProjectID = '"+projectid+"' and PatientID = '"+patientid+"' and tubebarcode = '"+tubebarcode+"'";
String value = CustomKeywords.'com.gh.db.LimsDBOperation.getValue'(query);

driver.findElement(By.xpath("//*[@id='searchtext']")).clear();
WebUI.sendKeys(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/Search TextBox'), value)
WebUI.click(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/Search OK Button'))

driver.switchTo().defaultContent();
//assert the list return the item
driver.switchTo().frame("list_iframe");
item = By.xpath("//*[@id=\""+value+"\"]");
wait = new WebDriverWait(driver, 80);
wait.until(ExpectedConditions.visibilityOfElementLocated(item));

driver.findElement(item).click();

WebUI.closeBrowser()
