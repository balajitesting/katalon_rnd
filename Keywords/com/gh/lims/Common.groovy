package com.gh.lims

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLParser.setClause_scope
import org.openqa.selenium.WebDriver
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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import internal.GlobalVariable
import org.openqa.selenium.By as By

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

	@Keyword
	def static setClick2(String orPathToEdit){

		WebUI.waitForElementClickable(findTestObject(orPathToEdit), 10)
		WebUI.delay(2)
		WebUI.click(findTestObject(orPathToEdit))
	}

	/**
	 *  Switch to New Window
	 */

	@Keyword
	def static switchToWindows(WebDriver driver){

		String winHandleBefore = driver.getWindowHandle();

		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
	}

	/**
	 *  Clear Text
	 */

	@Keyword
	def static clearText(WebDriver driver, String value){

		driver.findElement(By.xpath(value)).clear();
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

	@Keyword
	def rtlLogout2(){

		WebUI.delay(2); 
		
		WebUI.click(findTestObject('Object Repository/LIMS/ResOps Requests/DV/Return To List Button'))
		
		WebUI.switchToDefaultContent()
		
		WebUI.click(findTestObject('LIMS/logout/img_Logout'))
	}
	
	/*
	 * 
	 */
	def selectValueInPopUp(String value){
		
		assert WebUI.getText(findTestObject('LIMS/Requests/DV2/DV2Request/searchBarText')).contains("Search Bar") == true
		
		WebUI.setText(findTestObject('LIMS/Requests/DV2/Page_DV2/searchProblemCase/searchText'), value)
		
		WebUI.click(findTestObject('LIMS/Requests/DV2/Page_DV2/searchProblemCase/searchOk'))
		
		WebUI.switchToFrame(findTestObject('LIMS/Requests/DV2/Page_DV2/listFrame'), 3)
		
		WebUI.delay(1)
		
		assert WebUI.getText(findTestObject('LIMS/Requests/DV2/Page_DV2/problemCaseValue')).contains(value) == true
		
		WebUI.click(findTestObject('LIMS/Requests/DV2/Page_DV2/problemCaseValue'))
	}
}