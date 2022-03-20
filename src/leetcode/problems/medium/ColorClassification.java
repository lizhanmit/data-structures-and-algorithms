package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 75. 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 *
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库的sort函数的情况下解决这个问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 *
 *
 * 提示：
 *
 *     n == nums.length
 *     1 <= n <= 300
 *     nums[i] 为 0、1 或 2
 *
 *
 *
 * 进阶：
 *
 *     你可以不使用代码库中的排序函数来解决这道题吗？
 *     你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 */
public class ColorClassification {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));

        System.out.println();

        int[] nums2 = new int[]{2, 0, 1};
        sortColors(nums2);
        Arrays.stream(nums2).forEach(x -> System.out.print(x + " "));
    }

    // NOTE: in-place sort, thus return type is void rather than int[].
    private static void sortColors(int[] colors) {
        if (colors == null) {
            throw new IllegalArgumentException("Parameter 'colors' should not be null");
        }

        if (colors.length <= 1) {
            return;
        }

        int numOfZero = 0, numOfOne = 0, numOfTwo = 0;

        for (int i = 0; i < colors.length; i++) {
            switch (colors[i]) {
                case 0: numOfZero++; break;
                case 1: numOfOne++; break;
                case 2: numOfTwo++; break;
                default: break;
            }
        }

        Arrays.fill(colors, 0, numOfZero, 0);
        Arrays.fill(colors, numOfZero, numOfZero + numOfOne, 1);
        Arrays.fill(colors, numOfZero + numOfOne, numOfZero + numOfOne + numOfTwo, 2);
    }
}
