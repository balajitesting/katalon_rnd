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

WebUI.comment('Run: ENTSW-TC-3029') 

String strFirstName = 'Xui' + CustomKeywords.'com.gh.core.TestUtil.getRandom'()

String strLastName = 'Joes' + CustomKeywords.'com.gh.core.TestUtil.getRandom'()

String strEmailAddress = ('Nonportal' + CustomKeywords.'com.gh.core.TestUtil.getRandom'()) + '@gmail.com'

CustomKeywords.'com.gh.portal.Common.logon'('venkat.mamillapelli@gmail.com', 'Pa22word')

WebUI.setText(findTestObject('Portal/page_guardanthealth/inputpatientname'), 'Clint')

WebUI.click(findTestObject('Portal/page_guardanthealth/searchpatientname'))

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Portal/page_guardanthealth/sharebutton'))

WebUI.setText(findTestObject('Portal/page_guardanthealth/inputfirstname'), strFirstName)

WebUI.setText(findTestObject('Portal/page_guardanthealth/inputlastname'), strLastName)

WebUI.setText(findTestObject('Portal/page_guardanthealth/inputemailaddress'), strEmailAddress)

WebUI.click(findTestObject('Portal/page_guardanthealth/acceptterms'))

WebUI.click(findTestObject('Portal/page_guardanthealth/invitationbutton'))

WebUI.acceptAlert()

WebUI.waitForPageLoad(10)

WebUI.waitForElementVisible(findTestObject('Portal/page_guardanthealth/confirmationmessage'), 5)

WebUI.waitForPageLoad(10)

WebUI.back()

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Portal/page_guardanthealth/profilemenu'))

WebUI.click(findTestObject('Portal/page_guardanthealth/signout'))

WebUI.closeBrowser()

CustomKeywords.'com.gh.portal.Common.mailTrapLogin'('bkotta@guardanthealth.com', 'Balu@1981')

WebUI.click(findTestObject('Portal/page_mailtrap/page_inboxesmailtrap/spanportal'))

WebUI.setText(findTestObject('Portal/page_mailtrap/page_portalmailtrap/inputemail'), strEmailAddress)

WebUI.verifyElementClickable(findTestObject('Portal/page_mailtrap/page_portalmailtrap/patientmenu'))

WebUI.click(findTestObject('Portal/page_mailtrap/page_portalmailtrap/patientmenu'))

WebUI.click(findTestObject('Portal/page_mailtrap/safeemailtestingpage/externallink'))

WebUI.switchToWindowIndex(1)

WebUI.click(findTestObject('Portal/page_mailtrap/page_portalmailtrap/sharepatientreportbutton'))

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

WebUI.verifyElementPresent(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/csvdownloadlink'), 5)

WebUI.setText(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/searchguestpatientname'), 'Clint')

WebUI.waitForElementClickable(findTestObject('Portal/page_guardanthealth/searchpatientname'), 5)

WebUI.click(findTestObject('Portal/page_guardanthealth/searchpatientname'))

String strActPatient = WebUI.getText(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/verifypatientname'))

Assert.assertEquals(strActPatient, 'LOVEMAN, CLINT', 'Mismatch in PatientName')

WebUI.waitForPageLoad(10)

WebUI.back()

WebUI.waitForPageLoad(10)

WebUI.verifyElementClickable(findTestObject('Portal/page_guardanthealth/profilemenu'))

WebUI.scrollToElement(findTestObject('Portal/page_guardanthealth/profilemenu'), 10)

WebUI.click(findTestObject('Portal/page_guardanthealth/profilemenu'))

WebUI.verifyElementClickable(findTestObject('Portal/page_guardanthealth/signout'))

WebUI.click(findTestObject('Portal/page_guardanthealth/signout'))

WebUI.closeBrowser()