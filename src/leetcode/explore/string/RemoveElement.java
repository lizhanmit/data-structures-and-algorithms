package leetcode.explore.string;

/**
 * https://leetcode-cn.com/leetbook/read/array-and-string/cwuyj/
 */
public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0) return 0;
		
		int slowIndex = 0;
		
		for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
			if (nums[fastIndex] != val) {
				nums[slowIndex] = nums[fastIndex];
				slowIndex++;
			}
		}
		
		return slowIndex;
	}
}
