
/**
 * ImportDownloadServicesSkeleton.java
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
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.Calendar;

import org.apache.axis2.description.AxisService;

import com.sun.corba.se.spi.activation.Server;

import au.edu.unsw.sltf.services.DownloadFileDocument.DownloadFile;
import au.edu.unsw.sltf.services.DownloadFileResponseDocument.DownloadFileResponse;
import au.edu.unsw.sltf.services.ImportDownloadFaultDocument.ImportDownloadFault;
import au.edu.unsw.sltf.services.ImportMarketDataDocument.ImportMarketData;
import au.edu.unsw.sltf.services.ImportMarketDataResponseDocument.ImportMarketDataResponse;

/**
 *  ImportDownloadServicesSkeleton java skeleton for the axisService
 */
public class ImportDownloadServicesSkeleton implements ImportDownloadServicesSkeletonInterface{

	private static String path = System.getenv("CATALINA_BASE");
	// TODO: initialise to the value from the last run/crash of tomcat
	private static int counter  = 0;

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
		String fileName = null;
		boolean urlFlag = false;
		if (!secStr.matches("[A-Z]{3,4}")) {
			throw createFault(ImportDownloadFaultType.INVALID_SEC_CODE, 
					ImportDownloadFaultType.INVALID_SEC_CODE.toString());
		}
		if(startDate.after(endDate)) {
			throw createFault(ImportDownloadFaultType.PROGRAM_ERROR, 
					"Start date must be before the end date");
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
					BufferedReader in = new BufferedReader(new InputStreamReader(
                                url.openConnection(Proxy.NO_PROXY).getInputStream()));
					String inputLine;
					boolean dir = new File(path+"/temp/").mkdir();
                    System.out.println("foo");
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
                    e.printStackTrace();
				}
			}
		} while(false);
		
		if (urlFlag == true) {
			throw createFault(ImportDownloadFaultType.INVALID_URL, "Invalid URL: " + urlStr);
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path+"/temp/"+fileName));
			String newFileName = counter+".csv";
			System.out.println(path+"/webapps/ROOT/"+newFileName);
			PrintWriter writer = new PrintWriter(path+"/webapps/ROOT/"+newFileName, "UTF-8");
			String inLine;
			while((inLine = reader.readLine()) != null) {
				 String[] result = inLine.split(",");
				 if(!secStr.equals(result[0]))
					 continue;
				 else {
					 String[] dateData = result[1].split("-");
					 String[] timeData = result[2].split(":");
					 String second = timeData[2].substring(0,timeData[2].lastIndexOf("."));
					 int month = 0;
					 if(dateData[1].equals("JAN"))
						 month = 1;
					 else if(dateData[1].equals("FEB"))
						 month = 2;
					 else if(dateData[1].equals("MAR"))
						 month = 3;
					 else if(dateData[1].equals("APR"))
						 month = 4;
					 else if(dateData[1].equals("MAY"))
						 month = 5;
					 else if(dateData[1].equals("JUN"))
						 month = 6;
					 else if(dateData[1].equals("JUL"))
						 month = 7;
					 else if(dateData[1].equals("AUG"))
						 month = 8;
					 else if(dateData[1].equals("SEP"))
						 month = 9;
					 else if(dateData[1].equals("OCT"))
						 month = 10;
					 else if(dateData[1].equals("NOV"))
						 month = 11;
					 else if(dateData[1].equals("DEC"))
						 month = 12;
					 else
						 System.out.println("invalid month");

					 Calendar calendarData = Calendar.getInstance();
					 calendarData.set(Integer.parseInt(dateData[2]), month, Integer.parseInt(dateData[0]), 
								Integer.parseInt(timeData[0]),Integer.parseInt(timeData[1]),Integer.parseInt(second));
					 if(calendarData.after(startDate)&&calendarData.before(endDate)) 
						 writer.println(inLine);
					 else
						 continue;
				 }
				
			}
			 reader.close();
			 writer.close();
		} catch (Exception e1) {
			throw createFault(ImportDownloadFaultType.PROGRAM_ERROR, 
					ImportDownloadFaultType.PROGRAM_ERROR.toString());
		}

		
		System.out.println(secStr);
		System.out.println(urlStr);
		System.out.println(startDate);
		System.out.println(endDate);
		
		ImportMarketDataResponseDocument resDoc = ImportMarketDataResponseDocument.Factory.newInstance();
		ImportMarketDataResponse res = resDoc.addNewImportMarketDataResponse();
		
		res.setEventSetId(Integer.toString(counter));
		counter++;
		
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
		String retAddress = null;
		DownloadFile dFile= reqDoc.getDownloadFile();
		String eventSetId = dFile.getEventSetId();
		System.out.println(eventSetId);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path+"/webapps/ROOT/"+eventSetId+".csv"));
			reader.close();
		} catch (Exception e1) {
			throw createFault(ImportDownloadFaultType.INVALID_EVENT_SET_ID, 
					ImportDownloadFaultType.INVALID_EVENT_SET_ID.toString());
		}

		InetAddress inetAddress = null;
		
		try {
			inetAddress = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			System.out.println("failed to get the local host");
		}
		if(inetAddress != null) 
			retAddress = inetAddress.getHostAddress()+":8080/"+eventSetId+".csv";
		
		System.out.println(retAddress);
		DownloadFileResponseDocument resDoc = DownloadFileResponseDocument.Factory.newInstance();
		DownloadFileResponse res = resDoc.addNewDownloadFileResponse();
		
		res.setDataURL(retAddress);
		
		return resDoc;
	

	}

	private ImportDownloadFaultException createFault(ImportDownloadFaultType.Enum type, String message) {
        ImportDownloadFaultException e = new ImportDownloadFaultException();
        ImportDownloadFaultDocument fDoc = ImportDownloadFaultDocument.Factory.newInstance();
        ImportDownloadFault f = fDoc.addNewImportDownloadFault();
        f.setFaultType(type);
        f.setFaultMessage(message);
        e.setFaultMessage(fDoc);
        return e;
	}
	

}
