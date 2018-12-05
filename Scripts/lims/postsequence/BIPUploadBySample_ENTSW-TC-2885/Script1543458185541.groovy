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
import org.openqa.selenium.By as By
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;



WebUI.comment('ENTSW-TC-2885')

String sampleID = 'A011985601'

CustomKeywords.'com.gh.db.LimsDBDataReset.BIP_delete_by_sampleID'(sampleID)

CustomKeywords.'com.gh.lims.Common.logon'('cliauserreporting', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('Object Repository/LIMS/PostSequence/BIPUploadBySampleTramStop'))

WebUI.click(findTestObject('Object Repository/LIMS/PostSequence/Page_BipUploadBySample/Upload BIP_Data Button'))

WebDriver driver = DriverFactory.getWebDriver()

//unable to get the katalon to recognize the object, use webdriver class instead.
//WebUI.click(findTestObject('Object Repository/LIMS/PostSequence/Page_BipUploadBySample/PopUp/SampleID TextBox'))
driver.switchTo().frame('dlg_frame0')
driver.switchTo().frame('promptfields_iframe')
driver.findElement(By.xpath('//*[@id=\'prompt_arg1\']')).clear()
driver.findElement(By.xpath('//*[@id=\'prompt_arg1\']')).sendKeys(sampleID)

//unable to get the katalon to recognize the object, use webdriver class instead.
//WebUI.click(findTestObject('LIMS/PostSequence/Page_BipUploadBySample/PopUp/OK Button'))
driver.switchTo().parentFrame()
driver.findElement(By.xpath('//*[@id=\'okbutton\']/table/tbody/tr/td[3]')).click()
driver.switchTo().defaultContent();


WebUI.waitForPageLoad(60)

//assert WebUI.getText(findTestObject('Object Repository/LIMS/PostSequence/Page_BipUploadBySample/Operation Successful Text')).contains("Operation Successful") == true
driver.switchTo().frame('list_iframe')
By item = By.xpath("//*[@id='__ruleErrorTable']/tbody/tr[2]/td/table/tbody/tr/td[2]");
WebDriverWait wait = new WebDriverWait(driver, 80);
wait.until(ExpectedConditions.visibilityOfElementLocated(item));

String success = driver.findElement(item).getText();

assert success.contentEquals("Operation Successful") == true;
driver.switchTo().defaultContent();

WebUI.click(findTestObject('Object Repository/LIMS/logout/img'))
WebUI.closeBrowser()



