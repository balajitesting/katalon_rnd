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
import org.testng.Assert as Assert

WebUI.comment('Run: ENTSW-TC-3247')

CustomKeywords.'com.gh.portal.Common.logon'('bridgesb@slhs.org', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(10)

WebUI.verifyElementPresent(findTestObject('Portal/page_guardanthealth/reportstableview'), 5)

WebUI.setText(findTestObject('Portal/page_guardanthealth/inputpatientname'), 'LYSA')

WebUI.waitForElementClickable(findTestObject('Portal/page_guardanthealth/searchpatientname'), 5)

WebUI.click(findTestObject('Portal/page_guardanthealth/searchpatientname'))

WebUI.waitForPageLoad(10)

String strActPatient = WebUI.getText(findTestObject('Portal/page_guardanthealth/verifypatientname'))

Assert.assertEquals(strActPatient, 'MCAFEE, LYSA', 'Mismatch in PatientName')

WebUI.verifyElementVisible(findTestObject('Object Repository/Portal/page_guardanthealth/trmimage'))

WebUI.waitForPageLoad(10)

WebUI.back()

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Portal/page_guardanthealth/profilemenu'))

WebUI.verifyElementClickable(findTestObject('Portal/page_guardanthealth/signout'))

WebUI.click(findTestObject('Portal/page_guardanthealth/signout'))

WebUI.closeBrowser()