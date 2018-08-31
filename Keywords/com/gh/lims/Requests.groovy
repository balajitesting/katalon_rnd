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

	@Keyword
	def cancelReport(RequestId){

		WebUI.click(findTestObject('LIMS/DCO/Request/td_Save'))

		Thread.sleep(1000)

		WebUI.click(findTestObject('LIMS/DCO/Request/td_Cancel This_Request'))

		WebUI.verifyAlertPresent(20)

		Thread.sleep(1000)

		WebUI.acceptAlert()

		Thread.sleep(1000)
	}
}
