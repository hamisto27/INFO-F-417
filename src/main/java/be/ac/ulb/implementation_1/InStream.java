package be.ac.ulb.implementation_1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import be.ac.ulb.stream.InStreamProvider;

class InStream implements InStreamProvider {

	private DataInputStream dataInputStream;
	private int next;

	public InStream() {

		;

	}

	@Override
	public void open(String filePath) throws FileNotFoundException {

		File file = new File(filePath);

		if (file.exists()) {

			dataInputStream = new DataInputStream(new FileInputStream(file));

		}
		else{
			
			throw new FileNotFoundException();
		}

	
	}

	@Override
	public void readNext() throws IOException {

		next = dataInputStream.readInt();
	}

	@Override
	public boolean endOfStream() {

		return next == -1 ? true : false;
	}

	// getters and setters.

	public DataInputStream getDataInputStream() {
		return dataInputStream;
	}

	public void setDataInputStream(DataInputStream dataInputStream) {
		this.dataInputStream = dataInputStream;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}
}
