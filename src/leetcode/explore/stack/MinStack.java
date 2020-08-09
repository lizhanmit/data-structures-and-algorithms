package leetcode.explore.stack;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/solution/zui-xiao-zhan-by-leetcode-solution/
 */
public class MinStack {
	private Stack<Integer> data;
	
	private int min;
	
	public MinStack() {
		data = new Stack<>();
		min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
    	data.push(x);
    	
		if (x < min) min = x;
    }
    
    public void pop() {
    	int popped = data.pop();
    	
		if (popped == min) {
			min = Integer.MAX_VALUE;
			for (Integer i : data) {
				if (i < min) min = i;
			}
		}
    }
    
    public int top() {
    	return data.peek();
    }
    
    public int getMin() throws Exception {
    	if (data.isEmpty()) throw new Exception();
    	return min;
    }
}
