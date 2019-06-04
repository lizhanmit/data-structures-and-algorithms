package book.DSAInJava.map;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HashMultimap<K, V> implements Multimap<K, V> {

	Map<K, List<V>> map = new HashMap<>();
	
	int size = 0;
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterable<V> get(K key) {
		List<V> values = map.get(key);
		return values == null ? new ArrayList<>() : values;
	}

	@Override
	public void put(K key, V value) {
		// for HashMap, key and value can be null
		
		List<V> values = map.get(key);
		
		if (values == null) {
			values = new ArrayList<>();
			map.put(key, values);
		}
		values.add(value);
		
		size++;
	}

	@Override
	public boolean remove(K key, V value) {
		List<V> values = map.get(key);
		
		if (values == null) {
			return false;
		}
		
		values.remove(value);
		
		if (values.isEmpty()) {
			map.remove(key);
		}
		
		size--;
		
		return true;
	}

	@Override
	public Iterable<V> removeAll(K key) {
		List<V> values = map.get(key);
		
		if (values == null) {
			return new ArrayList<>();
		}
		
		map.remove(key);
		size -= values.size();
		
		return values;
	}

	@Override
	public Iterable<Entry<K, V>> entries() {
		List<Entry<K, V>> pairs = new ArrayList<>();
		
		for (Entry<K, List<V>> entry : map.entrySet()) {
			K key = entry.getKey();
			for (V value : entry.getValue()) {
				pairs.add(new AbstractMap.SimpleEntry<K, V>(key, value));
			}
		}
		
		return pairs;
	}
}
