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

WebUI.comment('Run: ENTSW-TC-2922')

String strFirstName = 'Xu' + CustomKeywords.'com.gh.core.TestUtil.getRandom'()

String strLastName = 'Joes' + CustomKeywords.'com.gh.core.TestUtil.getRandom'()

println(strLastName)

String strEmailAddress = ('newPortal' + CustomKeywords.'com.gh.core.TestUtil.getRandom'()) + '@gmail.com'

CustomKeywords.'com.gh.portal.Common.logon'('mary_fidler@rush.edu', 'R9dwWsVuqf0RB1p2unfSZQ==')

CustomKeywords.'com.gh.portal.Provider.shareReportToPhysician'('Rey', strFirstName, strLastName, strEmailAddress)

CustomKeywords.'com.gh.portal.Common.logout'()

WebUI.closeBrowser()

CustomKeywords.'com.gh.portal.Common.mailTrapLogin'('bkotta@guardanthealth.com', 'Balu@1981')

def sender = 'Portal/page_mailtrap/page_portalmailtrap/patientmenu_mary'

CustomKeywords.'com.gh.portal.Common.checkMailTrap'(strEmailAddress, sender)

CustomKeywords.'com.gh.portal.Provider.acceptInvitation'('Abcd1234')

WebUI.verifyElementPresent(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/searchguestpatientname'), 5)

WebUI.verifyElementPresent(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/reportstableview'), 5)

Thread.sleep(1000)

WebUI.verifyElementPresent(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/csvdownloadlink'), 5)

CustomKeywords.'com.gh.portal.Common.logon'(strEmailAddress, 'tE+PEiSUqqgo23gg3D+W7A==')

CustomKeywords.'com.gh.portal.Provider.verifyTrm'('REY')

CustomKeywords.'com.gh.portal.Common.logout'()

WebUI.closeBrowser()