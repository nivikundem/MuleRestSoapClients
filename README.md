#Mule Demo for using - EXCEL_To_XML Using java objects and sending the xml using REST and SOAP clients 
#Converting XLS to XML using JAVA objects , and sending the xml using REST and SOAP clients  using MULE ESB

Mule Demo for using - XLS-to-XML using java Project, sending  using REST and SOAP clients
--------------
Demo for converting XLS message using java Project, sending  using REST and SOAP clients and MULE ESB


This project 
---------
1.	Reads excel sheet from the input folder and converts into the JAVA obejct[EXCEL - TO -JAVA objects]
2.	Reads the java objects convert into the xml using jaxb-xml-to-object-transformer
3.	Invoking REST and SOAP clients 


Mule components
---------
1.	File connectors
2.	Context property place folders
3. 	FileInbound
4.	Message Properties transformer
5.	Java Component - to convert xls to javaobject
6.	FileOutbound
7.	Enricher
9.	Flow Ref
10.	Sub flow
11.	For-each
12.	Choice
13.	VM Inbound/Outbound
14.	Object-to-string-transformer
15.	jaxb-xml-to-object-transformer
16.	SOAP client
17.	REST client



To Run
-------
Run as mule server or deploy into the mule sever as Mule Deployable Archive war,  by copy into the mule-standalone/apps


Technologies
---------
- J2E
- MySQL
- Mule Anypointstudio
