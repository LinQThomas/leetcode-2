package code.linqi;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 数组中第k最大元素 {
    public int findLastLargeNums(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(nums.length, (a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        数组中第k最大元素 test = new 数组中第k最大元素();
        System.out.println(test.findLastLargeNums(new int[]{1, 2, 3, 4, 1}, 1));
    }
}
