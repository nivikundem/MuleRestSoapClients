package uk.co.qe2.component;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import uk.co.nivi.qe2.CrossingStatementList;
import uk.co.nivi.qe2.CrossingStatementList.CrossingStatement;
import uk.co.nivi.qe2.CrossingStatementList.CrossingStatement.AccountEntry;
import uk.co.nivi.qe2.CrossingStatementList.CrossingStatement.AccountEntry.AmountPayable;
import uk.co.qe2.bean.PrIDPOJO;
import uk.co.qe2.bean.TimePOJO;


public class FileValidator {

	/**
	 * @param args
	 */

		public static void main(String[] args) {
		
			  
			File folder = new File("C:\\ESB\\Files\\NONARC\\Daily\\In");
			File[] listOfFiles  =folder.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
			    
			    	  String fileName = "C:\\ESB\\Files\\NONARC\\Daily\\In\\"+(listOfFiles[i].getName());
			    	  System.out.println(fileName);
    	        	getExcelToXML(fileName);
    	        	System.out.println("fileName  successfull "+fileName);
			         	  
			      }
			}


		public static File[] getFiles(){
		File folder = new File("C:\\ESB\\Files\\NONARC\\Daily\\In");
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println("File ::: " + listOfFiles[i].getName());
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
			return listOfFiles;
		    
		}
		
		

		public static String getExcelToXML(String filePath){	
		
			List<CrossingStatementList.CrossingStatement> prrList = getPremiumReconciliationRsList(filePath);					
			ByteArrayOutputStream Os1 = getExcelToJavaObj(prrList);				
			System.out.println(Os1.toString());
			return (Os1.toString());	
		}

		public static ByteArrayOutputStream getExcelToJavaObj(List<CrossingStatementList.CrossingStatement> prrList){		
			CrossingStatementList psl = new CrossingStatementList();
				psl.getCrossingStatement().addAll(prrList);	
			    psl.setDateGenerated(prrList.get(0).getDateGenerated());
			    psl.setTimeGenerated(time.getXmlTime());
			 	
		
				try {

					ByteArrayOutputStream Os1 = new ByteArrayOutputStream( );		
					JAXBContext jaxbContext = JAXBContext.newInstance(CrossingStatementList.class);
					Marshaller jaxbMarshaller = jaxbContext.createMarshaller();			
					jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // output pretty printed
					jaxbMarshaller.marshal(psl, Os1);
					return Os1;

				} catch (JAXBException e) {
					e.printStackTrace();
				}
		    		
			return null;
			
		}
		
		
		  public static List<CrossingStatementList.CrossingStatement> getPremiumReconciliationRsList(String filePath){
				Map<String,Object> map = readExcelSheet(filePath);
				List<CrossingStatementList.CrossingStatement> valueObjectList = (List<CrossingStatementList.CrossingStatement>)map.get("valueObjectList");			
				return valueObjectList;
		    }

		  

		    public static Map<String,Object> readExcelSheet(String filePath) {
				
		    		    	
		    	CrossingStatement pr = null;
				AccountEntry ae = null;
				Map<String, Object> rowMap = null;

				try {
					XSSFWorkbook myWorkBook = new XSSFWorkbook(new FileInputStream(filePath));
					XSSFSheet mySheet = myWorkBook.getSheetAt(0);
					boolean isFirstRow = true;
					rowMap = new HashMap<String, Object>();
					List<CrossingStatement> cellsList = new ArrayList<CrossingStatement>();				
			
					pr = new CrossingStatement();
					pr = getPRObject(mySheet);
					for(Row myRow : mySheet){
						ae = new AccountEntry();
						if (!(isFirstRow)) {	
							if(!isRowEmpty(myRow)){
								addRowCells(cellsList, myRow);							
							}						
						}	 					
						if(isFirstRow) {
							isFirstRow = false;
						}						
					}
								
					rowMap.put("valueObjectList", cellsList);
					
				} catch (Exception e) {
					System.out.println("Reading from excel sheet");
				}
				
				return rowMap;

		     }
		    
		    


		    
		    private static void addRowCells(List<CrossingStatement> cellsList, Row row) {
	        int cInd = 0;     
	        
	        AccountEntry ae = new AccountEntry();
	        CrossingStatement cs = new CrossingStatement();
	       AmountPayable apayable = new AmountPayable();
	   	  
			   
	        Cell cl  = row.getCell(cInd++);//date				
	        cs.setDateGenerated(getD(cl.getDateCellValue()));
	        cs.setTimeGenerated(time.getXmlTime());
	        
	        cl  = row.getCell(cInd++);
			ae.setReferenceNumber(cl.getStringCellValue());
			
			cl = row.getCell(cInd++);// start date					
			if(isObjectNotNull(cl.getDateCellValue())){
			ae.setStartDate(getD(cl.getDateCellValue()));
			}
			
			ae.setStartTime(time.getXmlTime());
			
			cl = row.getCell(cInd++);//veh referece
			
			//ae.setVehicleNumber(cl.getStringCellValue());
			ae.setVehicleNumber(cl.getStringCellValue());
				
			cl = row.getCell(cInd++);//gross premium	
			apayable.setAmount((float)(cl.getNumericCellValue()));				
			cl = row.getCell(cInd++);//vat			
			apayable.setVAT((float)(cl.getNumericCellValue()));
			ae.setAmountPayable(apayable);				
			cs.setAccountEntry(ae);			
			cellsList.add(cs);
			}
			
				
			

		private static CrossingStatement getPRObject(XSSFSheet mySheet) {
	    	boolean isFirstRow = true;
	    	CrossingStatement cStmt = new CrossingStatement();	
	    	 AccountEntry ae = new AccountEntry();	       	  
	    	 uk.co.nivi.qe2.CrossingStatementList.CrossingStatement.AccountEntry.AmountPayable apayable = new uk.co.nivi.qe2.CrossingStatementList.CrossingStatement.AccountEntry.AmountPayable();
	    	  	
		        int count = 1;
	    	for(Row row : mySheet){
				
				if (!(isFirstRow)) {	
					if(!isRowEmpty(row)){
						if(count == 1){							
						int cInd = 0;  
						
						// statement date								
						Cell cl = row.getCell(cInd++); 						
						cStmt.setDateGenerated(getD(cl.getDateCellValue()));					
						cStmt.setTimeGenerated(time.getXmlTime());
						cl  = row.getCell(cInd++);
						ae.setReferenceNumber(cl.getStringCellValue());
						cl = row.getCell(cInd++);// start date					
						if(isObjectNotNull(cl.getDateCellValue())){
						ae.setStartDate(getD(cl.getDateCellValue()));
						}
						ae.setStartTime(time.getXmlTime());
						cl = row.getCell(cInd++);//veh referece						
						ae.setVehicleNumber(cl.getStringCellValue());
							
						cl = row.getCell(cInd++);//amount
				    	apayable.setAmount((float)(cl.getNumericCellValue()));			
						cl = row.getCell(cInd++);//vat					
						apayable.setVAT((float)(cl.getNumericCellValue()));
						ae.setAmountPayable(apayable);	
						
						cStmt.setAccountEntry(ae);
					  				
						}
												
					break;	
						
					}						
				}	 					
				if(isFirstRow) {
					isFirstRow = false;
				}
				
			
	    	
	    	
			}
	    	return cStmt;

		}
		
		
		
		
		
		
		
		

		private static XMLGregorianCalendar getD(Date d){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(d);		
			XMLGregorianCalendar xmlDate = null;
			try {
				xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
			} catch (DatatypeConfigurationException e2) {			
				e2.printStackTrace();
			}	   
			return xmlDate;		
		}
		
		

		private static boolean isObjectNotNull(Object obj){
		    if(obj != null && obj != "" &&  obj.toString().length() > 0){	
				return true;
			}
			else {		
				return false;
			}		
		}
		
		
		public static boolean isRowEmpty(Row row) {
		    for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
		        Cell cell = row.getCell(c);
		        if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
		            return false;
		    }
		    return true;
		}
		
		
		public static BigDecimal getBigDecimal(BigDecimal b)
	    {		
		
		     double d = b.doubleValue();				
			 b = new BigDecimal(d, MathContext.DECIMAL32);			
			 b = b.setScale(2, RoundingMode.FLOOR);		
			 return b;			
	    }
		
		
	    public final static double DEFAULT_DOUBLE = 0.00;    
	  
	  	static 	TimePOJO time = new TimePOJO();
	  	static 	PrIDPOJO prIdPOJO = new PrIDPOJO();

	  	
	}

