package be.ac.ulb.implementation_1;

import java.io.IOException;
import java.util.Random;

import be.ac.ulb.util.FileUtils;

public class InOutMechanism_1 {

	private InStreamCollection inputStreams;
	private OutStreamCollection outputStreams;

	private int streamsNumber;
	private int times;

	public InOutMechanism_1(Builder builder) throws IOException {

		this.streamsNumber = builder.streamsNumber;
		this.times = builder.times;

		outputStreams = new OutStreamCollection(streamsNumber);
		inputStreams  = new InStreamCollection(streamsNumber);

	}

	private void read() throws IOException {

		
		long rStart = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {

			// read Integer from each stream
			for (InStream inStream : inputStreams) {
				
				if (!inStream.endOfStream()) {

					inStream.readNext();
				}
		
			}

		}
		long rStop = System.currentTimeMillis();

		System.out.print("reading time: " + (rStop - rStart) + "ms");

	}

	private void write() throws IOException {

		Random random = new Random();

		long wStart = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {

			// write Integer from each stream
			for (OutStream outStream : outputStreams) {

				outStream.write(random.nextInt());
			}

		}
		long wStop = System.currentTimeMillis();

		System.out.print("writing time:  " + (wStop - wStart) + "ms;");

	}

	public static class Builder {

		private int streamsNumber = 10;
		private int times = 1000;

		public Builder() {

			;
		}

		public Builder streamsNumber(int streamsNumber) {

			this.streamsNumber = streamsNumber;
			return this;
		}

		public Builder times(int times) {

			this.times = times;
			return this;
		}

		public InOutMechanism_1 build() throws IOException {

			return new InOutMechanism_1(this);
		}
	}

	
	public void startImplementation() throws IOException {
		
		// write test.
		write();
		
		for (OutStream outStream : outputStreams) {

			outStream.close();
		}
		
		// read test.
		read();
		
		for (InStream inputStream : inputStreams) {

			inputStream.getDataInputStream().close();
		}
		
		
		// remove all files on which we worked.
		FileUtils.removeFilesList(streamsNumber, 1);



	}

}
