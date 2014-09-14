
/**
 * ImportDownloadServicesSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package au.edu.unsw.sltf.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.Calendar;

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
	private static String private_dir = path + "/temp/";
	private static String public_dir = path + "/webapps/ROOT/";
	// TODO: initialise to the value from the last run/crash of tomcat
	private static int counter  = 0;

	static {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(private_dir+"counter"));
			counter = Integer.parseInt(reader.readLine().trim());
			++counter;
			reader.close();
		} catch (Exception e1) {
			System.out.println("Could not read counter, this should be the first run");
		}
	}

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
				if(!url.getProtocol().equalsIgnoreCase("http")) {
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
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(
                                url.openConnection(Proxy.NO_PROXY).getInputStream()));
					String inputLine;
					String newFileName = Integer.toString(counter)+".csv";
					boolean dir = new File(private_dir).mkdir();
					if(dir == false) {
						System.out.println("failed to create a temp directory"+private_dir);
					}
					PrintWriter writer = new PrintWriter(private_dir+newFileName, "UTF-8");
					inputLine = in.readLine();
					writer.println(inputLine);
			        while ((inputLine = in.readLine()) != null){
						 String[] result = inputLine.split(",");
						 if(!secStr.equals(result[0]))
							 continue;
						 else {
							 String[] dateData = result[1].split("-");
							 String[] timeData = result[2].split(":");
							 String second = timeData[2].substring(0,timeData[2].lastIndexOf("."));
							 int month = 0;
							 month = getMonthNum(dateData[1]);
							 Calendar calendarData = Calendar.getInstance();
							 calendarData.set(Integer.parseInt(dateData[2]), month, Integer.parseInt(dateData[0]), 
										Integer.parseInt(timeData[0]),Integer.parseInt(timeData[1]),Integer.parseInt(second));
							 if(calendarData.after(startDate)&&calendarData.before(endDate)) 
								 writer.println(inputLine);
							 else
								 continue;
						 }
			           writer.println(inputLine);
				} 
			        in.close();
			        writer.close();
			        PrintWriter counterFile = new PrintWriter(private_dir+"counter", "UTF-8");
					counterFile.println(counter);
					counterFile.close();
				} catch (IOException e) {
					urlFlag = true;
				}
			}
		} while(false);
		
		if (urlFlag == true) {
			throw createFault(ImportDownloadFaultType.INVALID_URL, "Invalid URL: " + urlStr);
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
			BufferedReader reader = new BufferedReader(new FileReader(private_dir+eventSetId+".csv"));
			reader.close();
		} catch (Exception e1) {
			throw createFault(ImportDownloadFaultType.INVALID_EVENT_SET_ID, 
					ImportDownloadFaultType.INVALID_EVENT_SET_ID.toString());
		}
		File source = new File(private_dir+eventSetId+".csv");
		File dest = new File(public_dir+eventSetId+".csv");
		InputStream input = null;
		OutputStream output = null;
		try{
			input = new FileInputStream(source);
			output = new FileOutputStream(dest);
			byte[] buf = new byte[1024];
			int bytesRead;
			while((bytesRead = input.read(buf)) > 0)
				output.write(buf, 0, bytesRead);
			input.close();
			output.close();
		} catch (Exception e) {
			throw createFault(ImportDownloadFaultType.PROGRAM_ERROR, 
					ImportDownloadFaultType.PROGRAM_ERROR.toString());
		}
		InetAddress inetAddress = null;
		
		try {
			inetAddress = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			System.out.println("failed to get the local host");
		}
		if(inetAddress != null) 
			retAddress = inetAddress.getHostAddress()+":8080/"+eventSetId+".csv";
		
		retAddress = "http://tlan184.srvr:8080/"+eventSetId+".csv";
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
	private int getMonthNum(String month) {
		 if(month.equals("JAN"))
			 return 0;
		 else if(month.equals("FEB"))
			 return 1;
		 else if(month.equals("MAR"))
			 return 2;
		 else if(month.equals("APR"))
			 return 3;
		 else if(month.equals("MAY"))
			 return 4;
		 else if(month.equals("JUN"))
			 return 5;
		 else if(month.equals("JUL"))
			 return 6;
		 else if(month.equals("AUG"))
			 return 7;
		 else if(month.equals("SEP"))
			 return 8;
		 else if(month.equals("OCT"))
			 return 9;
		 else if(month.equals("NOV"))
			 return 10;
		 else if(month.equals("DEC"))
			 return 11;
		 else
			 return 13;
		
	}

}
