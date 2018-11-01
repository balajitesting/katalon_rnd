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
 * @date 11/1/2018
 */

public class HttpClient {

	private def createHttpConnection(String endpoint){
		def url = ''
		def token = ''

		if(GlobalVariable.limsUrl == 'https://portal-sqa.guardanthealth.com'){

			url = 'https://clinical-sqa.k8s.ghdna.io'
			//token = 'eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjb20uZ3VhcmRhbnRoZWFsdGgiLCJzdWIiOiJ0ZXN0IiwiaWF0IjoxNTE0NTE3MTIwLCJleHAiOjE1NDYzMDA3OTl9.C-gB4NzSg1AY4N_FtKiaGbmXJ8I0afFJgIbREkEwj30'
		}else{
			url = 'https://clinical-val.k8s.ghdna.io'
			//token ='eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjb20uZ3VhcmRhbnRoZWFsdGgiLCJzdWIiOiJsaW1zIiwiaWF0IjoxNTIzNDYwNDQ2LCJleHAiOjE1NDYzMDA3OTl9.dL-B3dRr-kDFOdP0mAF0-aRGOpMgaw4h1OFgGhkhC88'
		}

		def connection = new URL( url + endpoint).openConnection() as HttpURLConnection

		return connection
	}

	@Keyword
	def doGet(String endpoint){
		String token = ''
		if(GlobalVariable.limsUrl == 'https://portal-sqa.guardanthealth.com')
			token = 'eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjb20uZ3VhcmRhbnRoZWFsdGgiLCJzdWIiOiJ0ZXN0IiwiaWF0IjoxNTE0NTE3MTIwLCJleHAiOjE1NDYzMDA3OTl9.C-gB4NzSg1AY4N_FtKiaGbmXJ8I0afFJgIbREkEwj30'
		else
			token = 'eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjb20uZ3VhcmRhbnRoZWFsdGgiLCJzdWIiOiJsaW1zIiwiaWF0IjoxNTIzNDYwNDQ2LCJleHAiOjE1NDYzMDA3OTl9.dL-B3dRr-kDFOdP0mAF0-aRGOpMgaw4h1OFgGhkhC88'

		HttpURLConnection connection = createHttpConnection(endpoint)

		connection.setRequestProperty( 'Authorization', 'Bearer ' + token)
		connection.setRequestProperty( 'Content-type', 'application/json' )

		String resp = connection.inputStream.text

		JsonSlurper slurper = new JsonSlurper()

		Map json = slurper.parseText(resp)

		return json
	}
}
