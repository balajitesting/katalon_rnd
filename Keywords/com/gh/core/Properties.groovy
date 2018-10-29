package com.gh.core

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration

/**
 * @author gxu
 * 
 */

public class Properties {

	private static String PDFBASELINE_DIR = RunConfiguration.getProjectDir() + '/Resources/PDFBaseline/'
	private static String PDFDOWNLOAD_DIR = RunConfiguration.getProjectDir() + "/Results/download/"
	
	def static String getPDFBaseDir() {
		return PDFBASELINE_DIR
	}


	def static String getPDFDownloadDir() {
		return PDFDOWNLOAD_DIR
	}
}
