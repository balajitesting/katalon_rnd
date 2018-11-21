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
	def shareReportToPhysician(String patientName, String phy2Fname, String phy2Lname, String phy2Email){

		WebUI.setText(findTestObject('Portal/page_guardanthealth/inputpatientname'), patientName)

		WebUI.click(findTestObject('Portal/page_guardanthealth/searchpatientname'))

		Thread.sleep(1000)

		WebUI.click(findTestObject('Portal/page_guardanthealth/sharebutton'))

		WebUI.setText(findTestObject('Portal/page_guardanthealth/inputfirstname'), phy2Fname)

		WebUI.setText(findTestObject('Portal/page_guardanthealth/inputlastname'), phy2Lname)

		WebUI.setText(findTestObject('Portal/page_guardanthealth/inputemailaddress'), phy2Email)

		WebUI.click(findTestObject('Portal/page_guardanthealth/acceptterms'))

		WebUI.click(findTestObject('Portal/page_guardanthealth/invitationbutton'))

		WebUI.acceptAlert()

		WebUI.waitForElementVisible(findTestObject('Portal/page_guardanthealth/confirmationmessage'), 15)
	}

	@Keyword
	def acceptInvitation(String pwd){
		WebUI.switchToWindowIndex(2)

		WebUI.click(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/nextbutton'))

		WebUI.setText(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/userpassword'), pwd)

		WebUI.click(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/accepterm'))

		WebUI.click(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/portalaccountbutton'))

		//WebUI.waitForPageLoad(10)

		WebUI.click(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/acceptcheckbox'))

		WebUI.click(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/buttonacceptinvitation'))
	}

	@Keyword
	def verifyTrm(String patientName){

		WebUI.setText(findTestObject('Portal/page_mailtrap/page_mailconfirmationpage/searchguestpatientname'), patientName)

		WebUI.setText(findTestObject('Portal/page_guardanthealth/inputpatientname'), patientName)

		WebUI.click(findTestObject('Portal/page_guardanthealth/searchpatientname'))

		com.gh.core.JSHandler.JClick(findTestObject('Portal/Dashboard/provider/timepoint2/Page_Guardant Health/i_Flores Rey_fa fa-angle-down'), 15)

		WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/timepoint2/Page_Guardant Health/div_ACCESSION ID'))

		WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/timepoint2/Page_Guardant Health/div_A61966'))

		WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/timepoint2/Page_Guardant Health/div_MRN'))

		WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/timepoint2/Page_Guardant Health/div_DOB'))

		WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/timepoint2/Page_Guardant Health/div_GENDER'))

		WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/timepoint2/Page_Guardant Health/div_DIAGNOSIS'))

		WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/timepoint2/Page_Guardant Health/div_TEST NUMBER'))

		WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/timepoint2/Page_Guardant Health/div_Report Date'))

		WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/timepoint2/Page_Guardant Health/div_RECEIPT DATE'))

		WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/timepoint2/Page_Guardant Health/div_COLLECTION DATE'))

		WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/timepoint2/Page_Guardant Health/div_SPECIMEN'))

		WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/timepoint2/Page_Guardant Health/div_STATUS'))

		WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/timepoint2/Page_Guardant Health/div_PHYSICIAN'))

		WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/timepoint2/Page_Guardant Health/div_ACCOUNT'))

		WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/timepoint2/Page_Guardant Health/div_ADDRESS'))

		WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/timepoint2/Page_Guardant Health/div_PH'))

		WebUI.click(findTestObject('Object Repository/Portal/Dashboard/provider/timepoint2/Page_Guardant Health/div_FAX'))

		WebUI.click(findTestObject('Portal/Dashboard/provider/timepoint2/Page_Guardant Health/div_ADDITIONAL RECIPIENT'))

		com.gh.core.JSHandler.JClick(findTestObject('Portal/Dashboard/provider/timepoint2/Page_Guardant Health/i_Flores Rey_fa fa-angle-down'), 15)

		/**
		 *
		 WebUI.click(findTestObject('Portal/timepoint/Page_Guardant Health/Page_Guardant Health/i_Flores Rey_fa fa-angle-up'))
		 WebUI.click(findTestObject('Portal/timepoint/Page_Guardant Health/Page_Guardant Health/path_-_tumor-response-map__box'))
		 WebUI.click(findTestObject('Portal/timepoint/Page_Guardant Health/path_JAN-19-2017_tumor-respons'))
		 WebUI.click(findTestObject('/Portal/timepoint/Page_Guardant Health/text_5.9'))
		 WebUI.click(findTestObject('Portal/timepoint/Page_Guardant Health/Page_Guardant Health/div_ACCESSION ID'))
		 WebUI.click(findTestObject('Portal/timepoint/Page_Guardant Health/Page_Guardant Health/div_A47257'))
		 WebUI.click(findTestObject('Portal/timepoint/Page_Guardant Health/Page_Guardant Health/div_MRN'))
		 WebUI.click(findTestObject('Portal/timepoint/Page_Guardant Health/Page_Guardant Health/div_5680202'))
		 */
	}
}


