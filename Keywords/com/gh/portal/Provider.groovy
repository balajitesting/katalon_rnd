package com.gh.portal

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/**
 * @author gxu
 * @date 11/12/2018
 * 
 * Common module for Provider
 */

import internal.GlobalVariable

public class Provider {

	@Keyword
	def shareReportToPhysician(String patientName, String Phy2Fname, String Phy2Lname, String phy2Email){

		WebUI.setText(findTestObject('Portal/page_guardanthealth/inputpatientname'), 'KENNEALY')

		WebUI.click(findTestObject('Portal/page_guardanthealth/searchpatientname'))

		Thread.sleep(1000)

		WebUI.click(findTestObject('Portal/page_guardanthealth/sharebutton'))

		WebUI.setText(findTestObject('Portal/page_guardanthealth/inputfirstname'), 'Mary')

		WebUI.setText(findTestObject('Portal/page_guardanthealth/inputlastname'), 'Fidler')

		WebUI.setText(findTestObject('Portal/page_guardanthealth/inputemailaddress'), 'mary_fidler@rush.edu')

		WebUI.click(findTestObject('Portal/page_guardanthealth/acceptterms'))

		WebUI.click(findTestObject('Portal/page_guardanthealth/invitationbutton'))

		WebUI.acceptAlert()

		//WebUI.waitForPageLoad(10)

		WebUI.waitForElementVisible(findTestObject('Portal/page_guardanthealth/confirmationmessage'), 15)

	}
}


