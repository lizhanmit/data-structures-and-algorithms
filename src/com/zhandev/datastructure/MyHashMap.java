package com.zhandev.datastructure;

import java.util.LinkedList;

/**
 * implement HashMap using linked list
 *
 */
public class MyHashMap<K, V> {

	static class Entry<K, V> {
		K key;
		V value;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private LinkedList<Entry>[] linkedListArray = new LinkedList[16];
	
	public V put(K key, V value) {
		if (key == null) {
			LinkedList<Entry> firstLinkedList = linkedListArray[0];
			for (Entry<K, V> entry : firstLinkedList) {
				if (entry.key == null) {
					V oldValue = entry.value;
					entry.value = value;
					return oldValue;
				}
			}
			// if there is no null key entry in the first linked list, add this entry as the first element
			firstLinkedList.addFirst(new Entry(key, value));
			return null;
		}
		
		int index = key.hashCode() % linkedListArray.length;
		LinkedList<Entry> list = linkedListArray[index];
		Entry<K, V> newEntry = new Entry(key, value);
		
		if (list == null) {
			LinkedList<Entry> newList = new LinkedList<>();
			newList.add(newEntry);
			linkedListArray[index] = newList;
			return null;
		}
		
		for (Entry<K, V> entry : list) {
			if (entry.key.equals(key)) {
				V oldValue = entry.value;
				entry.value = value;
				return oldValue;
			}
		}
		
		list.add(newEntry);
		return null;
	}
	
	public V get(K key) {
		if (key == null) {
			return null;
		}
		
		int index = key.hashCode() % linkedListArray.length;
		if (linkedListArray[index] == null) {
			return null;
		}
		
		for (Entry<K, V> entry : linkedListArray[index]) {
			if (entry.key.equals(key)) {
				return entry.value;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		MyHashMap<String, String> myHashMap = new MyHashMap<>();
		System.out.println(myHashMap.get("b"));
		myHashMap.put("a", "1");
		myHashMap.put("b", "2");
		myHashMap.put("c", "3");
		System.out.println(myHashMap.get("b"));
		
	}
}
