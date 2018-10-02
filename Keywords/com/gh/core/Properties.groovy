package com.gh.core

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration

/**
 * @author gxu
 * 
 */

public class Properties {

	private String projDir = RunConfiguration.getProjectDir()
	private String PDFBASELINE_DIR = RunConfiguration.getProjectDir() + '/Resources/PDFBaseline/'
	String PDFDOWNLOAD_DIR = RunConfiguration.getProjectDir() + "/Results/download/"


	@Keyword
	def String getGetPDFBaseDir() {
		return PDFBASELINE_DIR
	}


	@Keyword
	def String getGetPDFDownloadDir() {
		return PDFDOWNLOAD_DIR
	}
}
