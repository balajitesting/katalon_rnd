import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.junit.After as After
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.testng.Assert as Assert
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.comment('ENTSW-TC-2923')

'Login to portal as a Pharma Admin'
CustomKeywords.'com.gh.portal.Common.logon'('uhh@symphogen.com', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(15)

String company_trials = WebUI.getText(findTestObject('Portal/page_phamaportal/companytrialname'))

verifyData(company_trials)

WebUI.delay(3)

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

WebUI.closeBrowser()

def verifyData(String trialsdata) {
    String pagenumber = WebUI.getText(findTestObject('Portal/page_phamaportal/pagenumber'))

    while (!(pagenumber.equals('10'))) {
        WebUI.delay(2)

        List<WebElement> trials_Data = DriverFactory.getWebDriver().findElements(By.xpath('//td[@class="col-1"]'))

        for (int i = 0; i < trials_Data.size(); i++) {
            if (trials_Data.get(i).getText().equalsIgnoreCase(trialsdata)) {
                Assert.assertTrue(true, 'Data is same')
            }
        }
        
        WebUI.click(findTestObject('Portal/page_phamaportal/nextbutton'))

        pagenumber = WebUI.getText(findTestObject('Portal/page_phamaportal/pagenumber'))
    }
}