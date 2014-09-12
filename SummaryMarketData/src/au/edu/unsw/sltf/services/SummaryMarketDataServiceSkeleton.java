
/**
 * SummaryMarketDataServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package au.edu.unsw.sltf.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import au.edu.unsw.sltf.services.SummaryMarketDataFaultDocument.SummaryMarketDataFault;
import au.edu.unsw.sltf.services.SummaryMarketDataDocument.SummaryMarketData;
import au.edu.unsw.sltf.services.SummaryMarketDataResponseDocument.SummaryMarketDataResponse;

/**
 *  SummaryMarketDataServiceSkeleton java skeleton for the axisService
 */
public class SummaryMarketDataServiceSkeleton implements SummaryMarketDataServiceSkeletonInterface{


	/**
	 * Auto generated method signature
	 * 
	 * @param summaryMarketData0 
	 * @return summaryMarketDataResponse1 
	 * @throws SummaryMarketDataFaultException 
	 */
	private static String path = System.getenv("CATALINA_BASE");
	private static String private_dir = path + "/temp/";

	public SummaryMarketDataResponseDocument summaryMarketData(SummaryMarketDataDocument reqDoc)
			throws SummaryMarketDataFaultException{
		SummaryMarketData req = reqDoc.getSummaryMarketData();
		String eventSetId = req.getEventSetId();
		String sec = null, marketType = null, currencyCode = null, fileSize = null;
		int tempMarketType = 1;
		long tempSize = 0;
		Calendar startDate = Calendar.getInstance(), endDate = Calendar.getInstance();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(private_dir+eventSetId+".csv"));
			String inputLine = reader.readLine();
			System.out.println(inputLine);
			String[] result = inputLine.split(",", -1);
			sec = result[0];
			String[] dateData = result[1].split("-");
			String[] timeData = result[2].split(":");
			String second = timeData[2].substring(0,timeData[2].lastIndexOf("."));
			int month = 0;
			System.out.println(inputLine);
			month = getMonthNum(dateData[1]);
			startDate.set(Integer.parseInt(dateData[2]), month, Integer.parseInt(dateData[0]), 
						Integer.parseInt(timeData[0]),Integer.parseInt(timeData[1]),Integer.parseInt(second));
			marketType = result[4];
			System.out.println(startDate);
			
			if(result[5] != null){
				if(result[5].substring(0,2).matches("[A-Z]{3}"))
					currencyCode = result[5].substring(0,2);
				else
					currencyCode = "AUD";
			}
			System.out.println(currencyCode);
			 while ((inputLine = reader.readLine()) != null){
				 result = inputLine.split(",", -1);
				 if(tempMarketType != 2 && !marketType.equals(result[4]))
					 tempMarketType = 2;
				 if(currencyCode == null) {
					 if(result[5].substring(0,2).matches("[A-Z]{3}"))
							currencyCode = result[5].substring(0,2);
						else
							currencyCode = "AUD";
				 }
			 }
			 if(tempMarketType == 2)
				 marketType = "Mixed";
			 dateData = result[1].split("-");
			 timeData = result[2].split(":");
			 month = getMonthNum(dateData[1]);
			 endDate.set(Integer.parseInt(dateData[2]), month, Integer.parseInt(dateData[0]), 
					Integer.parseInt(timeData[0]),Integer.parseInt(timeData[1]),Integer.parseInt(second));
			reader.close();
		} catch (FileNotFoundException e1) {
			throw createFault(SummaryMarketDataFaultType.INVALID_EVENT_SET_ID, 
					SummaryMarketDataFaultType.INVALID_EVENT_SET_ID.toString());
		} catch (IOException e) {
			throw createFault(SummaryMarketDataFaultType.INVALID_EVENT_SET_ID, 
					SummaryMarketDataFaultType.INVALID_EVENT_SET_ID.toString());
		}
		File file = new File(private_dir+eventSetId+".csv");
		if(file.exists())
			tempSize = file.length();
		fileSize = Long.toString(tempSize);
		SummaryMarketDataResponseDocument resDoc = SummaryMarketDataResponseDocument.Factory.newInstance();
		SummaryMarketDataResponse res = resDoc.addNewSummaryMarketDataResponse();
		System.out.println(eventSetId);
		System.out.println(sec);
		System.out.println(startDate);
		System.out.println(endDate);
		System.out.println(marketType);
		System.out.println(currencyCode);
		System.out.println(fileSize);
		res.setEventSetId(eventSetId);
		res.setSec(sec);
		res.setStartDate(startDate);
		res.setEndDate(endDate);
		res.setMarketType(marketType);
		res.setCurrencyCode(currencyCode);
		res.setFileSize(fileSize);
		return resDoc;
	}
	private SummaryMarketDataFaultException createFault(SummaryMarketDataFaultType.Enum type, String message) {
        SummaryMarketDataFaultException e = new SummaryMarketDataFaultException();
        SummaryMarketDataFaultDocument fDoc = SummaryMarketDataFaultDocument.Factory.newInstance();
        SummaryMarketDataFault f = fDoc.addNewSummaryMarketDataFault();
        f.setFaultType(type);
        f.setFaultMessage(message);
        e.setFaultMessage(fDoc);
        return e;
	}
	private int getMonthNum(String month) {
		 if(month.equals("JAN"))
			 return 1;
		 else if(month.equals("FEB"))
			 return 2;
		 else if(month.equals("MAR"))
			 return 3;
		 else if(month.equals("APR"))
			 return 4;
		 else if(month.equals("MAY"))
			 return 5;
		 else if(month.equals("JUN"))
			 return 6;
		 else if(month.equals("JUL"))
			 return 7;
		 else if(month.equals("AUG"))
			 return 8;
		 else if(month.equals("SEP"))
			 return 9;
		 else if(month.equals("OCT"))
			 return 10;
		 else if(month.equals("NOV"))
			 return 11;
		 else if(month.equals("DEC"))
			 return 12;
		 else
			 return 0;
		
	}
}
