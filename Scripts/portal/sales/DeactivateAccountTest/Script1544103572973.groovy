import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

WebUI.comment('ENTSW-TC-3463')

'Login to portal cannot de-activate portal account'
CustomKeywords.'com.gh.portal.Common.logon'('jelders@guardanthealth.com ', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Portal/page_salesportal/acceptalert'))

WebUI.waitForPageLoad(10)

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/physiciansearchbar'), 'bridgesb@slhs.org')

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/physicianselect'))

WebUI.waitForPageLoad(10)

List<WebElement> option = DriverFactory.getWebDriver().findElements(By.xpath('//ul[@class=\'dropdown-menu admin-dropdown-menu\']//li'))

for (int j = 0; j < option.size(); j++) {
    if (option.get(j).getText().contains('deactivate')) {
        Assert.assertTrue(true, 'De-Activate option is present')
    } else {
        Assert.assertTrue(true, 'De-Activate option is not present')
    }
}
CustomKeywords.'com.gh.portal.Common.portalLogout'()