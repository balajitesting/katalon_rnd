package com.gh.db


import java.sql.ResultSet

import com.kms.katalon.core.annotation.Keyword

import internal.GlobalVariable

public class LimsDBOperation extends LimsOracleDBService {

	public boolean ldReviewQuery(String a_number, String gen_type) {

		String table;
		String query;
		switch (gen_type) {

			case "CNV":
				table = "u_ghcnvgene";
				query = "select count(*) from "+table+" where sampleid like '"+ a_number+"%' and isSupportedCnvGene = '1'";
				break;
			case "SNV":
				table = "u_ghsnv";
				query = "select count(*) from "+table+" where sampleid like '"+ a_number + "%' and gene in (select genename from u_ghgenepanel where alterationtype ='SNV' and endgenepanelversion = '10000')";
				break;
			case "FUSION":
				table = "u_ghfusion";
				query = "select count(*) from "+table+" where sampleid like '"+ a_number
				+ "%' and (ispositivebytumorboardreview = 1 or (Fusion_Molecule_Count_AB > 0 or Fusion_Molecule_Count_A > 0 or Fusion_Molecule_Count_B > 0))";
				break;
			case "INDEL":
				table = "u_ghindel";
				query = "select count(*) from "+table+" where sampleid like '"+ a_number+"%'";
				break;
			default:
				throw new IllegalArgumentException("Invalid argument " + gen_type);
		}

		try {
			ResultSet rs = executeQuery(query);
			rs.next();
			int count = Integer.parseInt(rs.getString(1));
			//con.close();
			if (count > 0) {
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeDatabaseConnection();
		return false;
	}

	/*
	 * Get count of the records for the query ran
	 */
	public int getCount(String query){
		LimsOracleDBService db = new LimsOracleDBService();
		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);
		int count;
		try{
			ResultSet rs = executeQuery(query);
			while(rs.next()){
				count = rs.getInt(1);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(count)
		closeDatabaseConnection();
		return count;
	}

	/*
	 * It will return the first column value
	 */
	public String getValue(String query){
		LimsOracleDBService db = new LimsOracleDBService();
		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);
		String value;
		try{
			ResultSet rs = executeQuery(query);
			while(rs.next()){
				value = rs.getString(1);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(value);
		closeDatabaseConnection();
		return value;
	}

	public String getGHBOARDReview(String value, String requestID)
	{
		LimsOracleDBService db = new LimsOracleDBService();
		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);

		switch (value) {
			case "CNVCALL":
			case "SNVCALL":
			case "FUSIONCALL":
			case "INDELCALL":

				break;
			default:
				throw new IllegalArgumentException("Invalid argument " + value);
		}

		try {

			String query = "select " + value + " from u_ghboard where sampleid like '"+requestID+"%' and runid = (" +
					"select runid from u_ghreportinfo where sampleid like '"+requestID+"%' and (recordstatus = 'Activating' or recordstatus is null))";
			System.out.println(query);
			ResultSet rs = executeQuery(query);
			rs.next();
			String return_val = rs.getString(1);
			System.out.println(" == " + return_val);
			closeDatabaseConnection();
			return return_val;

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}

	public boolean isLDReviewShow(String requestID, String gen_type)
	{
		//System.out.println(requestID);
		//System.out.println(gen_type)

		LimsOracleDBService db = new LimsOracleDBService();
		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);
		String table;
		String query;
		//String a = "select count(*) from "+table+" where sampleid like '"+ requestID + "%' and (ispositivebytumorboardreview = 1 or (Fusion_Molecule_Count_AB > 0 or Fusion_Molecule_Count_A > 0 or Fusion_Molecule_Count_B > 0))";
		//System.out.println(a);
		switch (gen_type) {
			case "CNV":
				table = "u_ghcnvgene";
				query = "select count(*) from "+table+" where sampleid like '"+ requestID+"%' and isSupportedCnvGene = '1'";
				break;
			case "SNV":
				table = "u_ghsnv";
				query = "select count(*) from "+table+" where sampleid like '"+ requestID + "%' and gene in (select genename from u_ghgenepanel where alterationtype ='SNV' and endgenepanelversion = '10000')";
				break;
			case "FUSION":
				table = "u_ghfusion";
				query = "select count(*) from "+table+" where sampleid like '"+ requestID + "%' and (ispositivebytumorboardreview = 1 or (Fusion_Molecule_Count_AB > 0 or Fusion_Molecule_Count_A > 0 or Fusion_Molecule_Count_B > 0))";
				break;
			case "INDEL":
				table = "u_ghindel";
				query = "select count(*) from "+table+" where sampleid like '"+ requestID+"%'";
				break;
			default:
				throw new IllegalArgumentException("Invalid argument " + gen_type);
		}

		try {
			ResultSet rs = executeQuery(query);
			rs.next();
			int count = Integer.parseInt(rs.getString(1));
			//con.close();
			if (count > 0) {
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean isCLSReviewShow(String requestID, String gen_type)
	{

		LimsOracleDBService db = new LimsOracleDBService();
		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);
		String table;
		String query;
		switch (gen_type) {
			case "CNV":
				table = "u_ghcnvgene";
				query = "select count(*) from "+table+" where sampleid like '"+ requestID+"%' and (ispositivebytumorboardreview = 1 or ispositivebytumorboardreview = 1)";
				break;
			case "SNV":
				table = "u_ghsnv";
				query = "select count(*) from "+ table + " where sampleid like '" + requestID +"%' and (IsPositiveByReview='1' or IsPositiveByTumorBoardReview='1') and gene in (select genename from u_ghgenepanel where alterationtype ='SNV' and endgenepanelversion = '10000')" + " and runid = (select runid from u_ghreportinfo where requestid = '" + requestID +"' and recordstatus = 'Activating')";
				System.out.println(query);
				break;
			case "FUSION":
				table = "u_ghfusion";
				query = "select count(*) from "+table+" where sampleid like '"+ requestID+"%' and (IsPositiveByReview = '1' or IsPositiveByTumorBoardReview = '1')";

				break;
			case "INDEL":
				table = "u_ghindel";
				query = "select count(*) from "+table+" where sampleid like '"+ requestID+"%' and (ispositivebytumorboardreview = 1 or ispositivebytumorboardreview = 1)";
				break;
			default:
				throw new IllegalArgumentException("Invalid argument " + gen_type);
		}

		try {
			ResultSet rs = executeQuery(query);
			rs.next();
			int count = Integer.parseInt(rs.getString(1));
			// con.close();
			if (count > 0) {
				System.out.println(" == true");
				return true;
			}
			else
			{
				System.out.println(" == false");

				return false;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(" == false");
		return false;
	}

	public boolean isMSISample(String requestID)
	{
		LimsOracleDBService db = new LimsOracleDBService();
		db.connectDB(GlobalVariable.oracleDBurl, GlobalVariable.oracleDBuser, GlobalVariable.oracleDBpwd);
		String sql = "select count(*) from u_ghmsi where sampleid like '"+requestID+"%'";

		int count = getCount(sql);

		if (count == 0) {
			return false;
		}
		else
		{
			return true;
		}
	}

	// return true if the sample is MSI-high , else return false.
	public boolean isMSIHigh(String requestID)
	{
		String sql = "select count(*) from u_ghmsi where sampleid like '"+requestID+"%' and msi_status = 'MSI-H'";

		int count = getCount(sql);

		if (count == 0) {
			return false;
		}
		else
		{
			return true;
		}
	}
	
	// return true if the sample is MSS/MSI-L , else return false.
	public boolean isMSIHighNotDetected(String requestID)
	{
		String sql = "select count(*) from u_ghmsi where sampleid like '"+requestID+"%' and msi_status = 'MSS/MSI-L'";

		int count = getCount(sql);

		if (count == 0) {
			return false;
		}
		else
		{
			return true;
		}
	}


	/*  If TB Review count is more than 1 or IsPositiveReview count is more than 1, return true
	 CLS Review for that gene type will show up if it is true.
	 Otherwise the flow will not show. 
	 **/	

	public boolean clsReviewQuery(String a_number, String gen_type) {

		String table;
		String query;

		switch (gen_type) {

			case "CNV":
				table = "u_ghcnvgene";
				query = "select count(*) from "+table+" where sampleid like '"+ a_number+"%' and (ispositivebytumorboardreview = 1 or ispositivebytumorboardreview = 1)";
				break;
			case "SNV":
				table = "u_ghsnv";
				query = "select count(*) from "+ table + " where sampleid like '" + a_number +"%' and (IsPositiveByReview='1' or IsPositiveByTumorBoardReview='1') and gene in (select genename from u_ghgenepanel where alterationtype ='SNV' and endgenepanelversion = '10000')"
				+ " and runid = (select runid from u_ghreportinfo where sampleid like '" + a_number +"%' and recordstatus = 'Activating')";
				break;
			case "FUSION":
				table = "u_ghfusion";
				query = "select count(*) from "+table+" where sampleid like '"+ a_number+"%' and (IsPositiveByReview = '1' or IsPositiveByTumorBoardReview = '1')";

				break;
			case "INDEL":
				table = "u_ghindel";
				query = "select count(*) from "+table+" where sampleid like '"+ a_number+"%' and (ispositivebytumorboardreview = 1 or ispositivebytumorboardreview = 1)";
				break;
			default:
				throw new IllegalArgumentException("Invalid argument " + gen_type);
		}

		try {
			ResultSet rs = executeQuery(query);
			rs.next();
			int count = Integer.parseInt(rs.getString(1));
			//con.close();
			if (count > 0) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
