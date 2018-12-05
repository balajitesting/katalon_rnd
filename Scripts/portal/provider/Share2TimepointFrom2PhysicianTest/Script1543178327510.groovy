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

import org.junit.After
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.common.WebUiCommonHelper

import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory


WebUI.comment('Run: ENTSW-TC-2921')

CustomKeywords.'com.gh.portal.Common.logon'('skopetz@mdanderson.org', 'R9dwWsVuqf0RB1p2unfSZQ==')

CustomKeywords.'com.gh.portal.Provider.shareReportToPhysician'('2205526', 'kimberly', 'schlesinger', 'kimberly.schlesinger@rivhs.com')

CustomKeywords.'com.gh.portal.Common.logon'('kimberly.schlesinger@rivhs.com', 'R9dwWsVuqf0RB1p2unfSZQ==')

CustomKeywords.'com.gh.portal.Provider.verifyTrm'('2205526', 'A92332')

WebDriver driver = DriverFactory.getWebDriver();

String date = 'SEP-29-2017'

List<WebElement> elements = driver.findElements(By.cssSelector("text.tumor-response-map__x-label-text"));
for (WebElement ele: elements) {         
    if(ele.getText().equals(date)){
         ele.click();
     }
}

CustomKeywords.'com.gh.portal.Provider.verifyTrm2'('2205526', 'A73393')

CustomKeywords.'com.gh.portal.Common.logout'()

WebUI.closeBrowser()
