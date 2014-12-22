package be.ac.ulb.implementation_2;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

import be.ac.ulb.stream.OutStreamProvider;

public class OutStream implements OutStreamProvider {

	private DataOutputStream dataOutputStream;

	public OutStream() {

		;
	}

	@Override
	public void create(String filePath) throws IOException {

		File file = new File(filePath);

		// create file if a file with this name does not yet exist.
		if (!file.createNewFile())
			throw new FileAlreadyExistsException(filePath);

		dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file, true)));

	}

	@Override
	public void write(int input) throws IOException {

		dataOutputStream.writeInt(input);
	}

	@Override
	public void close() throws IOException {

		dataOutputStream.close();

	}

	// getters and setters.

	public DataOutputStream getDataOutputStream() {
		return dataOutputStream;
	}

	public void setDataOutputStream(DataOutputStream dataOutputStream) {
		this.dataOutputStream = dataOutputStream;
	}

}
