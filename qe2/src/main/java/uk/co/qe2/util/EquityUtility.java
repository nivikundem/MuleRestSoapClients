package uk.co.qe2.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import edu.emory.mathcs.backport.java.util.Arrays;

public class EquityUtility {
	
	
	public static void deleteOldFiles(String folder)
	{
			   
	    String pattern = "ddMMyyyy";
	    SimpleDateFormat format = new SimpleDateFormat(pattern);
		final String fileNameContainsStr = format.format(new Date());
		File f = new File(folder);
		
		List<File> files = (List<File>) FileUtils.listFiles(f, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		for (File file : files) {
			try {
				//System.out.println("file: " + file.getCanonicalPath() + " contains  "+fileNameContainsStr);				
				if(!(file.getCanonicalPath()).contains(fileNameContainsStr)){				
					file.delete();					
				}
				
			} catch (IOException e) {			
				e.printStackTrace();
			}
		}
		
	}
		
	
	public static List getFileNameContains(String folder)
	{
				
	   String pattern = "ddMMyyyy";
	   SimpleDateFormat format = new SimpleDateFormat(pattern);
		final String fileNameContainsStr = format.format(new Date());
		File f = new File(folder);
		String[] allFiles = f.list(new FilenameFilter() {
            public boolean accept(File dir, String fileName) {             
                return fileName.contains(fileNameContainsStr);
              }
            });
		
		return Arrays.asList(allFiles);
	}	
	
	
	
	
	
	public static void deleteFile(String fileName, String folder)
	{
		File file = new File(folder + "/" + fileName);
		
		if(file.exists())
			file.delete();
	}
	
	public static byte[] readFile(String folder, String filename) throws Exception
	{
		//System.out.println("EquityUtility:"+folder + "/" + filename );
		File file = new File(folder + "/" + filename);
		
		byte[] bFile = new byte[(int) file.length()];

		try
		{
			if(file.exists())
			{
				Path path = Paths.get(folder + "/" + filename);
				bFile = Files.readAllBytes(path);
				
			}
			else
			{
				System.out.println("***** ESB not able to find file ****:"+folder+"/"+filename);
				throw new FileNotFoundException("java.io.FileNotFoundException:"+folder+"/"+filename); 
			}
		}
		catch(Exception e)
		{
			System.out.println("***** ESB unexpected read error *****:"+folder+"/"+filename);
			throw e;
		}
		
		return bFile;
		
	}
	
	public static void moveFile1(String inputFolder, String outputFolder, String filename) throws IOException
	{
		
		//System.out.println(inputFolder+":"+outputFolder+":"+filename);
				
		Path sourceFile = Paths.get(inputFolder + "/" + filename);
	    Path destinationFile = Paths.get(outputFolder + "/" + filename);
	   	   
		Files.move(sourceFile, destinationFile, StandardCopyOption.ATOMIC_MOVE);
	}
	
	public static void moveFile(String inputFolder, String outputFolder, String fromFile, String toFile) throws IOException
	{
		
		
		File srcFile = new File(inputFolder + "/" + fromFile);
	   	File destFile = new File(outputFolder + "/" + toFile );
	   	try
	   	{
	   		FileUtils.copyFile(srcFile, destFile);	   		
	   		if(srcFile.exists())
	   			srcFile.delete();
	   	}
	   	catch(Exception e)
	   	{	
	   		//e.printStackTrace();
	   		System.out.println("************************** ESB not able to move file *********************************:"+inputFolder+":"+fromFile + "/" + toFile);
	   	}
	}
	
	public static void moveFile(String inputFolder, String outputFolder, String filename) throws IOException
	{
		//System.out.println(inputFolder+":"+outputFolder+":"+ filename);
		
		File srcFile = new File(inputFolder + "/" + filename);
	   	File destFile = new File(outputFolder + "/" + filename );
	   	try
	   	{
	   		FileUtils.copyFile(srcFile, destFile);	   		
	   		if(srcFile.exists())
	   			srcFile.delete();
	   	}
	   	catch(Exception e)
	   	{	
	   		//e.printStackTrace();
	   		System.out.println("************************** ESB not able to move file *********************************:"+outputFolder + "/" + filename);
	   	}
	}
	
	public static ArrayList getFiles(String zipFolder) throws IOException
	{
				
		ArrayList<String> arlFiles = new ArrayList<String>();
		
		File folder = new File(zipFolder);
		File[] listOfFiles = folder.listFiles(); 
		for (int i = 0; i < listOfFiles.length; i++) 
		{		 
		   if (listOfFiles[i].isFile()) 
		   {
			   arlFiles.add(listOfFiles[i].getName());
		   }
		}
		
		return arlFiles;
	}

}
