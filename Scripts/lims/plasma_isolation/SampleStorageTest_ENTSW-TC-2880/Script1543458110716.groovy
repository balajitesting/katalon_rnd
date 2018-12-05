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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

//Sample Storage 
WebUI.comment('Run: ENTSW-TC-2880')

//String aNumber = WebUI.callTestCase(findTestCase('lims/plasma_isolation/PlasmaIsolationCompleteTest_ENTSW-TC-2878_2879'), [:], FailureHandling.STOP_ON_FAILURE)

'Enable when run this test alone'
String sampleID = 'A011760801'

CustomKeywords.'com.gh.db.LimsDBDataReset.resetStorageStatus'(sampleID)

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserDagmar', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/Plasma_Isolation/SampleStorageTramStop'))

WebUI.setText(findTestObject('LIMS/Plasma_Isolation/Page_Plasma Tube List/Search_Textbox'), sampleID)

WebUI.click(findTestObject('LIMS/Plasma_Isolation/Page_Plasma Tube List/Search_OK_Button'))

WebUI.switchToFrame(findTestObject('LIMS/Plasma_Isolation/Page_Plasma Tube List/list_iframe'), 2, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('LIMS/Plasma_Isolation/Page_Plasma Tube List/list_header_CheckBox'))

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/Plasma_Isolation/SampleStorage/btn_CheckIn'))

WebUI.switchToFrame(findTestObject('LIMS/Plasma_Isolation/SampleStorage/iframe_Target'), 10)

WebUI.click(findTestObject('LIMS/Plasma_Isolation/SampleStorage/searchStorage'))

WebUI.delay(3)

WebDriver driver = DriverFactory.getWebDriver()

String winHandleBefore = driver.getWindowHandle();

CustomKeywords.'com.gh.lims.Common.switchToWindows'(driver)

WebUI.delay(1)

WebUI.click(findTestObject('LIMS/Plasma_Isolation/SampleStorage/storageUnitLink'))

WebUI.switchToFrame(findTestObject('LIMS/Plasma_Isolation/SampleStorage/iframe_SelectStorageUnit'), 10)

WebUI.switchToFrame(findTestObject('LIMS/Plasma_Isolation/SampleStorage/iframe_SelectStorageList'), 10)

WebUI.click(findTestObject('LIMS/Plasma_Isolation/SampleStorage/selectFreezerLink'))

WebUI.click(findTestObject('LIMS/Plasma_Isolation/SampleStorage/selectShelfLink'))

WebUI.click(findTestObject('LIMS/Plasma_Isolation/SampleStorage/selectRackLink'))

WebUI.click(findTestObject('LIMS/Plasma_Isolation/SampleStorage/selectBoxLink'))

WebUI.click(findTestObject('LIMS/Plasma_Isolation/SampleStorage/selectLocLink'))

driver.switchTo().window(winHandleBefore);

WebUI.switchToFrame(findTestObject('LIMS/Plasma_Isolation/SampleStorage/iframe_Storage'), 10)

WebUI.click(findTestObject('LIMS/Plasma_Isolation/SampleStorage/checkbox_Sample'))

WebUI.delay(1)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/Plasma_Isolation/SampleStorage/btn_AutoFile'))

WebUI.delay(1)

WebUI.click(findTestObject('LIMS/Plasma_Isolation/SampleStorage/btn_Save'))

WebUI.delay(1)

WebUI.click(findTestObject('LIMS/Plasma_Isolation/SampleStorage/tab_SampleStorage'))

WebUI.setText(findTestObject('LIMS/Plasma_Isolation/Page_Plasma Tube List/Search_Textbox'), sampleID)

WebUI.click(findTestObject('LIMS/Plasma_Isolation/Page_Plasma Tube List/Search_OK_Button'))

WebUI.switchToFrame(findTestObject('LIMS/Requests/AllRequests/list_iFrame'), 3)

WebUI.delay(1)

assert WebUI.getText(findTestObject('LIMS/Plasma_Isolation/SampleStorage/btn_Box')).contains("SU-0000103511") == true

assert WebUI.getText(findTestObject('LIMS/Plasma_Isolation/SampleStorage/btn_Location')).contains("/Freezer-80C_#42_0234/Shelf4/Rack7/Box15/LocE5") == true

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/logout/img_Logout'))

WebUI.closeBrowser()

return sampleID