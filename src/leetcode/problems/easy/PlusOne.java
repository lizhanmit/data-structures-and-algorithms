package leetcode.problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 66. 加一
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *
 * 提示：
 *
 *     1 <= digits.length <= 100
 *     0 <= digits[i] <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PlusOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(digitsAfterPlusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(digitsAfterPlusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(digitsAfterPlusOne(new int[]{0})));
        System.out.println(Arrays.toString(digitsAfterPlusOne(new int[]{1, 9})));

        System.out.println(Arrays.toString(digitsAfterPlusOne2(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(digitsAfterPlusOne2(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(digitsAfterPlusOne2(new int[]{0})));
        System.out.println(Arrays.toString(digitsAfterPlusOne2(new int[]{1, 9})));
    }

    /**
     * Time: O(n) - one for loop
     * Space: O(n) - one int array
     *
     * @param digits
     * @return
     */
    private static int[] digitsAfterPlusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        if (digits[0] != 0) {
            return digits;
        }

        int[] digitsAfterPlusOne = new int[digits.length + 1];
        digitsAfterPlusOne[0] = 1;

        for (int i = 0; i < digits.length; i++) {
            digitsAfterPlusOne[i + 1] = digits[i];
        }

        return digitsAfterPlusOne;
    }

    private static int[] digitsAfterPlusOne2(int[] digits) {
        StringBuilder sb = new StringBuilder();

        for (int digit : digits) {
            sb.append(digit);
        }

        int num = Integer.valueOf(sb.toString());

        num++;

        String numStr = String.valueOf(num);

        int[] digitsAfterPlusOne = new int[numStr.length()];

        char[] numArr = numStr.toCharArray();
        for (int i = 0; i < numArr.length; i++) {
            digitsAfterPlusOne[i] = numArr[i] - '0';
        }

        return digitsAfterPlusOne;
    }

}
