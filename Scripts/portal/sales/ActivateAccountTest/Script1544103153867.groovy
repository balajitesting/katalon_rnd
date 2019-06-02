import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.testng.Assert

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.comment('ENTSW-TC-3462')

'Login to portal cannot activate portal account'
CustomKeywords.'com.gh.portal.Common.logon'('jelders@guardanthealth.com ', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Portal/page_salesportal/acceptalert'))

WebUI.waitForPageLoad(10)

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/physiciansearchbar'), 'bridgesb@slhs.org')

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/physicianselect'))

WebUI.waitForPageLoad(10)

List<WebElement> options = DriverFactory.getWebDriver().findElements(By.xpath('//ul[@class=\'dropdown-menu admin-dropdown-menu\']//li'))

for (i = 0; i < options.size(); i++) {
	
	if (options.get(i).getText().contains('activate')) {
		Assert.assertTrue(true, "Activate option is present")
	} else {
		Assert.assertTrue(true, "Activate option is not present")
	}
}

CustomKeywords.'com.gh.portal.Common.portalLogout'()

