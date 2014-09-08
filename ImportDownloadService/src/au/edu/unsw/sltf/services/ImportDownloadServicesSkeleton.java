
/**
 * ImportDownloadServicesSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package au.edu.unsw.sltf.services;

import java.util.Calendar;

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
		String retSec = "abc"+req.getSec();
		String retUrl = "abc"+req.getDataSourceURL();
		Calendar retStartDate = req.getStartDate();
		Calendar retEndDate = req.getEndDate();
		
		System.out.println(retSec);
		System.out.println(retUrl);
		System.out.println(retStartDate);
		System.out.println(retEndDate);
		
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
