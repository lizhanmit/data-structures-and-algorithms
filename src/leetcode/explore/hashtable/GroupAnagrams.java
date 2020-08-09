package leetcode.explore.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 相同字母异序词（字母异位词）分组
 * https://leetcode-cn.com/problems/group-anagrams/solution/zi-mu-yi-wei-ci-fen-zu-by-leetcode/
 */
public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) return new ArrayList<>();
		
		Map<String, List<String>> map = new HashMap<>();
		
		for (String string : strs) {
			char[] chars = string.toCharArray();
			Arrays.sort(chars);
			String key = String.valueOf(chars);
			
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			
			map.get(key).add(string);
		}
		
		return new ArrayList(map.values());
	}
}
