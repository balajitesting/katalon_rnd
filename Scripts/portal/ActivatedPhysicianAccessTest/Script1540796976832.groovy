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

WebUI.comment('ENTSW-TC‌-2927')

String physicianCount

String aNumber

String msg

String limsPatientCount

String portalPatientCount

String accessionId

String shareButton

String gmail='bridgesb@slhs.org'
'Step 1: Should see reports for only their patients'
CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserDagmar', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.waitForPageLoad(5)

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_limsaccession/allrequestbutton'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_limsaccession/allrequestbutton'))

WebUI.waitForPageLoad(5)

WebUI.setText(findTestObject('Object Repository/Portal/page_limsaccession/physicianlastname'), 'feng')

WebUI.setText(findTestObject('Object Repository/Portal/page_limsaccession/practicename'), 'UH Seidman - Thoracic Oncology')

WebUI.click(findTestObject('Object Repository/Portal/page_limsaccession/okbutton'))

WebUI.switchToFrame(findTestObject('Object Repository/Portal/page_limsaccession/iframe'), 20)

limsPatientCount = WebUI.getText(findTestObject('Object Repository/Portal/page_limsaccession/patientcount'))

println(limsPatientCount)

aNumber = WebUI.getText(findTestObject('Object Repository/Portal/page_limsaccession/requestid'))

println(aNumber)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/Portal/page_limsaccession/logoff'))

'Step 4: Should see reports table view'
CustomKeywords.'com.gh.portal.Common.logon'('yan.feng@uhhospitals.org', 'Pa22word')

WebUI.verifyElementPresent(findTestObject('Object Repository/Portal/page_portalaccession/viewtablereport'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/viewtablereport'))

List<WebElement> portalPatientCountList = DriverFactory.getWebDriver().findElements(By.xpath('//tr[contains(@request-id,\'A\')]'))

portalPatientCount = portalPatientCountList.size()

if (limsPatientCount.contains(portalPatientCount)) {
    println('çount is same')
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
CustomKeywords.'com.gh.portal.Common.logon'('bridgesb@slhs.org', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/exportresultscsv'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/csvdownload'))

Thread.sleep(2000)

WebUI.switchToDefaultContent()

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

'Step 7:Should be able to release a patients report with a portal user email address'
CustomKeywords.'com.gh.portal.Common.logon'('yan.feng@uhhospitals.org', 'Pa22word')

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/selectpatient'))

WebUI.waitForPageLoad(5)

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
CustomKeywords.'com.gh.portal.Common.logon'('yan.feng@uhhospitals.org', 'R9dwWsVuqf0RB1p2unfSZQ==')

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
CustomKeywords.'com.gh.portal.Common.logon'('nonportaluser2@gmail.com', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(5)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Portal/page_portalaccession/sharermsg'), 5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/acceptcheck'))

    WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/acceptinvitation'))
}

WebUI.waitForPageLoad(5)

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

'Step 9:Should not be able to see release to patient option for an ineligible patient'
CustomKeywords.'com.gh.portal.Common.logon'('yan.feng@uhhospitals.org', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/selectpatient'))

WebUI.waitForPageLoad(5)

shareButton = WebUI.verifyElementVisible(findTestObject('Object Repository/Portal/page_portalaccession/sharepatientreport'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/sharepatientreport'))

Thread.sleep(2000)

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/fname'), 'Benjamin')

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/lname'), 'Bridges')

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/portalemail'), 'bridgesb@slhs.org')

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/checkbox'))

WebUI.click(findTestObject('Portal/page_portalaccession/sendtinvitation'))

WebUI.acceptAlert()

Thread.sleep(2000)

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

WebUI.closeBrowser()

'Checking for ineligible patient'
CustomKeywords.'com.gh.portal.Common.logon'('bridgesb@slhs.org', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(5)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Portal/page_portalaccession/sharermsg'), 5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/acceptcheck'))

    WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/acceptinvitation'))
}

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/searchid'), 'A11752')

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/selectsearch'))

Thread.sleep(2000)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Portal/page_portalaccession/sharepatientreport'), 5, FailureHandling.OPTIONAL)) {
    println('patient is eligible')
} else {
    println('patient is ineligible')
}

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

