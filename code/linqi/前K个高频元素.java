package code.linqi;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前k高的元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 */
public class 前K个高频元素 {
    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int count = 0;
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int value = entry.getValue();
            if (count < k) {
                treeMap.computeIfAbsent(value, ArrayList::new).add(num);
                count++;
            } else {
                Map.Entry<Integer, List<Integer>> treeEntry = treeMap.firstEntry();
                if (treeEntry.getKey() < value) {
                    treeMap.computeIfAbsent(value, ArrayList::new).add(num);

                    List<Integer> list = treeEntry.getValue();
                    if (list.size() == 1) {
                        treeMap.remove(treeEntry.getKey());
                    } else {
                        list.remove(0);
                    }
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; ) {
            Map.Entry<Integer, List<Integer>> entry = treeMap.pollFirstEntry();
            List<Integer> list = entry.getValue();
            for (Integer num : list) {
                result[i] = num;
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3},2));
    }
}
