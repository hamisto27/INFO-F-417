package be.ac.ulb;

import java.io.IOException;

import be.ac.ulb.implementation_1.InOutMechanism_1;
import be.ac.ulb.implementation_2.InOutMechanism_2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	System.out.print("FIRST MECHANISM: ");
    	
		InOutMechanism_1 firstInOutMechanism;
		
		try {
			
			firstInOutMechanism = new InOutMechanism_1.Builder().streamsNumber(3).build();
			firstInOutMechanism.startImplementation();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.print("\nSECOND MECHANISM: ");
    	
		InOutMechanism_2 secondInOutMechanism;
		
		try {
			
			secondInOutMechanism = new InOutMechanism_2.Builder().streamsNumber(10).build();
			secondInOutMechanism.startImplementation();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }
}
