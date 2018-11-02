package com.gh.core

import com.testautomationguru.utility.CompareMode
import com.testautomationguru.utility.PDFUtil
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.kms.katalon.core.configuration.RunConfiguration
import org.apache.commons.io.FileUtils
import com.kms.katalon.core.annotation.Keyword

/**
 * @author gxu
 * @date 6/12/2018 created
 * @date 11/1/2018 added PDF compare for Portal
 * 
 * PDF comparison module to compare 2 PDF files pixel by pixel
 * 
 */

public class PDFCompare {

	private PDFUtil pdfUtil;
	private File pdfDiffDir;

	@Keyword
	def compareAndSave(String aNumber, String reportStat ){

		String filename = ((aNumber + '_') + reportStat) + '_report.pdf'

		String file1 = Properties.getPDFBaseDir() + filename
		String file2 = Properties.getPDFDownloadDir() + filename

		doCompare(file1, file2)
	}

	@Keyword
	def compareAndSave(String aNumber, String reportStat, Integer revision, boolean isLong){

		String basefile = ((aNumber + '_') + reportStat) + '_report.pdf'

		String file1 = Properties.getPDFBaseDir() + basefile
		String file2 = getGH360File(aNumber, revision, isLong)

		doCompare(file1, file2)
	}

	@Keyword
	boolean isDownloaded(String aNumber, Integer revision, boolean isLong){
		return new File(getGH360File(aNumber, revision, isLong)).isFile()
	}

	private String getGH360File(String aNumber, Integer revision, boolean isLong){
		def outFile = ''

		if (isLong)
			outFile = 'Guardant360-' + aNumber + '-v' + revision + '-Final-Additional-Info.pdf'
		else
			outFile = 'Guardant360-' + aNumber + '-v' + revision + '-Final.pdf'

		return Properties.getPDFDownloadDir() + outFile
	}

	private doCompare(String file1, String file2){

		String pdfDiffRootDir = RunConfiguration.getProjectDir() + "/Results/pdfdiff/"

		pdfDiffDir = setupDir(pdfDiffRootDir)

		String outFilePath = pdfDiffDir.getPath();

		pdfUtil = new PDFUtil();
		pdfUtil.compareAllPages(true)
		pdfUtil.highlightPdfDifference(true)
		pdfUtil.setCompareMode(CompareMode.VISUAL_MODE)
		pdfUtil.setImageDestinationPath(outFilePath)

		if(pdfUtil.compare(file1, file2)){
			println('PDF Match!')
		} else {
			println('Unmatched pdf found! Check diff file in ' + outFilePath)
		}
	}

	private File setupDir(String root) {

		String date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		File dir = new File(root + date);

		if (!dir.exists()) {
			System.out.println("creating directory: " + dir.getName());
			dir.mkdir();

			boolean result = false;

			try {
				result = true;
			} catch (SecurityException se) {
				se.printStackTrace();
			}
			if (result) {
				System.out.println("INFO: DIR is created.");
			}
		}

		String file = root + pdfDiffDir + ".txt";

		try {
			TestUtil.writeFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		new File(file).delete();

		return dir;
	}
}
