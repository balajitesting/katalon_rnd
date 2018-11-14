import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.sql.Driver as Driver
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
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent

WebUI.comment('ENTSW-TC-3257')

'Login to portal as a Activated Physician'
CustomKeywords.'com.gh.portal.Common.logon'('bridgesb@slhs.org', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/exportresultscsv'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Portal/page_portalaccession/csvdownload'), 10)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/csvdownload'))

WebUI.waitForPageLoad(10)

WebUI.delay(5)

handlingWindowPopup()

WebUI.waitForElementPresent(findTestObject('Object Repository/Portal/page_portalaccession/exportresultscsv'), 120)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/exportresultscsv'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Portal/page_exportresult/pdfdownload'), 120)

WebUI.click(findTestObject('Object Repository/Portal/page_exportresult/pdfdownload'))

WebUI.delay(10)

handlingWindowPopup()

WebUI.waitForElementPresent(findTestObject('Object Repository/Portal/page_portalaccession/exportresultscsv'), 120)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/exportresultscsv'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Portal/page_exportresult/xmldownload'), 120)

WebUI.click(findTestObject('Object Repository/Portal/page_exportresult/xmldownload'))

WebUI.waitForPageLoad(10)

WebUI.delay(10)

handlingWindowPopup()

WebUI.click(findTestObject('Portal/page_exportresult/patientdownloadimagedashboard'))

WebUI.click(findTestObject('Portal/page_exportresult/patientreportonly'))

WebUI.delay(5)

handlingWindowPopup()

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/selectpatient'), 20)

WebUI.refresh()

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/selectpatient'))

WebUI.waitForPageLoad(20)

WebUI.delay(1)

WebUI.waitForElementClickable(findTestObject('Portal/page_exportresult/patientdownloadimage'), 20)

WebUI.click(findTestObject('Portal/page_exportresult/patientdownloadimage'))

WebUI.click(findTestObject('Portal/page_exportresult/patientreportonly'))

WebUI.delay(5)

handlingWindowPopup()

WebUI.verifyElementPresent(findTestObject('Portal/page_inprogressreport/profilemenu'), 10)

WebUI.click(findTestObject('Portal/page_inprogressreport/profilemenu'))

WebUI.click(findTestObject('Portal/page_inprogressreport/signout'))

WebUI.closeBrowser()

def handlingWindowPopup() {
    Robot rb = new Robot()

    rb.keyPress(KeyEvent.VK_ENTER)

    WebUI.delay(2)

    rb.keyPress(KeyEvent.VK_TAB)

    rb.keyPress(KeyEvent.VK_ENTER)
}