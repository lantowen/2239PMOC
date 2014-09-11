
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



import java.util.HashMap;

import au.edu.unsw.sltf.services.CurrencyConvertFaultDocument.CurrencyConvertFault;
import au.edu.unsw.sltf.services.CurrencyConvertMarketDataDocument.CurrencyConvertMarketData;

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

	public CurrencyConvertMarketDataResponseDocument currencyConvertMarketData(CurrencyConvertMarketDataDocument reqDoc) 
			throws CurrencyConvertFaultException {
		CurrencyConvertMarketData req = reqDoc.getCurrencyConvertMarketData();
		String reqCurrency = req.getTargetCurrency().toUpperCase();
		
		// TODO what if convert to AUD?

		try {
			System.out.println("currency convert test:" + converter.convertAUD(1, reqCurrency));
		} catch (UnconvertableCurrencyException e) {
			throw createFault(CurrencyConvertFaultType.INVALID_CURRENCY, "Invalid currency: " + reqCurrency);
		}

		throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#currencyConvertMarketData");
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

}
