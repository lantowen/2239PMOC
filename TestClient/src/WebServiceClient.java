import au.edu.unsw.sltf.client.CurrencyConvertServiceStub;
import au.edu.unsw.sltf.services.CurrencyConvertMarketDataDocument;
import au.edu.unsw.sltf.services.CurrencyConvertMarketDataDocument.CurrencyConvertMarketData;
import au.edu.unsw.sltf.services.CurrencyConvertMarketDataResponseDocument;
import au.edu.unsw.sltf.services.CurrencyConvertMarketDataResponseDocument.CurrencyConvertMarketDataResponse;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Web service client that connects to the TopDownSimpleServices
 * Web service.
 */
public class WebServiceClient {

    public static void main(String[] args) {
        String wsURL = "http://localhost:8080/axis2/services/CurrencyConvertService";
        try {
            CurrencyConvertServiceStub stub = new CurrencyConvertServiceStub(wsURL);
            System.out.println("The output of importMarketData operation is: ");
            System.out.println(callCurrencyConvert(stub));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String callCurrencyConvert(CurrencyConvertServiceStub stub) throws Exception {
        // Ready the request for rdthImport operation.
        CurrencyConvertMarketDataDocument reqDoc = CurrencyConvertMarketDataDocument.Factory.newInstance();
        CurrencyConvertMarketData req = reqDoc.addNewCurrencyConvertMarketData();
        req.setEventSetId("0");
        req.setTargetCurrency("USD");

        // Use the stub (from generated code) to make the call.
        CurrencyConvertMarketDataResponseDocument respDoc = stub.currencyConvertMarketData(reqDoc);
        CurrencyConvertMarketDataResponse resp = respDoc.getCurrencyConvertMarketDataResponse();
        String result = resp.getEventSetId();

        return result;
    }
}

