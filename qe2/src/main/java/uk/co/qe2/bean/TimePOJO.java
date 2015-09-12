package uk.co.qe2.bean;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class TimePOJO {	
	static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private XMLGregorianCalendar xmlTime;

	public XMLGregorianCalendar getXmlTime() {
		try {
			
			 Calendar cal = Calendar.getInstance();
			 cal = Calendar.getInstance();
			 cal.add(Calendar.MINUTE, -5);
		//	xmlTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(timeFormat.format(new Date()));
			xmlTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(timeFormat.format(cal.getTime()));
		} catch (DatatypeConfigurationException e) {			
			e.printStackTrace();
		}
		
		return xmlTime;
	}

	public void setXmlTime(XMLGregorianCalendar xmlTime) {					
		this.xmlTime = xmlTime;
	}
	
	
}
