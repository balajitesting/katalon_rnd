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

import org.junit.After
import org.openqa.selenium.By as By
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;

WebUI.comment('ENTSW-TC-3409')

String reagentLotId = '900'

CustomKeywords.'com.gh.db.LimsDBDataReset.deleteReagentLot'(reagentLotId)

CustomKeywords.'com.gh.lims.Common.logon'('ResOpsRhea', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/Controls/NewReagentLot/trmStop_NewReagentLots'))

WebUI.click(findTestObject('LIMS/Controls/NewReagentLot/btn_AddNewReagentLot'))

WebUI.switchToFrame(findTestObject('LIMS/Requests/DV2/Page_DV2/maint_iframe'), 10)

WebUI.setText(findTestObject('LIMS/Controls/NewReagentLot/input_GHPartNo'), 'GHM0074')

WebUI.click(findTestObject('LIMS/Controls/NewReagentLot/img_ReagentType'))

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.gh.lims.Common.switchToWindows'(driver)

CustomKeywords.'com.gh.lims.Common.selectValueInPopUp'('AIO')

WebUI.switchToDefaultContent()

WebUI.switchToFrame(findTestObject('LIMS/Requests/DV2/Page_DV2/maint_iframe'), 10)

WebUI.setText(findTestObject('LIMS/Controls/NewReagentLot/input_ReagentLot'), reagentLotId)

WebUI.setText(findTestObject('LIMS/Controls/NewReagentLot/input_ExpiryDt'), 'Nov 30, 2019')

WebUI.setText(findTestObject('LIMS/Controls/NewReagentLot/input_StorageTemp'), '-20')

WebUI.setText(findTestObject('LIMS/Controls/NewReagentLot/input_Amount'), '27uL')

WebUI.setText(findTestObject('LIMS/Controls/NewReagentLot/input_ControlName'), 'A5-Bulk1')

WebUI.setText(findTestObject('LIMS/Controls/NewReagentLot/input_ManufactureDt'), 'Nov 20, 2018')

WebUI.setText(findTestObject('LIMS/Controls/NewReagentLot/input_Concentration'), '1.4ng/uL')

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/Plasma_Isolation/SampleStorage/btn_Save'))

Thread.sleep(3000) //Wait command is not working properly. Hence, implemented the same.

WebUI.setText(findTestObject('LIMS/PostSequence/TBReview/Search/input_Search_searchtext'), reagentLotId)

WebUI.click(findTestObject('LIMS/PostSequence/TBReview/Search/td_OK'))

Thread.sleep(3000) //Wait command is not working properly. Hence, implemented the same.

WebUI.switchToFrame(findTestObject('LIMS/Requests/AllRequests/list_iFrame'), 3)

assert WebUI.getText(findTestObject('LIMS/Controls/NewReagentLot/column_ReagentLot')).contains(reagentLotId) == true

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/logout/img_Logout'))

WebUI.closeBrowser()
