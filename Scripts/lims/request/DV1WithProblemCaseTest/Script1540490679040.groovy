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

import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.comment('Run: ENT-6677')

'Reset the aNumber status in DV and ProblemCase'

String aNumber = 'A0131242'

CustomKeywords.'com.gh.db.LimsDBDataReset.resetDVStatus'(aNumber, '0')

CustomKeywords.'com.gh.db.LimsDBDataReset.resetProblemCase'(aNumber)

CustomKeywords.'com.gh.lims.Common.logon'('abaca', '5Ed5CIkj9UQfaMZXAkDVaQ==')

'Validation 1: Edit a request in DV‌ and add a problem case'

WebUI.click(findTestObject('LIMS/Requests/DV1/DV1Request/dv1Tram'))

WebUI.click(findTestObject('LIMS/Requests/DV1/DV1Request/GHDVSearchButton'))

WebUI.setText(findTestObject('LIMS/Requests/DV1/DV1Request/dv1SearchTextBox'), aNumber)

WebUI.click(findTestObject('LIMS/Requests/DV1/DV1Request/td_OK'))

CustomKeywords.'com.gh.lims.Common.waitAndClick'('Object Repository/LIMS/ResOps Requests/DV/Edit Button')

//WebUI.click(findTestObject('Object Repository/LIMS/ResOps Requests/DV/Edit Button')))

WebUI.switchToFrame(findTestObject('LIMS/Requests/DV2/Page_DV2/maint_iframe'), 10)

WebUI.click(findTestObject('LIMS/Requests/DV2/Page_DV2/addButton'))

WebUI.click(findTestObject('LIMS/Requests/DV2/Page_DV2/searchProbCaseIcon'))

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.gh.lims.Common.switchToWindows'(driver)

WebUI.delay(1)

CustomKeywords.'com.gh.lims.Common.selectValueInPopUp'('R01')

CustomKeywords.'com.gh.lims.ResOpsRequests.enterESign'('abcd1234')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/LIMS/ResOps Requests/DV/Return To List Button'))

WebUI.delay(1)

'Validation 2: Verify that the request is moved to PC.'

WebUI.click(findTestObject('LIMS/Requests/Problemcases Resolution/tab_ProblemcasesResolution'))

Thread.sleep(1000) //Wait command is not working properly. Hence, implemented the same.

WebUI.setText(findTestObject('LIMS/PostSequence/TBReview/Search/input_Search_searchtext'), aNumber)

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/Search/td_OK'))

Thread.sleep(1000) //Wait command is not working properly. Hence, implemented the same.

WebUI.switchToFrame(findTestObject('LIMS/Requests/AllRequests/list_iFrame'), 3)

assert WebUI.getText(findTestObject('LIMS/Requests/Problemcases Resolution/column_Status')).contains(aNumber) == true

WebUI.closeBrowser()

