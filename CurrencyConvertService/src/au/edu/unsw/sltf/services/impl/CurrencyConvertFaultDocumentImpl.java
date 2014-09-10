/*
 * An XML document type.
 * Localname: currencyConvertFault
 * Namespace: http://sltf.unsw.edu.au/services
 * Java type: au.edu.unsw.sltf.services.CurrencyConvertFaultDocument
 *
 * Automatically generated - do not modify.
 */
package au.edu.unsw.sltf.services.impl;
/**
 * A document containing one currencyConvertFault(@http://sltf.unsw.edu.au/services) element.
 *
 * This is a complex type.
 */
public class CurrencyConvertFaultDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements au.edu.unsw.sltf.services.CurrencyConvertFaultDocument
{
    
    public CurrencyConvertFaultDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CURRENCYCONVERTFAULT$0 = 
        new javax.xml.namespace.QName("http://sltf.unsw.edu.au/services", "currencyConvertFault");
    
    
    /**
     * Gets the "currencyConvertFault" element
     */
    public au.edu.unsw.sltf.services.CurrencyConvertFaultDocument.CurrencyConvertFault getCurrencyConvertFault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            au.edu.unsw.sltf.services.CurrencyConvertFaultDocument.CurrencyConvertFault target = null;
            target = (au.edu.unsw.sltf.services.CurrencyConvertFaultDocument.CurrencyConvertFault)get_store().find_element_user(CURRENCYCONVERTFAULT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "currencyConvertFault" element
     */
    public void setCurrencyConvertFault(au.edu.unsw.sltf.services.CurrencyConvertFaultDocument.CurrencyConvertFault currencyConvertFault)
    {
        synchronized (monitor())
        {
            check_orphaned();
            au.edu.unsw.sltf.services.CurrencyConvertFaultDocument.CurrencyConvertFault target = null;
            target = (au.edu.unsw.sltf.services.CurrencyConvertFaultDocument.CurrencyConvertFault)get_store().find_element_user(CURRENCYCONVERTFAULT$0, 0);
            if (target == null)
            {
                target = (au.edu.unsw.sltf.services.CurrencyConvertFaultDocument.CurrencyConvertFault)get_store().add_element_user(CURRENCYCONVERTFAULT$0);
            }
            target.set(currencyConvertFault);
        }
    }
    
    /**
     * Appends and returns a new empty "currencyConvertFault" element
     */
    public au.edu.unsw.sltf.services.CurrencyConvertFaultDocument.CurrencyConvertFault addNewCurrencyConvertFault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            au.edu.unsw.sltf.services.CurrencyConvertFaultDocument.CurrencyConvertFault target = null;
            target = (au.edu.unsw.sltf.services.CurrencyConvertFaultDocument.CurrencyConvertFault)get_store().add_element_user(CURRENCYCONVERTFAULT$0);
            return target;
        }
    }
    /**
     * An XML currencyConvertFault(@http://sltf.unsw.edu.au/services).
     *
     * This is a complex type.
     */
    public static class CurrencyConvertFaultImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements au.edu.unsw.sltf.services.CurrencyConvertFaultDocument.CurrencyConvertFault
    {
        
        public CurrencyConvertFaultImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName FAULTTYPE$0 = 
            new javax.xml.namespace.QName("http://sltf.unsw.edu.au/services", "faultType");
        private static final javax.xml.namespace.QName FAULTMESSAGE$2 = 
            new javax.xml.namespace.QName("http://sltf.unsw.edu.au/services", "faultMessage");
        
        
        /**
         * Gets the "faultType" element
         */
        public au.edu.unsw.sltf.services.CurrencyConvertFaultType.Enum getFaultType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FAULTTYPE$0, 0);
                if (target == null)
                {
                    return null;
                }
                return (au.edu.unsw.sltf.services.CurrencyConvertFaultType.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "faultType" element
         */
        public au.edu.unsw.sltf.services.CurrencyConvertFaultType xgetFaultType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                au.edu.unsw.sltf.services.CurrencyConvertFaultType target = null;
                target = (au.edu.unsw.sltf.services.CurrencyConvertFaultType)get_store().find_element_user(FAULTTYPE$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "faultType" element
         */
        public void setFaultType(au.edu.unsw.sltf.services.CurrencyConvertFaultType.Enum faultType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FAULTTYPE$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FAULTTYPE$0);
                }
                target.setEnumValue(faultType);
            }
        }
        
        /**
         * Sets (as xml) the "faultType" element
         */
        public void xsetFaultType(au.edu.unsw.sltf.services.CurrencyConvertFaultType faultType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                au.edu.unsw.sltf.services.CurrencyConvertFaultType target = null;
                target = (au.edu.unsw.sltf.services.CurrencyConvertFaultType)get_store().find_element_user(FAULTTYPE$0, 0);
                if (target == null)
                {
                    target = (au.edu.unsw.sltf.services.CurrencyConvertFaultType)get_store().add_element_user(FAULTTYPE$0);
                }
                target.set(faultType);
            }
        }
        
        /**
         * Gets the "faultMessage" element
         */
        public java.lang.String getFaultMessage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FAULTMESSAGE$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "faultMessage" element
         */
        public org.apache.xmlbeans.XmlString xgetFaultMessage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FAULTMESSAGE$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "faultMessage" element
         */
        public void setFaultMessage(java.lang.String faultMessage)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FAULTMESSAGE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FAULTMESSAGE$2);
                }
                target.setStringValue(faultMessage);
            }
        }
        
        /**
         * Sets (as xml) the "faultMessage" element
         */
        public void xsetFaultMessage(org.apache.xmlbeans.XmlString faultMessage)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FAULTMESSAGE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FAULTMESSAGE$2);
                }
                target.set(faultMessage);
            }
        }
    }
}
