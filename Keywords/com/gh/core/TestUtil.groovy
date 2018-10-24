package com.gh.core

import java.io.File;
import java.io.IOException
import java.text.SimpleDateFormat
import com.kms.katalon.core.annotation.Keyword
import com.gh.core.Properties as CustomProperties

/**
 * @author gxu
 *
 * TestUtil class
 *
 */

public class TestUtil {

	public static void purgeDirectory(File dir){

		if(hasFile(dir)) {
			File[] files = getFiles(dir);

			for (File file : files) {
				if (file.isDirectory()) purgeDirectory(file);
				file.delete();
			}
		}
	}

	public static File[] getFiles(File dir){

		File[] files = dir.listFiles(new FileFilter() {
					@Override
					public boolean accept(File file) {
						return !file.isHidden();
					}
				});

		return files;
	}

	public static void writeFile(String pdfDir) throws IOException {

		File file = new File(pdfDir);

		if (file.createNewFile()){
			System.out.println("INFO: File is created!");
		}else{
			System.out.println("WARNING: File creation failed.");
		}
	}

	public static boolean hasFile(File dir) {

		File[] files = getFiles(dir);

		return files.length != 0;
	}


	public static String convertString(String str) {

		str.toLowerCase();
		str.substring(0,1).toUpperCase();

		return str;
	}

	@Keyword
	public static String getRandom(){
		Random rand = new Random();
		String barCode = "SQA" +rand.nextInt(9999) + rand.nextInt(999999999);
		return barCode
	}
	
	@Keyword
	public static String getSampleID(){
		Random rand = new Random();
		String sampleID = 100000000 + rand.nextInt(999999999);			
		return sampleID
	}

	@Keyword
	public static String setDate(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -2);
		SimpleDateFormat ds = new SimpleDateFormat("MM/dd/YYYY");
		String date = ds.format(cal.getTime());
		return date
	}
}
