
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
import org.junit.After
import org.openqa.selenium.By as By
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.configuration.RunConfiguration as RC
WebUI.comment('ENTSW-TC-3404, ENTSW-TC-3407')


String runningProfile = RC.getExecutionProfile()
//Resetting the Billing Status
String requestID = "";

if (runningProfile.equals("default"))
{
	requestID = 'A0128028'
}
else if (runningProfile.equals("VAL"))
{
	requestID = 'A0130841'
}

CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserReporting', '5Ed5CIkj9UQfaMZXAkDVaQ==')

//check to see if requestID is MSI_HIGH sample
boolean ismsi_high = CustomKeywords.'com.gh.db.LimsDBOperation.isMSIHigh'(requestID)
assert ismsi_high == true

String sql = "select analysisversion from u_ghboard where sampleid like '"+requestID+"%'";
String analysisversion = CustomKeywords.'com.gh.db.LimsDBOperation.getValue'(sql);
double tmp1 = Double.parseDouble(analysisversion);

assert tmp1 >= 3.7;

//CustomKeywords.'com.gh.db.LimsDBDataReset.resetRequestStatus'(requestID, 'LD Review BIP Data')

CustomKeywords.'com.gh.lims.Report.searchRequest'(requestID)
Thread.sleep(1000);
WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_All Requests/select_TB Review BIP DataLD Re'), 60)
WebUI.selectOptionByValue(findTestObject('LIMS/DCO/Report/Page_All Requests/select_TB Review BIP DataLD Re'),
	'LD Review BIP Data', true)

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_All Requests/td_Save'), 60)
WebUI.click(findTestObject('LIMS/DCO/Report/Page_All Requests/td_Save'))
Thread.sleep(1000)
WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_All Requests/a_LD Review'), 60)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_All Requests/a_LD Review'))

WebUI.setText(findTestObject('LIMS/DCO/Report/Page_Request List for LD Review/input_searchtext'), requestID)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Request List for LD Review/td_OK'))

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_Request List for CLS Review/td_Begin Workflow'), 60)
Thread.sleep(2000)
WebUI.click(findTestObject('LIMS/DCO/Report/Page_Request List for CLS Review/td_Begin Workflow'))


sql = "select patientdob from u_ghpatient where u_ghpatientid = (select u_ghpatientid from s_request where s_requestid = '"+requestID+"')";
String patientdob = CustomKeywords.'com.gh.db.LimsDBOperation.getValue'(sql);
if (patientdob == null)
{
	WebUI.waitForElementVisible(findTestObject('Object Repository/LIMS/Reporting/LD Review/button_OK'), 60)
	WebUI.click(findTestObject('Object Repository/LIMS/Reporting/LD Review/button_OK'))
	Thread.sleep(1000)
}


//Thread.sleep(20000);


if (CustomKeywords.'com.gh.db.LimsDBOperation.isLDReviewShow'(requestID, "CNV") == true) {
	if (CustomKeywords.'com.gh.db.LimsDBOperation.getGHBOARDReview'("CNVCALL", requestID).equals("REVIEW")) {
		WebUI.waitForElementVisible(findTestObject('Object Repository/LIMS/Reporting/LD Review/button_OK'), 60)
		WebUI.click(findTestObject('Object Repository/LIMS/Reporting/LD Review/button_OK'))
		Thread.sleep(1000);
	}
	WebUI.click(findTestObject('LIMS/DCO/Report/Page_CNV/div_SNV Review'))
}

if (CustomKeywords.'com.gh.db.LimsDBOperation.isLDReviewShow'(requestID, "SNV") == true) {

	if (CustomKeywords.'com.gh.db.LimsDBOperation.getGHBOARDReview'("SNVCALL", requestID).equals("REVIEW")) {
		WebUI.waitForElementVisible(findTestObject('Object Repository/LIMS/Reporting/LD Review/button_OK'), 60)
		WebUI.click(findTestObject('Object Repository/LIMS/Reporting/LD Review/button_OK'))
		Thread.sleep(1000);
	}
	WebUI.click(findTestObject('LIMS/DCO/Report/Page_SNV/td_Fusion Review'))

}

if (CustomKeywords.'com.gh.db.LimsDBOperation.isLDReviewShow'(requestID, "FUSION") == true) {
	if (CustomKeywords.'com.gh.db.LimsDBOperation.getGHBOARDReview'("FUSIONCALL", requestID).equals("REVIEW")) {
		WebUI.waitForElementVisible(findTestObject('Object Repository/LIMS/Reporting/LD Review/button_OK'), 60)
		WebUI.click(findTestObject('Object Repository/LIMS/Reporting/LD Review/button_OK'))
		Thread.sleep(1000);
	}
	WebUI.click(findTestObject('LIMS/DCO/Report/Page_FUSION/div_Indel Review'))

}


if (CustomKeywords.'com.gh.db.LimsDBOperation.isLDReviewShow'(requestID, "INDEL") == true) {
	if (CustomKeywords.'com.gh.db.LimsDBOperation.getGHBOARDReview'("INDELCALL", requestID).equals("REVIEW")) {
		WebUI.waitForElementVisible(findTestObject('Object Repository/LIMS/Reporting/LD Review/button_OK'), 60)
		WebUI.click(findTestObject('Object Repository/LIMS/Reporting/LD Review/button_OK'))
		Thread.sleep(1000);
	}
}
WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_INDEL/div_MSI Review'), 30)
WebUI.click(findTestObject('LIMS/DCO/Report/Page_INDEL/div_MSI Review'))