WebUI.closeBrowser()

'Step 11:Should see a notification on an auto-released patient report page indicating that the report has been auto-released'
CustomKeywords.'com.gh.portal.Common.logon'('tvo@guardanthealth.com', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(5)

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/physiciansearchbar'), 'Hugo Hool')

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/physicianselect'))

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/selectpatient'))

WebUI.waitForPageLoad(5)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Portal/page_portalaccession/notificationmsg'), 5)) {
    String strmsg = WebUI.getText(findTestObject('Object Repository/Portal/page_portalaccession/notificationmsg'))

    println(strmsg)
}

Thread.sleep(2000)

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

WebUI.closeBrowser()

'Step 10: Should be able to revoke access to a grantee'
CustomKeywords.'com.gh.portal.Common.logon'('bejoysitemgr@gmail.com', 'R9dwWsVuqf0RB1p2unfSZQ==')

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/permissionstab'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/physicianrevoke'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/revokebutton'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/physicianrevoke'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/revokebutton'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/revokeyes'))

WebUI.waitForPageLoad(10)

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

WebUI.closeBrowser()

'Step 2: Should see reports for only their patients and with recent accessioning date and for any previous dates.'
CustomKeywords.'com.gh.portal.Common.logon'('bridgesb@slhs.org', 'Pa22word')

WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/searchid'), aNumber)

WebUI.verifyElementPresent(findTestObject('Object Repository/Portal/page_portalaccession/selectsearch'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/selectsearch'))

Thread.sleep(2000)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/tooglepatientname'))

String collectionDate = WebUI.getText(findTestObject('Object Repository/Portal/page_portalaccession/collectiondate'))

println(collectionDate)

WebUI.waitForPageLoad(10)

WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))

WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))

WebUI.closeBrowser()

'Step 3:Should see only reports for all physicians that admin granted access'
 CustomKeywords.'com.gh.portal.Common.logon'('bejoysitemgr@gmail.com', 'R9dwWsVuqf0RB1p2unfSZQ==')
 
 WebUI.waitForPageLoad(5)
 
 WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/grantaccess'))
 
 WebUI.setText(findTestObject('Object Repository/Portal/page_portalaccession/inputemail'), 'bridgesb@slhs.org')
 
 WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/selectallcheck'))
 
 WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/selectphysician'))
 
 String strPhysician = WebUI.getText(findTestObject('Object Repository/Portal/page_portalaccession/selectphysiciandetail'))
 
 println(strPhysician)
 
 WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/checkbox'))
 
 WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/grantaccessbtn'))
 
 Thread.sleep(2000)
 
 WebUI.waitForPageLoad(20)
 
 WebUI.waitForElementVisible(findTestObject('Object Repository/Portal/page_portalaccession/msgconfirm'), 20)
 
 WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)
 
 WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))
 
 WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))
 
 WebUI.closeBrowser()
 
 'Login with another credential to see the grant invitation of that pysician'
 CustomKeywords.'com.gh.portal.Common.logon'('bridgesb@slhs.org', 'R9dwWsVuqf0RB1p2unfSZQ==')
 
 WebUI.waitForPageLoad(5)
 
 if (WebUI.verifyElementPresent(findTestObject('Object Repository/Portal/page_portalaccession/acceptcheck'), 10, FailureHandling.OPTIONAL)) {
	 WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/acceptcheck'))
 
	 WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/acceptinvitation'))
 }
 
 WebUI.waitForPageLoad(2000)
 
 Thread.sleep(2000)
 
 List<WebElement> physicianNames = DriverFactory.getWebDriver().findElements(By.xpath('//div[@class=\'requests-list__header__label__name\']'))
 
 physicianCount = physicianNames.size()
 
 boolean phyflag = false
 
 for (int i = 0; i < physicianCount; i++) {
	 
	 if (physicianNames.get(i).getText().contains(strPhysician)) {
		 phyflag = true
		 Assert.assertEquals(physicianNames.get(i).getText(), strPhysician)
		 break
	 }
	 
	 Thread.sleep(1000)
 }
 
 if (!(phyflag)) {
	 WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/permissionstab'))
 
	 List<WebElement> allPhysicians = DriverFactory.getWebDriver().findElements(By.xpath('//div[@class=\'share-index__collaborator__left-col__name\']'))
 
	 int allPhysicianCount = allPhysicians.size()
 
	 boolean allPhyflag = false
 	 for (int j = 1; j < allPhysicianCount; j++) {
		 println(allPhysicians.get(j).getText())
 
		 allPhyflag = strPhysician.contains(allPhysicians.get(j).getText())
 
		 println(allPhyflag)
 
		 if (allPhyflag) {
			 println('no patient with given physician name')
 			 break
		 }
	 }
 }
  WebUI.waitForPageLoad(10)
 
 Thread.sleep(2000)
 
 WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)
 
 WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))
 
 WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))
 
 WebUI.closeBrowser()
 
 'Step 10: Should be able to revoke access to a grantee'
 CustomKeywords.'com.gh.portal.Common.logon'('bejoysitemgr@gmail.com', 'Pa22word')
 
 WebUI.waitForPageLoad(5)
 
 WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/permissionstab'))
 
 WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/reportaccessheading'))
 
