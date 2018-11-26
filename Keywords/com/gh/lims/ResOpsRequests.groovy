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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By

import internal.GlobalVariable
import WebUiBuiltInKeywords as WebUI

/**
 * 
 * @author gxu
 * 
 * Common customized Keywords in All Request page. 
 *
 */

public class ResOpsRequests {

	@Keyword
	def searchRequest(requestId){

		WebUI.setText(findTestObject('LIMS/PostSequence/TBReview/Search/input_Search_searchtext'), requestId)

		WebUI.click(findTestObject('LIMS/PostSequence/TBReview/Search/td_OK'))

		WebUI.delay(1)
	}

	@Keyword
	def enterESign(String pwd){

		WebUI.switchToDefaultContent()

		WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/img'))

		WebUI.switchToFrame(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Frame'), 10)

		WebUI.waitForElementVisible(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Password'), 10)

		WebUI.setText(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Password'), pwd)

		WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Dropdown_Btn'))

		WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Select_Reason'))

		WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_OK'))

		WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/img'))
	}

	@Keyword
	def enterESign(String pwd, String reason){

		WebDriver driver = DriverFactory.getWebDriver()

		WebUI.switchToDefaultContent()

		WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/img'))

		WebUI.switchToFrame(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Frame'), 10)

		WebUI.waitForElementVisible(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Password'), 10)

		WebUI.setText(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Password'), pwd)

		WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Dropdown_Btn'))

		WebUI.delay(3)

		driver.findElement(By.xpath("//td[contains(text(), '" + reason + "')]")).click();

		WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_OK'))

		WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/img'))
	}
}
