package com.gh.lims

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

import internal.GlobalVariable

/**
 * 
 * @author gxu
 * 
 * Common customized Keywords in PostSequence page. 
 * You should use Keyword here to replace generated action.
 * 
 */

public class PostSequence {

	@Keyword
	def uploadBIPData(flowcellId){

		WebUI.click(findTestObject('LIMS/PostSequence/BIPUploadTramStop'))

		WebUI.click(findTestObject('Object Repository/LIMS/PostSequence/Page_BIPUpload/Upload BIP_Data Button'))

		WebUI.setText(findTestObject('LIMS/PostSequence/Page_BIPUpload/Popup_BIPUpload/Flowcell ID Textbox'),
				flowcellId)

		WebUI.click(findTestObject('LIMS/PostSequence/Page_BIPUpload/Popup_BIPUpload/OK_Button'))

		Thread.sleep(55000)
	}
}
