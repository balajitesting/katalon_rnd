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

String patientName

String mrnNumber

WebUI.comment('ENTSW-TC-3461')

'Login to portal as a sales user and accept agreement'
CustomKeywords.'com.gh.portal.Common.logon'('jelders@guardanthealth.com ', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Portal/page_salesportal/acceptalert'))

WebUI.waitForPageLoad(10)

WebUI.verifyElementPresent(findTestObject('Portal/page_salesportal/dashboard'), 5)

WebUI.delay(2)

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

WebUI.closeBrowser()

WebUI.comment('ENTSW-TC-3459')

'Login to portal no PHI display on Dashboard'
CustomKeywords.'com.gh.portal.Common.logon'('jelders@guardanthealth.com ', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Portal/page_salesportal/acceptalert'))

WebUI.waitForPageLoad(10)

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/physiciansearchbar'), 'bridgesb@slhs.org')

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/physicianselect'))

WebUI.verifyElementPresent(findTestObject('Portal/page_salesportal/dashboard'), 5)

patientName = WebUI.getText(findTestObject('Portal/page_salesportal/patientname'))

if (patientName.contains('.')) {
    println('No PHI Information is present in dashboard' + patientName)
}

WebUI.waitForPageLoad(10)

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

WebUI.closeBrowser()

WebUI.comment('ENTSW-TC-3460')

'Login to portal no PHI display on patient page'
CustomKeywords.'com.gh.portal.Common.logon'('jelders@guardanthealth.com ', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Portal/page_salesportal/acceptalert'))

WebUI.waitForPageLoad(10)

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/physiciansearchbar'), 'bridgesb@slhs.org')

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/physicianselect'))

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/selectpatient'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Portal/page_portalaccession/tooglepatientname'), 10)

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/tooglepatientname'))

mrnNumber = WebUI.getText(findTestObject('Object Repository/Portal/page_salesportal/mrnnumber'))

WebUI.verifyMatch(mrnNumber, '####', true, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(10)

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

WebUI.closeBrowser()

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
        println('Activate option is present')
    } else {
        println('Activate option is not present')
    }
}

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

WebUI.closeBrowser()

WebUI.comment('ENTSW-TC-3463')

'Login to portal cannot de-activate portal account'
CustomKeywords.'com.gh.portal.Common.logon'('jelders@guardanthealth.com ', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Portal/page_salesportal/acceptalert'))

WebUI.waitForPageLoad(10)

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/physiciansearchbar'), 'bridgesb@slhs.org')

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/physicianselect'))

WebUI.waitForPageLoad(10)

for (int j = 0; j < options.size(); j++) {
    if (options.get(j).getText().contains('deactivate')) {
        println('De-Activate option is present')
    } else {
        println('De-Activate option is not present')
    }
}

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

WebUI.closeBrowser()