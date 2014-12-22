package be.ac.ulb.stream;

import java.io.IOException;

public interface OutStreamProvider {

	
	public void create(String filePath) throws IOException;
	
	public void write(int input) throws IOException;
	
	public void close() throws IOException;
}