// listphysicians='Object Repository/Portal/page_portalaccession/physicianlist'
 Thread.sleep(5000)
	 List<WebElement> allRevokePhysicians = DriverFactory.getWebDriver().findElements(By.xpath("(//div[text()='Reports-Access Invitations']//ancestor::div[@class='share-index__body']//div[@class='share-index__collaborators-container']//div[@class='share-index__collaborator'])[1]//div[@class='share-created__text-description']"))
 
	 int allRevokePhysicianCount = allRevokePhysicians.size()
 
	 boolean allPhyflag = false
	  for (int j = allRevokePhysicianCount-1; j < allRevokePhysicianCount; j--) {
		 println(allRevokePhysicians.get(j).getText())
 
		 allPhyflag = strPhysician.contains(allRevokePhysicians.get(j).getText())
 
		 println(allPhyflag)
		 
		 if (allPhyflag)
		  {
			  
			 List<WebElement> allRevokeButtons = DriverFactory.getWebDriver().findElements(By.xpath("//div[contains(text(),'"+gmail+"')]//ancestor::div[@class='share-index__collaborators-container']//div[text()='"+strPhysician+"']//ancestor::div[@class='share-created']//div[@class='simple-toggle__share-index on']"))
			 int allRevokeButtonsCount = allRevokeButtons.size()
			  for (int l = allRevokeButtonsCount-1; l < allRevokeButtonsCount; l--)
			  {
				  allRevokeButtons.get(l).click()
				  List<WebElement> allYesButtons = DriverFactory.getWebDriver().findElements(By.xpath("//div[contains(text(),'"+gmail+"')]//ancestor::div[@class='share-index__collaborators-container']//div[text()='"+strPhysician+"']//ancestor::div[@class='share-created']//div[text()='YES']"))
				  int allYesButtonsCount=allYesButtons.size()
				  for (int k = allYesButtonsCount-1; k < allYesButtonsCount; k--)
				  {
					  allYesButtons.get(k).click()
					  break
				  }
				  break
			  }
		 }
		  break
	 }
	 
 WebUI.waitForPageLoad(10)
 
 WebUI.waitForElementClickable(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'), 20)
 
 WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/profilemenu'))
 
 WebUI.click(findTestObject('Object Repository/Portal/page_portalaccession/signout'))
 
 WebUI.closeBrowser()

 
 