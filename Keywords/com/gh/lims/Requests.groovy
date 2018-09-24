package com.gh.lims

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
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
import WebUiBuiltInKeywords as WebUI

public class Requests {

	String RequestId
	String ReportStatus

	@Keyword
	def setRequestId(String requestId) {
		RequestId = requestId;
	}

	@Keyword
	def getRequestId() {
		return RequestId
	}

	@Keyword
	def searchRequest(requestId){
		WebUI.click(findTestObject('LIMS/DCO/Request/td_All Requests'))

		WebUI.click(findTestObject('LIMS/DCO/Request/a_GHByRequestId'))

		WebUI.setText(findTestObject('LIMS/DCO/Request/input_GHByRequestId_arg1'), requestId)

		WebUI.click(findTestObject('LIMS/DCO/Request/td_OK'))

		WebUI.click(findTestObject('LIMS/DCO/Request/button_OK'))

		Thread.sleep(2000)

		WebUI.click(findTestObject('LIMS/DCO/Request/div_Edit'))

	}
}
