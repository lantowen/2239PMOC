<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Import/Download Market Data Service</title>
</head>
<body>
<a href="index.jsp">Home</a>
<hr>
<h1>Import/Download Market Data Service</h1>
This service allows users to filter a Market Data file. Users can filter to see the trades of a particular security during a certain time frame.

<h2>SOAP WSDL</h2>
<a href="http://tlan184.srvr:8080/axis2/services/ImportDownloadService?wsdl">
http://mcho421.srvr:8080/axis2/services/ImportDownloadService?wsdl
</a>

<h2>Demo</h2>
TODO: put client here

<h2>Parameters</h2>
<h3>Operation: importMarketData</h3>
<table width="85%" border=1>
	<tr><td>Name</td><td>Type</td><td>Description</td><td>Example</td></tr>
	<tr><td>sec</td><td>String</td><td>The security code of the financial instrument to filter for.</td><td>ABCD</td></tr>
	<tr><td>startDate</td><td>dateTime</td><td>Filter market activity occuring after this timestamp (inclusive).</td><td>1992-12-23T11:22:33</td></tr>
	<tr><td>endDate</td><td>dateTime</td><td>Filter market activity before this timestamp (inclusive).</td><td>2014-02-23T23:22:33</td></tr>
	<tr><td>dataSourceURL</td><td>URL</td><td>URL that points to an input Market Data file.</td><td>http://www.cse.unsw.edu.au/~hpaik/9322/assignments/
	common/files_csv_spec/FinDataSimple.csv</td></tr>
</table>
<br/>The result of this operation is an eventSetId string which can be used to refer to the filtered data file.

<h3>Operation: downloadFile</h3>
<table width="85%" border=1>
	<tr><td>Name</td><td>Type</td><td>Description</td><td>Example</td></tr>
	<tr><td>eventSetId</td><td>String</td><td>An ID that refers to the filtered Market Data file.</td><td>123</td></tr>
</table>
<br/>The result of this operation is a URL to download the filtered file.

<h2>Error Codes</h2>
<h3>Operation: importMarketData</h3>
<table width="85%" border=1>
	<tr><td>Fault Type</td><td>Fault Message</td><td>Cause</td><td>Resolution</td></tr>
	<tr><td>InvalidEventSetId</td><td>???</td><td>???</td><td>123</td></tr>
	<tr><td>InvalidURL</td><td>???</td><td>???</td><td>123</td></tr>
	<tr><td>InvalidSECCode</td><td>???</td><td>???</td><td>123</td></tr>
	<tr><td>ProgramError</td><td>???</td><td>???</td><td>123</td></tr>
</table>

</body>
</html>