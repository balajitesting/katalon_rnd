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



WebUI.comment('ENT-6699')

CustomKeywords.'com.gh.lims.Common.logon'('ResOpsRhea', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('Object Repository/LIMS/ResOps Accession/EManifest SingleTube Accession TramStop'))

WebUI.click(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/Add Button'))

WebUI.switchToWindowTitle('ManifestSample Tube Data Entry')

WebUI.switchToFrame(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/maint_iframe'), 3)

WebUI.click(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/ProjectID Search'))
WebUI.switchToWindowIndex(1)
WebUI.setText(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/ProjectID_PopUp/Search_TextBox'), 'GHI_04')
WebUI.waitForElementClickable(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/ProjectID_PopUp/Search OK Button'), 60)
WebUI.click(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/ProjectID_PopUp/Search OK Button'))

WebUI.switchToFrame(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/ProjectID_PopUp/list_iframe'), 10)
//Unable to have katalon recognize the object, leave it as request from Grace, will come back to this later.
//WebUI.waitForElementClickable(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/ProjectID_PopUp/a_GHI_04'), 60)
//WebU.click(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/ProjectID_PopUp/a_GHI_04'))

WebDriver driver = DriverFactory.getWebDriver();
By item = By.partialLinkText("GHI_04");
WebDriverWait wait = new WebDriverWait(driver, 80);
wait.until(ExpectedConditions.visibilityOfElementLocated(item));
wait.until(ExpectedConditions.elementToBeClickable(item));

driver.findElement(item).click();

WebUI.switchToDefaultContent();
WebUI.switchToWindowIndex(0);

WebUI.waitForPageLoad(6);

WebUI.switchToFrame(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/maint_iframe'), 3)
WebUI.setText(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/Site Number TextBox'), '95')

//set blood collection date current - 2 days.
Calendar cal = Calendar.getInstance();
cal.add(Calendar.DATE, -2);
SimpleDateFormat ds = new SimpleDateFormat("MM/dd/YYYY");
String date = ds.format(cal.getTime());
driver.findElement(By.xpath("//*[@id=\"pr0_bloodcolldate\"]")).sendKeys(date);

WebUI.setText(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/Plasma Volume Observed Text Box'), '5')
WebUI.setText(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/Plasma Volume TextBox'), '3')
WebUI.setText(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/Notes TextArea'), 'Notes SingleTubeAccessioning for OMNI-48')

WebUI.setText(findTestObject('Object Repository/LIMS/ResOps Accession/Investigator TextBox'), 'TestInvestigator')

//set patient
WebUI.click(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/PatientLookup'))

WebUI.switchToWindowIndex(1)

item = By.id("GHPatientSearch_arg2");
wait.until(ExpectedConditions.visibilityOfElementLocated(item));
wait.until(ExpectedConditions.elementToBeClickable(item));

driver.findElement(item).clear();
driver.findElement(item).sendKeys('Validation 8');

item = By.xpath("//*[@id='argsdiv_GHPatientSearch']/fieldset/table/tbody/tr[11]/td/button");
wait.until(ExpectedConditions.visibilityOfElementLocated(item));
wait.until(ExpectedConditions.elementToBeClickable(item));
driver.findElement(item).click();

WebUI.switchToFrame(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/ProjectID_PopUp/list_iframe'), 10)
item = By.partialLinkText("3907964");
wait = new WebDriverWait(driver, 80);

wait.until(ExpectedConditions.visibilityOfElementLocated(item));
wait.until(ExpectedConditions.elementToBeClickable(item));
driver.findElement(item).click();

WebUI.switchToWindowIndex(0);
WebUI.waitForPageLoad(6);

WebUI.switchToFrame(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/maint_iframe'), 3)

WebUI.setText(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/Customer Tube ID TextBox'), '986743493')

Calendar cal1 = Calendar.getInstance();
SimpleDateFormat ds1 = new SimpleDateFormat("yyyyMMddhhmmss");
String sampleID = ds1.format(cal1.getTime());

WebUI.setText(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/Customer Sample ID'), sampleID)
WebUI.setText(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/Study ID TextBox'), 'SQATest00')

WebUI.setText(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/Visit Name TextBox'), 'SQATestVisitName')

WebUI.setText(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/Pregnancy Transplant TextArea'), 'PregancyTransplant Text')
WebUI.setText(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/Description TextBox'), 'Description Text')
WebUI.setText(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/Prior Therapy Information TextArea'), 'PriorTherapy Text')
WebUI.setText(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/Batch Group ID TextArea'), 'CP_05082018')
WebUI.switchToDefaultContent();
WebUI.click(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/Save Button'))
WebUI.waitForPageLoad(6);
Thread.sleep(2000);
WebUI.waitForElementClickable(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/Create Accession Button'), 30)
WebUI.click(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/Create Accession Button'))
 
item = By.xpath("//button[contains(text(),'OK')]");
wait = new WebDriverWait(driver, 80);

wait.until(ExpectedConditions.visibilityOfElementLocated(item));
wait.until(ExpectedConditions.elementToBeClickable(item));
driver.findElement(item).click();

WebUI.click(findTestObject('Object Repository/LIMS/logout/img'))
WebUI.closeBrowser()
