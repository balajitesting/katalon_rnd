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
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By;


WebUI.comment('ENT-6684')

String sampleID = 'A011985601'

String flowcellID_full = '557145_NB501074_0315_AE2ETESTQA'

CustomKeywords.'com.gh.db.BIP_delete.delete_data_sampleID'(sampleID)

CustomKeywords.'com.gh.lims.Common.logon'('cliauserreporting', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('Object Repository/LIMS/PostSequence/BIPUploadBySampleTramStop'))

WebUI.click(findTestObject('Object Repository/LIMS/PostSequence/Page_BipUploadBySample/Upload BIP_Data Button'))

WebDriver driver = DriverFactory.getWebDriver();

//unable to get the katalon to recognize the object, use webdriver class instead.
driver.switchTo().frame("dlg_frame0");
driver.switchTo().frame("promptfields_iframe");
driver.findElement(By.xpath("//*[@id='prompt_arg1']")).clear();
driver.findElement(By.xpath("//*[@id='prompt_arg1']")).sendKeys(sampleID);
	 
//unable to get this to work.switch to use the driver classes
//WebUI.click(findTestObject('Object Repository/LIMS/PostSequence/Page_BipUploadBySample/PopUp/td_OK'))
driver.switchTo().parentFrame();
driver.findElement(By.xpath("//*[@id='okbutton']/table/tbody/tr/td[3]")).click();

Thread.sleep(10000);

WebUI.waitForPageLoad(60);

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()



