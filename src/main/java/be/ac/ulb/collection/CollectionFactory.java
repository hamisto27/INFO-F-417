package be.ac.ulb.collection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CollectionFactory<T> implements Iterable<T> {
	
	
	private List<T> collection;
	private int collectionSize;
	

	public CollectionFactory(int collectionSize){
		
		collection = new ArrayList<T>();
		this.collectionSize = collectionSize;
	}
	
	
	public Iterator<T> iterator() {
		
		return new StreamIterator<T>(this);
	}
	
	public boolean add(T item) {
		
		if (collection.size() < collectionSize) {
			
			collection.add(item);
			return true;
		} 
		
		return false;
	
	}

	
	protected abstract void initialize() throws IOException;
	
	
	// getters and setters 
	
	public List<T> getCollection() {
		
		return collection;
	}

	public void setCollection(List<T> collection) {
		this.collection = collection;
	}
	

	public int getCollectionSize() {
		return collectionSize;
	}

	public void setCollectionSize(int collectionSize) {
		this.collectionSize = collectionSize;
	}

	
}
