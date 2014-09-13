
/**
 * CurrencyConvertFaultException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package au.edu.unsw.sltf.client;

public class CurrencyConvertFaultException extends java.lang.Exception{

    private static final long serialVersionUID = 1410584509765L;
    
    private au.edu.unsw.sltf.services.CurrencyConvertFaultDocument faultMessage;

    
        public CurrencyConvertFaultException() {
            super("CurrencyConvertFaultException");
        }

        public CurrencyConvertFaultException(java.lang.String s) {
           super(s);
        }

        public CurrencyConvertFaultException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public CurrencyConvertFaultException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(au.edu.unsw.sltf.services.CurrencyConvertFaultDocument msg){
       faultMessage = msg;
    }
    
    public au.edu.unsw.sltf.services.CurrencyConvertFaultDocument getFaultMessage(){
       return faultMessage;
    }
}
    