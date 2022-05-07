package leetcode.problems.easy;

import java.util.*;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 提示：
 *
 *     1 <= s.length <= 104
 *     s 仅由括号 '()[]{}' 组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidBrackets {

    private final static Map<Character, Character> bracketMap = new HashMap<>(3);

    static {
        bracketMap.put('(', ')');
        bracketMap.put('[', ']');
        bracketMap.put('{', '}');
    }

    public static void main(String[] args) {

        System.out.println(areBracketsValid("()"));
        System.out.println(areBracketsValid("()[]{}"));
        System.out.println(areBracketsValid("{[]}"));
        System.out.println(areBracketsValid("(]"));
        System.out.println(areBracketsValid("([)]"));
        System.out.println(areBracketsValid("])"));
        System.out.println(areBracketsValid("[("));
    }

    /**
     * Time: O(n) - one for loop
     * Space: O(n) - one stack
     * @param str
     * @return
     */
    private static boolean areBracketsValid(String str) {
        if (str.length() < 2) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (Character c : str.toCharArray()) {
            if (bracketMap.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (!bracketMap.get(stack.pop()).equals(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
