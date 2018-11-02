package com.gh.core

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
import groovy.json.JsonSlurper

/**
 * 
 * @author gxu
 * @date 11/01/2018
 */

public class HttpClient {

	private def createHttpConnection(String endpoint){
		def url = ''

		if(GlobalVariable.limsUrl == 'https://portal-sqa.guardanthealth.com')
			url = 'https://clinical-sqa.k8s.ghdna.io'
		else
			url = 'https://clinical-val.k8s.ghdna.io'

		return new URL( url + endpoint).openConnection() as HttpURLConnection
	}

	@Keyword
	def doGet(String endpoint){

		HttpURLConnection connection = createHttpConnection(endpoint)

		connection.setRequestProperty( 'Authorization', 'Bearer ' + GlobalVariable.token)
		connection.setRequestProperty( 'Content-type', 'application/json' )

		String resp = connection.inputStream.text

		JsonSlurper slurper = new JsonSlurper()

		Map json = slurper.parseText(resp)

		return json
	}
}
