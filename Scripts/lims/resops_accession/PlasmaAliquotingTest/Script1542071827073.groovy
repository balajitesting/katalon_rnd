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

WebUI.comment('ENTSW-TC-3007')

String eManifestID = 'E009649'

String value = "//input[@class='search_inputfield']"

CustomKeywords.'com.gh.db.LimsDBDataReset.resetEManifest'(eManifestID)

CustomKeywords.'com.gh.lims.Common.logon'('ResOpsRhea', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('Object Repository/LIMS/ResOps Accession/EManifest SingleTube Accession TramStop'))

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.gh.lims.Common.clearText'(driver, value)

WebUI.sendKeys(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/Search TextBox'), eManifestID)

WebUI.click(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/Search OK Button'))

Thread.sleep(3000) //Wait command is not working properly. Hence, implemented the same.

WebUI.switchToFrame(findTestObject('LIMS/Requests/AllRequests/list_iFrame'), 3)

WebUI.click(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/eManifestCheckbox'))

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/Problem Resolution/Page_Problem Cases Resolution/div_Edit'))

WebUI.switchToFrame(findTestObject('LIMS/Requests/DV2/Page_DV2/maint_iframe'), 10)

WebUI.click(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/maint_iframe/verifiedCheckbox'))

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/Plasma_Isolation/SampleStorage/btn_Save'))

Thread.sleep(2000); //Wait command is not working properly. Hence, implemented the same.

WebUI.click(findTestObject('Object Repository/LIMS/ResOps Requests/DV/Return To List Button'))

CustomKeywords.'com.gh.lims.Common.clearText'(driver, value)

WebUI.sendKeys(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/Search TextBox'), eManifestID)

WebUI.click(findTestObject('Object Repository/LIMS/ResOps Accession/Page_EManifest SingleTube Accession/Search OK Button'))

Thread.sleep(3000) //Wait command is not working properly. Hence, implemented the same.

WebUI.switchToFrame(findTestObject('LIMS/Requests/AllRequests/list_iFrame'), 3)

WebUI.click(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/eManifestCheckbox'))

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/btn_Pool'))

CustomKeywords.'com.gh.lims.Common.switchToWindows'(driver)

Thread.sleep(2000)

String A_Number = WebUI.getText(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/poolMsg')).substring(29, 38).trim()

assert WebUI.getText(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/poolMsg')).contains(eManifestID) == true

WebUI.click(findTestObject('LIMS/ResOps Accession/Page_EManifest SingleTube Accession/btn_OK'))

WebUI.click(findTestObject('LIMS/Header/img_AllTram'))

//String A_Number = 'A0131202'

'Create Aliquot under Resops -> All Request'
	
WebUI.click(findTestObject('LIMS/Home/ResopsAllRequests'))

WebUI.setText(findTestObject('LIMS/PostSequence/TBReview/Search/input_Search_searchtext'), A_Number)

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/Search/td_OK'))

Thread.sleep(2000)

WebUI.click(findTestObject('LIMS/Problem Resolution/Page_Problem Cases Resolution/div_Edit'))

Thread.sleep(2000)

WebUI.click(findTestObject('LIMS/ResOps Requests/AllRequests/img_CreateAliquot'))

Thread.sleep(2000)

CustomKeywords.'com.gh.lims.Common.switchToWindows'(driver)

Thread.sleep(2000)

WebUI.switchToFrame(findTestObject('LIMS/ResOps Requests/AllRequests/iframe_CreateAliquot'), 3)

Thread.sleep(2000)

WebUI.selectOptionByValue(findTestObject('LIMS/ResOps Requests/AllRequests/selectSample'), A_Number + '01', true)

WebUI.setText(findTestObject('LIMS/ResOps Requests/AllRequests/txtbox_Volume'), '2')

WebUI.click(findTestObject('LIMS/ResOps Requests/AllRequests/btn_OK'))
	
WebUI.closeBrowser()
