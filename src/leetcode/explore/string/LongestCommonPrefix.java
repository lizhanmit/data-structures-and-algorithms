package leetcode.explore.string;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
 */
public class LongestCommonPrefix {

	/*
	 *  纵向扫描
	 * 
	 * O(mn)
	 * m: The average length of strings.
	 * n: The number of strings.
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		
		int len = strs[0].length();
		
		int count = strs.length;
		
		for (int i = 0; i < len; i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < count; j++) {
				if (strs[j].length() == i || strs[j].charAt(i) != c) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
    }
	
	
}