if (CustomKeywords.'com.gh.db.LimsDBOperation.isMSISample'(requestID))
{
	//IN MSI review page.
	WebUI.click(findTestObject('Object Repository/LIMS/Reporting/LD Review/MSI Final Review'))
}



WebDriver driver = DriverFactory.getWebDriver();
Thread.sleep(2000)
driver.switchTo().frame("maint_iframe");
String msg = driver.findElement(By.xpath("//textarea[@id='pr0_comments']")).getText();
System.out.println(msg);
assert msg.equals("Mircrosatellite status: MSI-High DETECTED Microsatellite instability was detected in this sample. This finding is associated with increased efficacy of checkpoint inhibitors in multiple tumor types. The FDA has approved therapies for use in this indication.") == true
driver.switchTo().defaultContent();

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_Select_Addendum/select_FINALAMENDEDCORRECTEDAD'), 180)

WebUI.selectOptionByValue(findTestObject('LIMS/DCO/Report/Page_Select_Addendum/select_FINALAMENDEDCORRECTEDAD'),
	'ADDENDUM', true)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/td_Generate Report'))

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_gen_rep'), 120)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Edit GHReportInfo/button_OK_gen_rep'))



//search 
Thread.sleep(3000)
WebUI.click(findTestObject('LIMS/DCO/Report/Page_All Requests/a_CLS Review'))

WebUI.setText(findTestObject('LIMS/DCO/Report/Page_Request List for CLS Review/input_searchtext'), requestID)

WebUI.click(findTestObject('LIMS/DCO/Report/Page_Request List for CLS Review/td_OK'))
///CLS workflow

WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_Request List for CLS Review/td_Begin Workflow'), 60)
Thread.sleep(2000)
WebUI.click(findTestObject('LIMS/DCO/Report/Page_Request List for CLS Review/td_Begin Workflow'))





if (CustomKeywords.'com.gh.db.LimsDBOperation.isCLSReviewShow'(requestID, "CNV") == true) {
	if (CustomKeywords.'com.gh.db.LimsDBOperation.getGHBOARDReview'("CNVCALL", requestID).equals("REVIEW")) {
		WebUI.waitForElementVisible(findTestObject('Object Repository/LIMS/Reporting/LD Review/button_OK'), 60)
		WebUI.click(findTestObject('Object Repository/LIMS/Reporting/LD Review/button_OK'))
		Thread.sleep(1000);
	}
	WebUI.click(findTestObject('LIMS/DCO/Report/Page_CNV/div_SNV Review'))
}

if (CustomKeywords.'com.gh.db.LimsDBOperation.isCLSReviewShow'(requestID, "SNV") == true) {

	if (CustomKeywords.'com.gh.db.LimsDBOperation.getGHBOARDReview'("SNVCALL", requestID).equals("REVIEW")) {
		WebUI.waitForElementVisible(findTestObject('Object Repository/LIMS/Reporting/LD Review/button_OK'), 60)
		WebUI.click(findTestObject('Object Repository/LIMS/Reporting/LD Review/button_OK'))
		Thread.sleep(1000);
	}
	WebUI.click(findTestObject('LIMS/DCO/Report/Page_SNV/td_Fusion Review'))

}

if (CustomKeywords.'com.gh.db.LimsDBOperation.isCLSReviewShow'(requestID, "FUSION") == true) {
	if (CustomKeywords.'com.gh.db.LimsDBOperation.getGHBOARDReview'("FUSIONCALL", requestID).equals("REVIEW")) {
		WebUI.waitForElementVisible(findTestObject('Object Repository/LIMS/Reporting/LD Review/button_OK'), 60)
		WebUI.click(findTestObject('Object Repository/LIMS/Reporting/LD Review/button_OK'))
		Thread.sleep(1000);
	}
	WebUI.click(findTestObject('LIMS/DCO/Report/Page_FUSION/div_Indel Review'))

}


if (CustomKeywords.'com.gh.db.LimsDBOperation.isCLSReviewShow'(requestID, "INDEL") == true) {
	if (CustomKeywords.'com.gh.db.LimsDBOperation.getGHBOARDReview'("INDELCALL", requestID).equals("REVIEW")) {
		WebUI.waitForElementVisible(findTestObject('Object Repository/LIMS/Reporting/LD Review/button_OK'), 60)
		WebUI.click(findTestObject('Object Repository/LIMS/Reporting/LD Review/button_OK'))
		Thread.sleep(1000);
	}
}

if (CustomKeywords.'com.gh.db.LimsDBOperation.isCLSReviewShow'(requestID, "INDEL") == true) {
	WebUI.waitForElementVisible(findTestObject('LIMS/DCO/Report/Page_INDEL/div_MSI Review'), 30)
	WebUI.click(findTestObject('LIMS/DCO/Report/Page_INDEL/div_MSI Review'))
}

if (CustomKeywords.'com.gh.db.LimsDBOperation.isMSISample'(requestID))
{
	//IN MSI review page.
	WebUI.click(findTestObject('Object Repository/LIMS/Reporting/LD Review/MSI Final Review'))
}

Thread.sleep(2000)
//WebDriver driver = DriverFactory.getWebDriver();
driver.switchTo().frame("maint_iframe");
msg = driver.findElement(By.xpath("//textarea[@id='pr0_comments']")).getText();
assert msg.equals("Mircrosatellite status: MSI-High DETECTED Microsatellite instability was detected in this sample. This finding is associated with increased efficacy of checkpoint inhibitors in multiple tumor types. The FDA has approved therapies for use in this indication.") == true
driver.switchTo().defaultContent();

Thread.sleep(2000)

WebUI.waitForElementPresent(findTestObject('LIMS/logout/img'), 10)
WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()


