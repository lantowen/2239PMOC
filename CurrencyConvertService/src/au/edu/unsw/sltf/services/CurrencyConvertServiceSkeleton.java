
/**
 * CurrencyConvertServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package au.edu.unsw.sltf.services;

//import au.edu.unsw.sltf.services.CurrencyConvertServiceSkeletonInterface;
//import au.edu.unsw.sltf.services.CurrencyConvertMarketDataDocument;
//import au.edu.unsw.sltf.services.CurrencyConvertFaultException;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import au.edu.unsw.sltf.services.CurrencyConvertFaultDocument.CurrencyConvertFault;
import au.edu.unsw.sltf.services.CurrencyConvertMarketDataDocument.CurrencyConvertMarketData;
import au.edu.unsw.sltf.services.CurrencyConvertMarketDataResponseDocument.CurrencyConvertMarketDataResponse;

/**
 *  CurrencyConvertServiceSkeleton java skeleton for the axisService
 */
public class CurrencyConvertServiceSkeleton implements CurrencyConvertServiceSkeletonInterface{


	/**
	 * Auto generated method signature
	 * 
	 * @param currencyConvertMarketData0 
	 * @return currencyConvertMarketDataResponse1 
	 * @throws CurrencyConvertFaultException 
	 */
	
	private static CurrencyConverter converter = new CurrencyConverter();
	private static String path = System.getenv("CATALINA_BASE");
	private static String private_dir = path + "/temp/";
	private static String public_dir = path + "/webapps/ROOT/";

	public CurrencyConvertMarketDataResponseDocument currencyConvertMarketData(CurrencyConvertMarketDataDocument reqDoc) 
			throws CurrencyConvertFaultException {
		CurrencyConvertMarketData req = reqDoc.getCurrencyConvertMarketData();
		String reqEventSetId = validateEventSetId(req.getEventSetId());
		String reqCurrency = validateCurrency(req.getTargetCurrency());
		String resEventSetId;

		try {
			resEventSetId = convertFile(reqEventSetId, reqCurrency);
//			System.out.println("currency convert test:" + converter.convertAUD(1, reqCurrency));
		} catch (UnconvertableCurrencyException e) {
			throw createFault(CurrencyConvertFaultType.INVALID_CURRENCY, "Invalid currency: " + reqCurrency);
		} catch (IOException e) {
			throw createFault(CurrencyConvertFaultType.PROGRAM_ERROR, "Error reading or writing file: " + e.getMessage());
		}
		
		// create response document
		CurrencyConvertMarketDataResponseDocument resDoc = CurrencyConvertMarketDataResponseDocument.Factory.newInstance();
		CurrencyConvertMarketDataResponse res = resDoc.addNewCurrencyConvertMarketDataResponse();
		res.setEventSetId(resEventSetId);
		
		return resDoc;
	}
	
	private String validateCurrency(String currency) throws CurrencyConvertFaultException {
		String resCurrency = currency.toUpperCase();
		if (!converter.isValidCurrency(resCurrency))
			throw createFault(CurrencyConvertFaultType.INVALID_CURRENCY, 
					"Invalid currency: " + resCurrency);
		if (resCurrency.equals("AUD"))
			throw createFault(CurrencyConvertFaultType.INVALID_CURRENCY, 
					"Cannot convert to AUD");
		return resCurrency;
	}

	private String validateEventSetId(String eventSetId) throws CurrencyConvertFaultException {
		Pattern pat = Pattern.compile("\\d+(-([A-Z]{3}))?");
		Matcher m = pat.matcher(eventSetId);
		if (m.matches()) {
			String currency = m.group(2);
            System.out.println(currency);
			if (currency != null) {
                if (!converter.isValidCurrency(currency))
                    throw createFault(CurrencyConvertFaultType.INVALID_EVENT_SET_ID, 
                            "Invalid format for EventSetId: " + eventSetId);
                else
                    throw createFault(CurrencyConvertFaultType.INVALID_EVENT_SET_ID, 
                            "Cannot convert EventSetIds of this format: " + eventSetId);
			}
		} else {
            throw createFault(CurrencyConvertFaultType.INVALID_EVENT_SET_ID, 
                    "Invalid format for EventSetId: " + eventSetId);
		}
			
		return eventSetId;
	}
	
	private boolean isConverted(String eventSetId) {
		return eventSetId.matches("\\d+-[A-Z]{3}");
	}
	
	private boolean isValidEventSetId(String eventSetId) {
		return eventSetId.matches("\\d+(-[A-Z]{3})?");
	}
	
	private String convertFile(String eventSetId, String currency) throws UnconvertableCurrencyException, CurrencyConvertFaultException, IOException {
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(private_dir + eventSetId + ".csv"));
		} catch (FileNotFoundException e1) {
            throw createFault(CurrencyConvertFaultType.INVALID_EVENT_SET_ID, 
                    "EventSetId does not exist: " + eventSetId);
		}

        String resEventSetId = eventSetId + "-" + currency;
        System.out.println(private_dir + resEventSetId);
        PrintWriter writer;

		try {
			writer = new PrintWriter(private_dir + resEventSetId + ".csv", "UTF-8");
		} catch (FileNotFoundException e1) {
			reader.close();
            throw createFault(CurrencyConvertFaultType.PROGRAM_ERROR, 
                    "Could not write file: " + e1.getMessage());
		} catch (UnsupportedEncodingException e1) {
			reader.close();
            throw createFault(CurrencyConvertFaultType.PROGRAM_ERROR, 
                    "Could not write file: " + e1.getMessage());
		}

        String inLine;
        while ((inLine = reader.readLine()) != null) {
            String[] result = inLine.split(",", -1);
            if (result.length != 11) {
            	reader.close();
            	writer.close();
                throw createFault(CurrencyConvertFaultType.INVALID_MARKET_DATA, 
                        "Corrupted file - Line does not have 11 fields: " + inLine);
            }
            String priceStr = result[5]; // Note: empty string is valid

            // No conversion on empty string, append currency code on valid numbers
            if (priceStr.equals("")) {
                writer.println(inLine);
            } else {
            	try {
                    double price = Double.parseDouble(priceStr);
                    double resPrice = converter.convertAUD(price, currency);
            		result[5] = currency + String.valueOf(resPrice);
            		writer.println(joinString(result, ","));
            	} catch (NumberFormatException e) {
                    reader.close();
                    writer.close();
                    throw createFault(CurrencyConvertFaultType.INVALID_MARKET_DATA, 
                            "Corrupted file - Invalid price: " + inLine);
            	}
            }
        }

        reader.close();
        writer.close();
        return resEventSetId;
	}
	
	private CurrencyConvertFaultException createFault(CurrencyConvertFaultType.Enum type, String message) {
        CurrencyConvertFaultException e = new CurrencyConvertFaultException();
        CurrencyConvertFaultDocument fDoc = CurrencyConvertFaultDocument.Factory.newInstance();
        CurrencyConvertFault f = fDoc.addNewCurrencyConvertFault();
        f.setFaultType(type);
        f.setFaultMessage(message);
        e.setFaultMessage(fDoc);
        return e;
	}
	
	private String joinString(String[] strings, String delim) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (i > 0)
                sb.append(delim);
            sb.append(strings[i]);
        }
        return sb.toString();
	}

}
