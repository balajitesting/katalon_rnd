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

WebUI.comment('ENTSW-TC-2881')

'Enable when run this test alone'
String sampleID = 'A010001401'

//reset Sample Status back to ready for DNA Extraction
CustomKeywords.'com.gh.db.LimsDBDataReset.resetSampleStatus'(sampleID, 'Ready for DNA Extraction')

//User Login
CustomKeywords.'com.gh.lims.Common.logon'('ResOpsRhea', '5Ed5CIkj9UQfaMZXAkDVaQ==')

//Search sample ID 
WebUI.click(findTestObject('LIMS/Pre Sequencing/DNAExtractionTramStop'))
WebUI.setText(findTestObject('LIMS/Pre Sequencing/DNA Extraction/Page_Ready For DNA Extraction/Search_Textbox'), sampleID)
WebUI.click(findTestObject('LIMS/Pre Sequencing/DNA Extraction/Page_Ready For DNA Extraction/Search_OK_Button'))
WebUI.switchToFrame(findTestObject('LIMS/Pre Sequencing/DNA Extraction/Page_Ready For DNA Extraction/list_iframe'), 2)
WebUI.click(findTestObject('LIMS/Pre Sequencing/DNA Extraction/Page_Ready For DNA Extraction/samplelist_header_CheckBox'))
WebUI.switchToDefaultContent()

//Generate Accession ID CSV
WebUI.verifyElementClickable(findTestObject('LIMS/Pre Sequencing/DNA Extraction/Page_Ready For DNA Extraction/Generate Accession_ID_CSV_Button'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('LIMS/Pre Sequencing/DNA Extraction/Page_Ready For DNA Extraction/Generate Accession_ID_CSV_Button'))

//Verification
WebUI.waitForPageLoad(6);
WebDriver driver = DriverFactory.getWebDriver();
Thread.sleep(2000)
driver.switchTo().frame("list_iframe");
String msg = driver.findElement(By.xpath("//*[@id='__ruleErrorTable']/tbody/tr[2]/td/table/tbody/tr/td[2]")).getText();
assert msg.contains("Successfully generated CSV file for A010001401") == true	
driver.switchTo().defaultContent();

//Go to In Lab and verify sampleID exist in Lab
WebUI.waitForPageLoad(6);
WebUI.click(findTestObject('Object Repository/LIMS/Pre Sequencing/DNA Extraction/Page_Ready For DNA Extraction/menubar/In Lab Link'))
WebUI.waitForPageLoad(6);

//Search sampleID
WebUI.waitForElementVisible(findTestObject('Object Repository/LIMS/Pre Sequencing/DNA Extraction/Page_Analytics Sample In Lab/Search TextBox'), 10)
WebUI.waitForElementClickable(findTestObject('Object Repository/LIMS/Pre Sequencing/DNA Extraction/Page_Analytics Sample In Lab/Search TextBox'), 30)
WebUI.setText(findTestObject('Object Repository/LIMS/Pre Sequencing/DNA Extraction/Page_Analytics Sample In Lab/Search TextBox'), sampleID)
WebUI.click(findTestObject('Object Repository/LIMS/Pre Sequencing/DNA Extraction/Page_Analytics Sample In Lab/Search OK Button'))

//Verify row exist in In Lab list
WebUI.waitForPageLoad(6);
Thread.sleep(2000);
driver.switchTo().frame("list_iframe");
WebUI.waitForElementVisible(findTestObject('Object Repository/LIMS/Pre Sequencing/DNA Extraction/Page_Analytics Sample In Lab/list_iframe/Selector CheckBox'), 10)
WebUI.click(findTestObject('Object Repository/LIMS/Pre Sequencing/DNA Extraction/Page_Analytics Sample In Lab/list_iframe/Selector CheckBox'))
driver.switchTo().defaultContent();

//Log out
WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/logout/img'), 10)
WebUI.click(findTestObject('Object Repository/LIMS/logout/img'))
WebUI.closeBrowser()

//Verification
/* The following verification has been comment out, this will only work on your local machine when you setup your ssh key to the server. "
 * 
 * Here is the step to setup your own ssh key
 * 
 * $ ssh-keygen -t rsa -b 2048
 * Generating public/private rsa key pair.
 * 	Enter file in which to save the key (/home/username/.ssh/id_rsa): 
 * Enter passphrase (empty for no passphrase): 
 * Enter same passphrase again: 
 * Your identification has been saved in /home/username/.ssh/id_rsa.
 * Your public key has been saved in /home/username/.ssh/id_rsa.pub.
 * 
 * Copy your keys to the target server:
 * $ ssh-copy-id id@10.4.80.97
 * id@10.4.80.97's password: 
 * Now try logging into the machine, with ssh 'id@server', and check in:
 * .ssh/authorized_keys
 * to make sure we haven’t added extra keys that you weren’t expecting.
 * Finally check logging in…
 * $ ssh id@10.4.80.97

 */
//assert CustomKeywords.'com.gh.core.TestUtil.check_ssh_host_file_exist'('/mnt/fserv_LabvantageSQA/Patient Gender CSV/Append.csv') == true

return sampleID