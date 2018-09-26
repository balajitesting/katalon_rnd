package com.gh.lims

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable
import WebUiBuiltInKeywords as WebUI

public class Report {

	@Keyword
	def searchRequest(requestId){

		WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_Iteration/td_All Requests'))

		WebUI.setText(findTestObject('LIMS/DCO/Reporting/Page_Request List/input_searchtext'), requestId)

		WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_Request List/td_OK'))

		WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_Request List/td_Edit'))

		Thread.sleep(1000)

		WebUI.click(findTestObject('LIMS/DCO/Reporting/Page_Request List/td_Edit'))
	}

}
