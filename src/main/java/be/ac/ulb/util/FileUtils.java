package be.ac.ulb.util;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class FileUtils {
	
	
	public static void writeFileAsIntegers(String filePath, int numberOfInteger) throws IOException{
		
		createFile(filePath);
		
	    OutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filePath));
	    Random random = new Random();

	    while(numberOfInteger > 0){
	    	
	    	dataOutputStream.write(random.nextInt());
	    }
	    
	    dataOutputStream.flush();
	    
	    // close the stream
	    dataOutputStream.close();

	}
	
	public static void removeFilesList(int filesNumber, int implNumber) throws IOException{
		
		for(int i= 0;i < filesNumber; i++){
			
			deleleFile("files/impl_" + implNumber + "/input_" + (i + 1) + ".data");
			
		}
	}
	
	private static void createFile(String filePath) throws IOException{
		
		File file = new File(filePath);
		
		if(!file.exists()){
			
			file.createNewFile();
		}
			
	}
	
	
	private static void deleleFile(String filePath) throws IOException{
		
		File file = new File(filePath);
		
		if(file.exists()){
			
			file.delete();
		}
			
	}
	
	 
}
