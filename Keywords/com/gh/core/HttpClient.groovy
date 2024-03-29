package com.gh.core

import com.kms.katalon.core.annotation.Keyword
import internal.GlobalVariable
import groovy.json.JsonSlurper

/**
 * 
 * @author gxu
 * @date 11/01/2018
 * 
 */

public class HttpClient {

	private static def createHttpConnection(String endpoint){

		return new URL(GlobalVariable.clinicalServiceUrl + endpoint)
				.openConnection() as HttpURLConnection
	}

	@Keyword
	def static doGet(String endpoint){

		HttpURLConnection connection = createHttpConnection(endpoint)

		connection.setRequestProperty( 'Authorization', 'Bearer ' + GlobalVariable.csToken)
		connection.setRequestProperty( 'Content-type', 'application/json' )

		String resp = connection.inputStream.text

		JsonSlurper slurper = new JsonSlurper()
		Map json = slurper.parseText(resp)

		return json
	}
}
