package uk.co.qe2.component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

import uk.co.nivi.qe2.CrossingStatementList;
import uk.co.nivi.qe2.CrossingStatementList.CrossingStatement;
import uk.co.nivi.qe2.CrossingStatementList.CrossingStatement.AccountEntry;


	public class BuildXML implements Callable {
		
		String returnStatus = "ok";
		String returnStatusText = "";
		ByteArrayOutputStream Os1 = null;		
		JAXBContext jaxbcontextinput = null;
		JAXBContext jaxbcontextoutput = null;

		uk.co.nivi.qe2.CrossingStatementList inputCSL = null;  //input xml
		uk.co.nivi.qe2.CrossingStatementList outputCSL = null; //output xml
				
		
		@Override
		public Object onCall(MuleEventContext eventContext) throws Exception {
			try
			{
											
				JAXBContext jaxbContext = JAXBContext.newInstance(CrossingStatementList.class);
				MuleMessage msg = eventContext.getMessage();
				byte[] Bain = msg.getPayloadAsBytes();
		
				InputStream is = null;
				is = new ByteArrayInputStream(Bain);		

				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				inputCSL = (uk.co.nivi.qe2.CrossingStatementList)unmarshaller.unmarshal(is);
				Os1 = new ByteArrayOutputStream( );		
				
				inputCSL = getEnrichedJavaObject(inputCSL);
			
								
				try
				{				
					javax.xml.bind.Marshaller jaxbMarshaller = jaxbContext.createMarshaller();					
					jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
					jaxbMarshaller.marshal(inputCSL,Os1);			
				
				}
				catch (JAXBException e) 
				{
					e.printStackTrace();
					returnStatus = "Failed";
					returnStatusText = "Build XML - Failed JAXB formatting";
				}
				
				
				}
				catch (Exception e)
				{
					e.printStackTrace();
					returnStatus = "Failed";
					returnStatusText = "Build XML - General failure";
				}
				
				eventContext.getMessage().setSessionProperty("returnstatus", returnStatus);
				eventContext.getMessage().setSessionProperty("returnstatustext", returnStatusText);		
				
				return Os1;		
				
		}
		

		
		private CrossingStatementList getEnrichedJavaObject(
				CrossingStatementList inputCSL) {
						
			
			outputCSL= new CrossingStatementList();
			outputCSL = inputCSL;		
						
			List<CrossingStatementList.CrossingStatement> csList = new ArrayList<CrossingStatementList.CrossingStatement>();								
					
			AccountEntry ae=  new AccountEntry();		
			csList= inputCSL.getCrossingStatement();
			
		     for(CrossingStatement cs : csList){
		    	    ae = cs.getAccountEntry();   		    		
		    	    if(isObjectNull(ae.getStartTime())){
		    	    	ae.setStartTime(cs.getTimeGenerated());
		    	    }		
		    	    uk.co.nivi.qe2.CrossingStatementList.CrossingStatement.AccountEntry.AmountPayable ap = ae.getAmountPayable();		    	    
		    	    float dDefault = 500.0f;		    	   
		    	   // if(isObjectNull(ap.getAmount()))  
		    	    ap.setAmount(dDefault);	       
			     
		     }		     
		     
		     outputCSL = inputCSL;		     
			return outputCSL;
		}
				
			
				
		private static boolean isObjectNull(Object obj){
		    if(obj != null && obj != "" &&  obj.toString().length() > 0){	
				return false;
			}
			else {		
				return true;
			}		
		}
	}