package be.ac.ulb.collection;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class StreamIterator<T> implements Iterator<T> { 
	
	private List<T> collection;
	private int position;
	
	public StreamIterator(CollectionFactory<T> collectionFactory) {
		
		this.collection = collectionFactory.getCollection();
		
	}

	@Override
	public boolean hasNext() {

		if (position < collection.size())
			return true;
		else
			return false;
	}
	
	@Override
	public T next() {
		
		if(hasNext()) {
			
			T Obj = (T) collection.get(position);
			position++;
			
			return Obj;
		}
		
		throw new NoSuchElementException();
	
	}
	
	@Override
	public void remove() {
		
		collection.remove(position);
		
	}
}
