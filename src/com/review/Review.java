package com.review;

import java.util.*;

/**
 * Practice code for review before coding interview.
 */
public class Review {

    public static void main(String[] args) {
        /*
         Array
         */
        int arr[] = new int[5];  // initial length
        int arr2[] = {1, 2, 3, 4, 5};  // initialize

        arr[0] = 1;
        int len = arr.length;

        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr2, 3);  // search by value

        System.out.println(index);  // output: 2

        /*
        String
         */
        String s = "hello";

        int strlen = s.length();

        char c = s.charAt(0);

        String sub = s.substring(1, 3);  // 3 is excluded

        String[] parts = s.split("l");

        boolean contains = s.contains("ell");

        int strIndex = s.indexOf('e');

        String upper = s.toUpperCase();

        char[] charArr = s.toCharArray();

        /*
        ArrayList (Dynamic Array)
         */
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.get(0);

        list.set(0, 10);

        list.remove(0);  // remove by index
        list.remove(Integer.valueOf(2));  // remove by value

        int size = list.size();

        boolean isEmpty = list.isEmpty();

        boolean listContains = list.contains(5);  // check containing value

        Collections.sort(list);

        int listIndex = list.indexOf(10);

        /*
        LinkedList
         */
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);

        linkedList.get(0);

        linkedList.set(0, 10);

        linkedList.remove(0);  // remove by index
        linkedList.remove(Integer.valueOf(2));  // remove by value

        int linkedListSize = linkedList.size();

        boolean linkedListIsEmptyp = linkedList.isEmpty();

        boolean linkedListContains = linkedList.contains(5);  // check containing value

        Collections.sort(linkedList);

        int linkedListIndex = linkedList.indexOf(10);

        /*
        Deque
         */
        LinkedList<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addLast(2);

        int first = deque.removeFirst();
        int last = deque.removeLast();

        /*
        Stack
         */
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        int top = stack.pop();  // remove and return the value

        int peek = stack.peek();  // view without removing

        boolean stackIsEmpty = stack.isEmpty();

        int stackSize = stack.size();

        /*
        Queue
         */
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);

        int front = queue.poll();  // remove and return the value

        int queuePeek =  queue.peek();  // view without removing

        boolean queueIsEmpty = queue.isEmpty();

        int queueSize = queue.size();

        /*
        PriorityQueue (Min/Max Heap)
         */
        // by default
        Queue<Integer> minHeap = new PriorityQueue<>();

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        minHeap.offer(3);
        minHeap.offer(1);
        minHeap.offer(2);

        int min = minHeap.poll();  // remove and return the value, output: 1
        int nextMin = minHeap.peek();  // view without removing, output: 2

        /*
        HashMap
         */
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);

        int value = map.get("a");  // search by key

        int removedValue = map.remove("b");  // remove by key

        boolean containsKey = map.containsKey("a");
        boolean containsValue = map.containsValue(1);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int gotValue = entry.getValue();
        }

        int mapSize = map.size();

        boolean mapIsEmpty = map.isEmpty();

        /*
        HashSet
         */
        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(1);

        boolean setContains = set.contains(1);  // check containing value

        boolean removeContains = set.remove(2);  // remove by value and return contains or not

        int setSize = set.size();

        /*
        StringBuilder
         */
        StringBuilder sb = new StringBuilder();

        sb.append("Hello");
        sb.append(" ");
        sb.append("World");

        String res = sb.toString();

        sb.insert(5, ",");

        sb.delete(5, 6);  // 6 is excluded

        sb.reverse();

        int sbLen = sb.length();

        /*
        Arrays
         */
        int[] arr3 = {3, 1, 4, 1, 5};

        Arrays.sort(arr3);

        int arraysIndex = Arrays.binarySearch(arr3, 4);  // output: 3

        int[] copy = Arrays.copyOf(arr3, arr3.length);

        boolean arraysEquals = Arrays.equals(arr, arr3);

        Arrays.fill(arr3, 0);

        /*
        Collections
         */
        List<Integer> list2 = Arrays.asList(3, 1, 2);

        Collections.sort(list2);

        Collections.reverse(list2);

        Collections.shuffle(list2);

        int max = Collections.max(list2);
        int collMin = Collections.min(list2);

        Collections.swap(list2, 0, 1);

        /*
        Two Pointers
         */
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // process arr[left] and arr[right]

            left++;
            right--;
        }

    }
}
