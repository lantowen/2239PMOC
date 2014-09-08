
/**
 * ImportDownloadServicesSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package au.edu.unsw.sltf.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

import au.edu.unsw.sltf.services.ImportDownloadFaultDocument.ImportDownloadFault;
import au.edu.unsw.sltf.services.ImportMarketDataDocument.ImportMarketData;
import au.edu.unsw.sltf.services.ImportMarketDataResponseDocument.ImportMarketDataResponse;

/**
 *  ImportDownloadServicesSkeleton java skeleton for the axisService
 */
public class ImportDownloadServicesSkeleton implements ImportDownloadServicesSkeletonInterface{

	
	

	/**
	 * Auto generated method signature
	 * 
	 * @param importMarketData0 
	 * @return importMarketDataResponse1 
	 * @throws ImportDownloadFaultException 
	 */

	public ImportMarketDataResponseDocument importMarketData(ImportMarketDataDocument reqDoc) 
			throws ImportDownloadFaultException{
		ImportMarketData req = reqDoc.getImportMarketData();
		String secStr = req.getSec();
		String urlStr = req.getDataSourceURL();
		Calendar StartDate = req.getStartDate();
		Calendar EndDate = req.getEndDate();
		URL url;
		try	{
			 url = new URL(urlStr);
		} catch (MalformedURLException mue) {
			ImportDownloadFaultException e = new ImportDownloadFaultException();
			ImportDownloadFaultDocument fDoc = ImportDownloadFaultDocument.Factory.newInstance();
			ImportDownloadFault f = fDoc.addNewImportDownloadFault();
			f.setFaultMessage("Invalid URL: " + urlStr);
			f.setFaultType(ImportDownloadFaultType.INVALID_URL);
			e.setFaultMessage(fDoc);
			throw e;
		}
		if (!secStr.matches("[A-Z]{3,4}")) {

			ImportDownloadFaultException e = new ImportDownloadFaultException();
			ImportDownloadFaultDocument fDoc = ImportDownloadFaultDocument.Factory.newInstance();
			ImportDownloadFault f = fDoc.addNewImportDownloadFault();
			f.setFaultMessage(ImportDownloadFaultType.INVALID_SEC_CODE.toString());
			f.setFaultType(ImportDownloadFaultType.INVALID_SEC_CODE);
			e.setFaultMessage(fDoc);
			throw e;
		}
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine;
	        while ((inputLine = in.readLine()) != null)
	            System.out.println(inputLine);
	        in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		System.out.println(secStr);
		System.out.println(urlStr);
		System.out.println(StartDate);
		System.out.println(EndDate);
		
		ImportMarketDataResponseDocument resDoc = ImportMarketDataResponseDocument.Factory.newInstance();
		ImportMarketDataResponse res = resDoc.addNewImportMarketDataResponse();
		
		res.setEventSetId("12345");
		
		return resDoc;

	}


	/**
	 * Auto generated method signature
	 * 
	 * @param downloadFile2 
	 * @return downloadFileResponse3 
	 * @throws ImportDownloadFaultException 
	 */

	public DownloadFileResponseDocument downloadFile(DownloadFileDocument reqDoc) 
			throws ImportDownloadFaultException{
		//TODO : fill this with the necessary business logic
		throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#downloadFile");
	}

}
