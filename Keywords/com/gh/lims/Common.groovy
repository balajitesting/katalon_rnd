package com.gh.lims

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLParser.setClause_scope

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

/**
 *
 * @author gxu
 *
 * Common customized Keywords for all LIMS page.
 * You should use Keyword here to build your test.
 *
 */

public class Common {

	@Keyword
	def logon(String username, String password){

		WebUI.openBrowser('')

		WebUI.navigateToUrl(GlobalVariable.limsUrl)

		WebUI.setText(findTestObject('LIMS/DCO/Report/input_username'), username)

		WebUI.setEncryptedText(findTestObject('LIMS/DCO/Report/input_password'), password)

		WebUI.click(findTestObject('LIMS/DCO/Report/button_Logon'))
	}

	/**
	 *  Use setClick for Edit, Begin Workflow, Run Workflow, auto_QC_Pass, Verify&Save
	 */


	@Keyword
	def static setClick(String orPathToEdit){

		WebUI.click(findTestObject(orPathToEdit))

		Thread.sleep(1000)

		WebUI.click(findTestObject(orPathToEdit))
	}

	/**
	 *  Return to List log out
	 */

	@Keyword
	def rtlLogout(){

		setClick('LIMS/Problem Resolution/returnToList/div_Return To List')

		WebUI.waitForElementPresent(findTestObject('LIMS/logout/img'), 15)

		WebUI.click(findTestObject('LIMS/logout/img'))
	}
}