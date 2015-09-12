package uk.co.qe2.component;

import javax.xml.bind.JAXBContext;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class JaxbContextCreateInput implements Callable {
	
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		JAXBContext jcIn = JAXBContext.newInstance("uk.co.nivi.qe2");

		return jcIn;
		
	}
}
