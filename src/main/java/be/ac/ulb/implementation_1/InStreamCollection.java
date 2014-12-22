package be.ac.ulb.implementation_1;

import java.io.IOException;

import be.ac.ulb.collection.CollectionFactory;

class InStreamCollection extends CollectionFactory<InStream> {

	public InStreamCollection(int collectionSize) throws IOException {

		super(collectionSize);
		initialize();

	}

	@Override
	protected void initialize() throws IOException {

		for (int i = 0; i < getCollectionSize(); i++) {

			// open K streams.
			InStream inStream = new InStream();
			inStream.open("files/impl_1/input_" + (i + 1) + ".data");

			add(inStream);
		}

	}

}
