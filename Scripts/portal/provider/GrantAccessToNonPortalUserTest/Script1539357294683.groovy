import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import javax.swing.plaf.basic.BasicButtonListener.Actions as Actions
import org.junit.After as After
import org.testng.Assert as Assert
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

WebUI.comment('Run: ENTSW-TC-3029, ENTSW-TC-2922') 

String strFirstName = 'Xui' + CustomKeywords.'com.gh.core.TestUtil.getRandom'()

String strLastName = 'Joes' + CustomKeywords.'com.gh.core.TestUtil.getRandom'()

println strLastName

String strEmailAddress = ('Nonportal' + CustomKeywords.'com.gh.core.TestUtil.getRandom'()) + '@gmail.com'

CustomKeywords.'com.gh.portal.Common.logon'('gracesitemgr@gmail.com', 'R9dwWsVuqf0RB1p2unfSZQ==')
//CustomKeywords.'com.gh.portal.Common.logon'('venkat.mamillapelli@gmail.com', 'R9dwWsVuqf0RB1p2unfSZQ==')

CustomKeywords.'com.gh.portal.Provider.shareReportToPhysician'('LINDA', strFirstName, strLastName, strEmailAddress)

CustomKeywords.'com.gh.portal.Common.logout'()

WebUI.closeBrowser()

CustomKeywords.'com.gh.portal.Common.mailTrapLogin'('bkotta@guardanthealth.com', 'Balu@1981')

WebUI.click(findTestObject('Portal/page_mailtrap/page_inboxesmailtrap/spanportal'))

WebUI.setText(findTestObject('Portal/page_mailtrap/page_portalmailtrap/inputemail'), strEmailAddress)

WebUI.verifyElementClickable(findTestObject('Portal/page_mailtrap/page_portalmailtrap/patientmenu'))

WebUI.click(findTestObject('Portal/page_mailtrap/page_portalmailtrap/patientmenu'))

WebUI.click(findTestObject('Portal/page_mailtrap/safeemailtestingpage/externallink'))

WebUI.switchToWindowIndex(1)

WebUI.click(findTestObject('Portal/page_mailtrap/page_portalmailtrap/sharepatientreportbutton'))

WebUI.waitForPageLoad(10)
WebUI.switchToWindowIndex(2)

WebUI.click(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/nextbutton'))

WebUI.setText(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/userpassword'), 'Abcd1234')

WebUI.click(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/accepterm'))

WebUI.click(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/portalaccountbutton'))

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/acceptcheckbox'))

WebUI.click(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/buttonacceptinvitation'))

WebUI.verifyElementPresent(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/searchguestpatientname'), 5)

WebUI.verifyElementPresent(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/reportstableview'), 5)

Thread.sleep(1000)
WebUI.verifyElementPresent(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/csvdownloadlink'), 5)

WebUI.setText(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/searchguestpatientname'), 'LINDA')

WebUI.waitForElementClickable(findTestObject('Portal/page_guardanthealth/searchpatientname'), 5)

WebUI.click(findTestObject('Portal/page_guardanthealth/searchpatientname'))

String strActPatient = WebUI.getText(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/verifypatientname'))

Assert.assertEquals(strActPatient, 'FORTIER, LINDA', 'Mismatch in PatientName')

WebUI.waitForPageLoad(10)

WebUI.back()

WebUI.waitForPageLoad(10)

WebUI.verifyElementClickable(findTestObject('Portal/page_guardanthealth/profilemenu'))

WebUI.scrollToElement(findTestObject('Portal/page_guardanthealth/profilemenu'), 10)

WebUI.click(findTestObject('Portal/page_guardanthealth/profilemenu'))

WebUI.verifyElementClickable(findTestObject('Portal/page_guardanthealth/signout'))

WebUI.click(findTestObject('Portal/page_guardanthealth/signout'))

WebUI.closeBrowser()