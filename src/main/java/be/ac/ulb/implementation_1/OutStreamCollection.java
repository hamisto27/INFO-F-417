package be.ac.ulb.implementation_1;

import java.io.IOException;

import be.ac.ulb.collection.CollectionFactory;

class OutStreamCollection extends CollectionFactory<OutStream> {

	public OutStreamCollection(int collectionSize) throws IOException {

		super(collectionSize);
		initialize();

	}

	@Override
	protected void initialize() throws IOException {

		for (int i = 0; i < getCollectionSize(); i++) {

			// open K streams.
			OutStream outStream = new OutStream();
			outStream.create("files/impl_1/input_" + (i + 1) + ".data");

			add(outStream);
		}

	}

}
