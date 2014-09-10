
/**
 * ImportDownloadServicesSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package au.edu.unsw.sltf.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

import org.apache.axis2.description.AxisService;

import com.sun.corba.se.spi.activation.Server;

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
		Calendar startDate = req.getStartDate();
		Calendar endDate = req.getEndDate();
		URL url = null;
		String fileName;
		boolean urlFlag = false;
		if (!secStr.matches("[A-Z]{3,4}")) {

			ImportDownloadFaultException e = new ImportDownloadFaultException();
			ImportDownloadFaultDocument fDoc = ImportDownloadFaultDocument.Factory.newInstance();
			ImportDownloadFault f = fDoc.addNewImportDownloadFault();
			f.setFaultMessage(ImportDownloadFaultType.INVALID_SEC_CODE.toString());
			f.setFaultType(ImportDownloadFaultType.INVALID_SEC_CODE);
			e.setFaultMessage(fDoc);
			throw e;
		}
		if(startDate.after(endDate)) {
			ImportDownloadFaultException e = new ImportDownloadFaultException();
			ImportDownloadFaultDocument fDoc = ImportDownloadFaultDocument.Factory.newInstance();
			ImportDownloadFault f = fDoc.addNewImportDownloadFault();
			f.setFaultMessage("Invalid date");
			f.setFaultType(ImportDownloadFaultType.PROGRAM_ERROR);
			e.setFaultMessage(fDoc);
			throw e;
		}
		do {
			try	{
				url = new URL(urlStr);
				if(!url.getProtocol().toLowerCase().equals("http")) {
					urlFlag = true;
					break;
				}
			} catch (MalformedURLException mue) {
				urlFlag = true;
				break;
			}
			fileName = url.toString().substring(url.toString().lastIndexOf("/")+1);
			System.out.println(fileName);
			if(fileName.equals("")) {
				urlFlag = true;
				break;
			}
			else if(!fileName.substring(fileName.lastIndexOf(".")+1).equals("csv")) {
				urlFlag = true;
				break;
			}
			else {
					fileName = fileName.substring(0,fileName.lastIndexOf("."))+System.currentTimeMillis()
							+fileName.substring(fileName.lastIndexOf("."));
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
					String inputLine;
					String path = System.getenv("CATALINA_HOME");
					boolean dir = new File(path+"/temp/").mkdir();
					if(dir == false) {
						System.out.println("failed to create a temp directory"+path+"/temp/");
					}
					PrintWriter writer = new PrintWriter(path+"/temp/"+fileName, "UTF-8");
					inputLine = in.readLine();
			        while ((inputLine = in.readLine()) != null)
			           writer.println(inputLine);
			        in.close();
			        writer.close();
				} catch (IOException e) {
					urlFlag = true;
				}
			}
		} while(false);
		
		if(urlFlag == true) {
			ImportDownloadFaultException e = new ImportDownloadFaultException();
			ImportDownloadFaultDocument fDoc = ImportDownloadFaultDocument.Factory.newInstance();
			ImportDownloadFault f = fDoc.addNewImportDownloadFault();
			f.setFaultMessage("Invalid URL: " + urlStr);
			f.setFaultType(ImportDownloadFaultType.INVALID_URL);
			e.setFaultMessage(fDoc);
			throw e;
		}

		
		System.out.println(secStr);
		System.out.println(urlStr);
		System.out.println(startDate);
		System.out.println(endDate);
		
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
