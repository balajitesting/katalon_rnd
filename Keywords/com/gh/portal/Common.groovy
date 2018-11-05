package com.gh.portal

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import internal.GlobalVariable
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class Common {

	@Keyword
	def logon(String usr, String pwd){

		WebUI.openBrowser('')

		WebUI.navigateToUrl(GlobalVariable.portalUrl)

		WebUI.setText(findTestObject('Portal/logon/input_Username_sessionemail'), usr)

		WebUI.setEncryptedText(findTestObject('Portal/logon/input_Password_sessionpassword'),
				pwd)

		WebUI.click(findTestObject('Portal/logon/button_SIGN IN'))
	}

	@Keyword
	def mailTrapLogin(String usr, String pwd){

		WebUI.openBrowser('')

		WebUI.navigateToUrl('https://mailtrap.io')

		WebUI.click(findTestObject('Portal/page_mailtrap/mailtraploginbutton/loginbutton'))

		WebUI.setText(findTestObject('Portal/page_mailtrap/safeemailtestingpage/mailtrapemail'),usr)

		WebUI.setText(findTestObject('Portal/page_mailtrap/safeemailtestingpage/mailtrapuserpassword'),pwd)

		WebUI.click(findTestObject('Portal/page_mailtrap/safeemailtestingpage/signinbutton'))
	}

	@Keyword
	def switchToPortal(String usr, String pwd, String accessionID, int timeout) {

		Thread.sleep(2000)

		logon(usr, pwd)

		Thread.sleep(2000)

		WebUI.delay(timeout)

		WebUI.refresh()

		WebUI.waitForPageLoad(5)

		WebUI.waitForElementClickable(findTestObject('Portal/page_inprogressreport/inprogresscircleselect'), 2)

		WebUI.click(findTestObject('Portal/page_inprogressreport/inprogresscircleselect'))

		Thread.sleep(2000)

		WebUI.setText(findTestObject('Portal/page_inprogressreport/searchid'), accessionID)

		WebUI.click(findTestObject('Portal/page_inprogressreport/selectsearch'))

		Thread.sleep(2000)

		WebUI.click(findTestObject('Portal/page_inprogressreport/test/viewAccessionDetails'))

		assert WebUI.getText(findTestObject('Portal/page_inprogressreport/test/verifyStatus')).contains("In progress") == true

		Thread.sleep(2000)

		WebUI.click(findTestObject('Portal/page_inprogressreport/profilemenu'))

		WebUI.click(findTestObject('Portal/page_inprogressreport/signout'))

		WebUI.closeBrowser()
	}

	@Keyword
	def logout(){
		WebUI.click(findTestObject('Portal/Dashboard/logout/Page_Guardant Health/i_PERMISSIONS_fa fa-chevron-do'))

		WebUI.click(findTestObject('Portal/Dashboard/logout/Page_Guardant Health/a_Sign Out'))
	}
}
