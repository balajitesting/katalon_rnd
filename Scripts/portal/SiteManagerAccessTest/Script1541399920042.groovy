import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.sql.Driver as Driver
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

WebUI.comment('ENTSW-TC‌-2926')

String physicianCount

String aNumber

String msg

String limsPatientCount

String portalPatientCount

String accessionId

String shareButton

'Step 1: Should see reports for only their patients'
CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserDagmar', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.waitForPageLoad(5)

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_limsaccession/allrequestbutton'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_limsaccession/allrequestbutton'))

WebUI.waitForPageLoad(5)

if (GlobalVariable.limsUrl.toString().contains('https://lims-sqa.ghdna.io/logon.jsp ')) {
    WebUI.setText(findTestObject('Object Repository/Portal/page_limsaccession/physicianlastname'), 'Porterfield')
} else {
    WebUI.setText(findTestObject('Object Repository/Portal/page_limsaccession/practicename'), 'Loma Linda Cancer Center')
}

WebUI.click(findTestObject('Object Repository/Portal/page_limsaccession/okbutton'))

WebUI.switchToFrame(findTestObject('Object Repository/Portal/page_limsaccession/iframe'), 20)

limsPatientCount = WebUI.getText(findTestObject('Object Repository/Portal/page_limsaccession/patientcount'))

println(limsPatientCount)

aNumber = WebUI.getText(findTestObject('Object Repository/Portal/page_limsaccession/requestid'))

println(aNumber)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/Portal/page_limsaccession/logoff'))

WebUI.closeBrowser()

'Step 4: Should see reports table view'
CustomKeywords.'com.gh.portal.Common.logon'('bejoysitemgr@gmail.com', 'Pa22word')

WebUI.verifyElementPresent(findTestObject('Object Repository/Portal/page_portalaccession/viewtablereport'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/viewtablereport'))

List<WebElement> portalPatientCountList = DriverFactory.getWebDriver().findElements(By.xpath('//tr[contains(@request-id,\'A\')]'))

portalPatientCount = portalPatientCountList.size()

if (limsPatientCount.contains(portalPatientCount)) {
    println('count is same')
}

Thread.sleep(2000)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/dashboardclick'))

WebUI.waitForPageLoad(5)

'Step 5:Should be able to see the patients in patient search bar'
WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/searchid'), aNumber)

WebUI.verifyElementPresent(findTestObject('Object Repository/Portal/page_portalaccession/selectsearch'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/selectsearch'))

Thread.sleep(2000)

WebUI.verifyElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/tooglepatientname'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/tooglepatientname'))

accessionId = WebUI.getText(findTestObject('Object Repository/Portal/page_portalaccession/accessionid'))

WebUI.verifyEqual(aNumber, accessionId)

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

WebUI.closeBrowser()

'Step 6:Should be able to download the CSV for their patients'
CustomKeywords.'com.gh.portal.Common.logon'('bejoysitemgr@gmail.com', 'Pa22word')

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/exportresultscsv'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/csvdownload'))

Thread.sleep(2000)

WebUI.switchToDefaultContent()

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

'Step 7:Should be able to release a patients report with a portal user email address'
CustomKeywords.'com.gh.portal.Common.logon'('bejoysitemgr@gmail.com', 'Pa22word')

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/selectpatient'))

WebUI.waitForPageLoad(10)

WebUI.waitForElementPresent(findTestObject('Object Repository/Portal/page_portalaccession/sharepatientreport'), 10)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/sharepatientreport'))

Thread.sleep(2000)

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/fname'), 'Benjamin')

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/lname'), 'Bridges')

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/portalemail'), 'bridgesb@slhs.org')

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/checkbox'))

WebUI.click(findTestObject('Portal/page_portalaccession/sendtinvitation'))

WebUI.acceptAlert()

WebUI.waitForPageLoad(5)

msg = WebUI.getText(findTestObject('Object Repository/Portal/page_portalaccession/msgconfirm'))

println(msg)

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

WebUI.closeBrowser()

'Validation for portal account that it contains patient of other physician account '
CustomKeywords.'com.gh.portal.Common.logon'('bridgesb@slhs.org', 'Pa22word')

WebUI.waitForPageLoad(5)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Portal/page_portalaccession/sharermsg'), 5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/acceptcheck'))

    WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/acceptinvitation'))
}

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/searchid'), aNumber)

//Thread.sleep(2000)
WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/selectsearch'))

Thread.sleep(2000)

WebUI.verifyElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/tooglepatientname'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/tooglepatientname'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

WebUI.closeBrowser()

'Step 8:Should be able to release a patients report with a non-portal user email address.'
CustomKeywords.'com.gh.portal.Common.logon'('bejoysitemgr@gmail.com', 'Pa22word')

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/selectpatient'))

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/sharepatientreport'))

Thread.sleep(2000)

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/fname'), 'Nonportal')

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/lname'), 'user2')

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/portalemail'), 'nonportaluser2@gmail.com')

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/checkbox'))

WebUI.click(findTestObject('Portal/page_portalaccession/sendtinvitation'))

WebUI.acceptAlert()

Thread.sleep(2000)

WebUI.getText(findTestObject('Object Repository/Portal/page_portalaccession/msgconfirm'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

WebUI.closeBrowser()

'Validation to check that patient present in non portal user'
CustomKeywords.'com.gh.portal.Common.logon'('nonportaluser2@gmail.com', 'Pa22word')

WebUI.waitForPageLoad(5)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Portal/page_portalaccession/sharermsg'), 5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/acceptcheck'))

    WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/acceptinvitation'))
}

WebUI.waitForPageLoad(10)

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/searchid'), aNumber)

Thread.sleep(2000)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/selectsearch'))

WebUI.waitForPageLoad(5)

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/tooglepatientname'), 10)

Thread.sleep(2000)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/tooglepatientname'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

WebUI.closeBrowser()

