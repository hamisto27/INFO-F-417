package be.ac.ulb.stream;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface InStreamProvider {

	
	public void open(String filePath) throws FileNotFoundException;

	public void readNext() throws IOException;

	public boolean endOfStream();

}
