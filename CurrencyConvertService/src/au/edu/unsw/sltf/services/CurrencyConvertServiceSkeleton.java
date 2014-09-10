
/**
 * CurrencyConvertServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package au.edu.unsw.sltf.services;

import au.edu.unsw.sltf.services.CurrencyConvertServiceSkeletonInterface;
import au.edu.unsw.sltf.services.CurrencyConvertMarketDataDocument;
import au.edu.unsw.sltf.services.CurrencyConvertFaultException;



import java.util.HashMap;

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
	
	private static HashMap<String, Double> unitsPerAUD;
	
	static {
		unitsPerAUD.put("USD",0.9307674541);
		unitsPerAUD.put("EUR",0.7006667524);
		unitsPerAUD.put("GBP",0.5595633550);
		unitsPerAUD.put("INR",56.3764094347);
		unitsPerAUD.put("AUD",1.0000000000);
		unitsPerAUD.put("CAD",1.0186495032);
		unitsPerAUD.put("AED",3.4187553290);
		unitsPerAUD.put("MYR",2.9504323013);
		unitsPerAUD.put("CHF",0.8485060621);
		unitsPerAUD.put("CNY",5.7169778027);
		unitsPerAUD.put("THB",29.7530912155);
		unitsPerAUD.put("SAR",3.4906575553);
		unitsPerAUD.put("NZD",1.1074715799);
		unitsPerAUD.put("JPY",96.2122312587);
		unitsPerAUD.put("SGD",1.1633573960);
		unitsPerAUD.put("PHP",40.8329652890);
		unitsPerAUD.put("TRY",2.0247864441);
		unitsPerAUD.put("HKD",7.2140630051);
		unitsPerAUD.put("IDR",10904.8306722706);
		unitsPerAUD.put("ZAR",9.9594464736);
		unitsPerAUD.put("MXN",12.1762503367);
		unitsPerAUD.put("SEK",6.4237039867);
		unitsPerAUD.put("BRL",2.0978791032);
		unitsPerAUD.put("HUF",220.3320163609);
		unitsPerAUD.put("PKR",94.1936635125);
		unitsPerAUD.put("QAR",3.3892500977);
		unitsPerAUD.put("OMR",0.3583687340);
		unitsPerAUD.put("KWD",0.2641518090);
		unitsPerAUD.put("DKK",5.2242123886);
		unitsPerAUD.put("NOK",5.7477165037);
		unitsPerAUD.put("RUB",33.7327115669);
		unitsPerAUD.put("EGP",6.6554991151);
		unitsPerAUD.put("KRW",952.2142051678);
		unitsPerAUD.put("PLN",2.9342110919);
		unitsPerAUD.put("COP",1779.8042282476);
		unitsPerAUD.put("CZK",19.5741059554);
		unitsPerAUD.put("ILS",3.2925802265);
		unitsPerAUD.put("IQD",1082.4825490957);
		unitsPerAUD.put("NGN",151.0635606378);
		unitsPerAUD.put("MAD",7.8216660698);
		unitsPerAUD.put("ARS",7.7104779589);
		unitsPerAUD.put("LKR",121.1625994479);
		unitsPerAUD.put("TWD",27.9051526203);
		unitsPerAUD.put("BDT",72.2927064542);
		unitsPerAUD.put("BHD",0.3509226070);
		unitsPerAUD.put("VND",19713.6546774267);
		unitsPerAUD.put("CLP",542.8381789978);
		unitsPerAUD.put("KES",82.1867690358);
		unitsPerAUD.put("TND",1.6023160976);
		unitsPerAUD.put("XOF",459.6072608795);
		unitsPerAUD.put("JOD",0.6584714654);
		unitsPerAUD.put("GHS",3.4671086777);
		unitsPerAUD.put("HRK",5.3385769273);
		unitsPerAUD.put("BGN",1.3704211061);
		unitsPerAUD.put("RON",3.0955357462);
		unitsPerAUD.put("PEN",2.6322104241);
		unitsPerAUD.put("DZD",74.6063530050);
		unitsPerAUD.put("NPR",90.9708609480);
		unitsPerAUD.put("XAF",459.6072608795);
		unitsPerAUD.put("ISK",108.3134093246);
		unitsPerAUD.put("UAH",12.3121915914);
		unitsPerAUD.put("FJD",1.7169741020);
		unitsPerAUD.put("DOP",40.5814595777);
		unitsPerAUD.put("XPF",83.6117842915);
		unitsPerAUD.put("MUR",28.9840979520);
		unitsPerAUD.put("AZN",0.7299075409);
		unitsPerAUD.put("BAM",1.3703850543);
		unitsPerAUD.put("XAU",0.0007191858);
		unitsPerAUD.put("IRR",24736.0758596455);
		unitsPerAUD.put("RSD",82.3361582382);
		unitsPerAUD.put("LTL",2.4192621626);
		unitsPerAUD.put("BND",1.1633573960);
		unitsPerAUD.put("ETB",18.4682971127);
		unitsPerAUD.put("CRC",504.2897952590);
		unitsPerAUD.put("VEF",5.8568542226);
		unitsPerAUD.put("AFN",51.7506690266);
		unitsPerAUD.put("TZS",1552.0547296794);
		unitsPerAUD.put("UGX",2419.9953806095);
		unitsPerAUD.put("JMD",112.9000801876);
		unitsPerAUD.put("GEL",1.6054650334);
		unitsPerAUD.put("ZWD",336.8447416318);
		unitsPerAUD.put("BWP",8.2369165711);
		unitsPerAUD.put("CUC",0.9307674541);
		unitsPerAUD.put("ZMW",5.6032204996);
		unitsPerAUD.put("MMK",906.5675002745);
		unitsPerAUD.put("GTQ",7.2813937507);
		unitsPerAUD.put("XCD",2.5130721285);
		unitsPerAUD.put("LYD",1.1441924519);
		unitsPerAUD.put("MKD",43.0759166387);
		unitsPerAUD.put("TTD",5.9094425447);
		unitsPerAUD.put("MZN",28.2487925864);
		unitsPerAUD.put("ALL",97.6601306602);
		unitsPerAUD.put("BOB",6.4316029657);
		unitsPerAUD.put("KZT",169.2647255875);
		unitsPerAUD.put("BBD",1.8615349082);
		unitsPerAUD.put("AOA",90.9529930210);
		unitsPerAUD.put("KHR",3774.2620262968);
		unitsPerAUD.put("XAG",0.0476860718);
		unitsPerAUD.put("AMD",379.5100830077);
		unitsPerAUD.put("UYU",22.2267277976);
		unitsPerAUD.put("MOP",7.4304848952);
		unitsPerAUD.put("NAD",9.9594464736);
		unitsPerAUD.put("LBP",1405.9242393887);
		unitsPerAUD.put("LAK",7482.9049470808);
		unitsPerAUD.put("BYR",9663.6930919916);
		unitsPerAUD.put("MGA",2373.4570079055);
		unitsPerAUD.put("SYP",141.8024273101);
		unitsPerAUD.put("VUV",87.8179078723);
		unitsPerAUD.put("PGK",2.2897460393);
		unitsPerAUD.put("MNT",1724.2467086843);
		unitsPerAUD.put("SDG",5.2983938389);
		unitsPerAUD.put("ANG",1.6505298635);
		unitsPerAUD.put("MWK",368.2581375260);
		unitsPerAUD.put("GMD",37.3703147016);
		unitsPerAUD.put("CUP",24.6653375331);
		unitsPerAUD.put("RWF",640.3680084074);
		unitsPerAUD.put("MVR",14.3058965503);
		unitsPerAUD.put("BTN",56.3764094347);
		unitsPerAUD.put("SCR",12.0301695215);
		unitsPerAUD.put("HNL",19.6019620859);
		unitsPerAUD.put("KPW",121.3259628065);
		unitsPerAUD.put("PYG",3967.8616567455);
		unitsPerAUD.put("DJF",168.6550598389);
		unitsPerAUD.put("XBT",0.0018339876);
		unitsPerAUD.put("YER",200.0219202010);
		unitsPerAUD.put("CDF",850.7214530297);
		unitsPerAUD.put("WST",2.1436376739);
		unitsPerAUD.put("GYD",191.4588624639);
		unitsPerAUD.put("AWG",1.6660737428);
		unitsPerAUD.put("MDL",12.8771677627);
		unitsPerAUD.put("BZD",1.8590218628);
		unitsPerAUD.put("HTG",41.6053059075);
		unitsPerAUD.put("KGS",48.4777240548);
		unitsPerAUD.put("NIO",24.3162946314);
		unitsPerAUD.put("CVE",76.2298488082);
		unitsPerAUD.put("KYD",0.7632294345);
		unitsPerAUD.put("GNF",6582.3874352579);
		unitsPerAUD.put("BSD",0.9307674541);
		unitsPerAUD.put("BIF",1428.7280420137);
		unitsPerAUD.put("SLL",4095.3767979546);
		unitsPerAUD.put("MRO",270.6671642847);
		unitsPerAUD.put("TOP",1.7188688857);
		unitsPerAUD.put("BMD",0.9307674541);
		unitsPerAUD.put("SBD",6.7154938967);
		unitsPerAUD.put("UZS",2182.0828837899);
		unitsPerAUD.put("SOS",1115.9745984372);
		unitsPerAUD.put("PAB",0.9307674541);
		unitsPerAUD.put("SRD",3.0482635009);
		unitsPerAUD.put("XDR",0.6107230605);
		unitsPerAUD.put("SZL",9.9594464736);
		unitsPerAUD.put("ERN",9.7451325672);
		unitsPerAUD.put("LRD",86.0959163209);
		unitsPerAUD.put("TJS",4.6319513005);
		unitsPerAUD.put("TMT",2.6526872441);
		unitsPerAUD.put("GIP",0.5595633550);
		unitsPerAUD.put("LSL",9.9594464736);
		unitsPerAUD.put("KMF",344.7054456596);
		unitsPerAUD.put("SVC",8.1442152232);
		unitsPerAUD.put("GGP",0.5595633550);
		unitsPerAUD.put("XPT",0.0006513563);
		unitsPerAUD.put("STD",17177.3133650571);
		unitsPerAUD.put("IMP",0.5595633550);
		unitsPerAUD.put("FKP",0.5595633550);
		unitsPerAUD.put("XPD",0.0010716932);
		unitsPerAUD.put("JEP",0.5595633550);
		unitsPerAUD.put("SHP",0.5595633550);
		unitsPerAUD.put("SPL",0.1551279090);
		unitsPerAUD.put("TVD",1.0000000000);

	}

	public CurrencyConvertMarketDataResponseDocument currencyConvertMarketData(CurrencyConvertMarketDataDocument currencyConvertMarketData0) 
			throws CurrencyConvertFaultException{
		System.out.println("currency convert test");

		throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#currencyConvertMarketData");
	}

}
