package book.DSAInJava.map;

import java.util.Map.Entry;

public interface Multimap<K, V> {

	int size();
	
	boolean isEmpty();
	
	Iterable<V> get(K key);
	
	void put(K key, V value);
	
	boolean remove(K key, V value);
	
	Iterable<V> removeAll(K key);
	
	Iterable<Entry<K, V>> entries();
	
}
