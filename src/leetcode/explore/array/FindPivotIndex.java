package leetcode.explore.array;

/**
 * https://blog.csdn.net/qq_16151925/article/details/80204869
 */
public class FindPivotIndex {

	public int pivotIndex(int[] nums) {
        int len = nums.length;
        if (len < 3) return -1;

        int leftSum = 0;
        
        int sum = 0;
        
        for (int n : nums) {
        	sum += n;
		}
        
        for (int i = 0; i < len; i++) {
        	if (i == 0) {
        		leftSum = 0;
        	} else {
        		leftSum += nums[i - 1];
        	}
        	
        	if (leftSum == sum - leftSum - nums[i]) {
        		return i;
        	}
        }
        
        return -1;

    }
	
}
