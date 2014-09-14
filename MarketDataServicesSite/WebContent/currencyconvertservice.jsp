<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Currency Convert Service</title>
</head>
<body>
<a href="index.jsp">Home</a>
<hr>
<h1>Currency Convert Service</h1>
This service converts an imported Market Data file from AUD to another currency. 
This uses a fixed currency conversion rate as of 20th August 2014 from <a href="http://www.xe.com/currencytables/?from=AUD&date=2014-08-20">XE.com</a>.

<h2>SOAP WSDL</h2>
<a href="http://tlan184.srvr:8080/axis2/services/CurrencyConvertService?wsdl">
http://mcho421.srvr:8080/axis2/services/CurrencyConvertService?wsdl
</a>

<h2>Demo</h2>
<form action="CurrencyConvertServlet">
<table>
<tr>
<td>EventSetId :</td><td> <input type = "text" name="EventSetId"></td>
</tr>
<tr>
<td>TargetCurrency:</td><td> <input name="TargetCurrency" type="text"></td>
</tr>
<tr><td><font color =red>${message}</font></td></tr>
<tr>
<td><input type="submit" value ="submit"></td>		
</table>			
</form>

<h2>Parameters</h2>
<h3>Operation: currencyConvertMarketData</h3>
<table width="85%" border=1>
	<tr><td>Name</td><td>Type</td><td>Description</td><td>Example</td></tr>
	<tr><td>eventSetId</td><td>String</td><td>An ID that refers to an imported (but not converted) Market Data file.</td><td>123</td></tr>
	<tr><td>targetCurrency</td><td>String</td><td>3 letter currency code denoting which currency to convert to</td><td>USD</td></tr>
</table>
<br/>The result of this operation is an eventSetId string which can be used to refer to the converted data file.

<h2>Error Codes</h2>
<h3>Operation: currencyConvertMarketData</h3>
<table width="85%" border=1>
	<tr><td>Fault Type</td><td>Fault Message</td><td>Cause</td><td>Resolution</td></tr>
	<tr><td>InvalidEventSetId</td><td>???</td><td>???</td><td>123</td></tr>
	<tr><td>InvalidCurrency</td><td>???</td><td>???</td><td>123</td></tr>
	<tr><td>InvalidMarketData</td><td>???</td><td>???</td><td>123</td></tr>
	<tr><td>ProgramError</td><td>???</td><td>???</td><td>123</td></tr>
</table>

</body>
</html>