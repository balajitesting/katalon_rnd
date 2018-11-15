package com.gh.core

import java.io.File;
import java.io.IOException
import java.text.SimpleDateFormat
import com.kms.katalon.core.annotation.Keyword

import internal.GlobalVariable

import com.gh.core.Properties as CustomProperties

/**
 * @author gxu
 *
 * TestUtil class
 *
 */

public class TestUtil {

	public static void purgeDirectory(String filepath){

		File dir = new File (filepath);
		if(hasFile(dir)) {
			File[] files = getFiles(dir);

			for (File file : files) {
				if (file.isDirectory()) purgeDirectory(file);
				file.delete();
			}
		}
	}

	public static void purgeFile(String filepath){
		
				File file = new File (filepath);
				file.delete();

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
	public static boolean waitUntilFileExist(String filepath, int timeout)  {
		try {
			Thread.sleep(1000);
			//int timeout = 40;
			File f = new File(filepath);
			while (!f.exists()) {
				Thread.sleep(1000);
				timeout --;
				if (timeout == 0) {
					return false;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return true;
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
	public static String getDate(String pattern){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat ds = new SimpleDateFormat(pattern);
		String date = ds.format(cal.getTime());
		return date
	}


	@Keyword
	public static String setDate(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -2);
		SimpleDateFormat ds = new SimpleDateFormat("MM/dd/YYYY");
		String date = ds.format(cal.getTime());
		return date
	}

	@Keyword
	public static String setDate(int offset){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, offset);
		SimpleDateFormat ds = new SimpleDateFormat("MM/dd/YYYY");
		String date = ds.format(cal.getTime());
		return date
	}

	@Keyword
	public static boolean check_ssh_host_file_exist(String path) {
		String s = null;

		try {

			// This only work when you setup your ssh key in the server.
			Process p = Runtime.getRuntime().exec("ssh -q "+GlobalVariable.ssh_host+" [[ -f \""+path+"\" ]] && echo \"exists\" || echo \"not_exist\";\n");

			BufferedReader stdInput = new BufferedReader(new
					InputStreamReader(p.getInputStream()));

			BufferedReader stdError = new BufferedReader(new
					InputStreamReader(p.getErrorStream()));

			// read the output from the command
			while ((s = stdInput.readLine()) != null) {
				return s.equals("exists");
			}

			// read any errors from the attempted command
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
			}

			System.exit(0);
		} catch (IOException e) {
			System.out.println("exception happened - here's what I know: ");
			e.printStackTrace();
			System.exit(-1);
		}
		return false;
	}

}
