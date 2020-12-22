package code.linqi;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public void customQuickSort(int[] arr, int left, int right) {
        Random random = new Random();

        if (left >= right) {
            return;
        }
        //交换随机值，防止最坏情况
        int temp = 0;
        int swapIndex = left + 1 + random.nextInt(right - left);
        temp = arr[left];
        arr[left] = arr[swapIndex];
        arr[swapIndex] = temp;
        int i, j, t;
        i = left;
        j = right;
        t = arr[left];
        while (i < j) {
            while (t <= arr[j] && i < j) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (t >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }

        }
        arr[i] = t;
        customQuickSort(arr, left, i - 1);
        customQuickSort(arr, i + 1, right);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{1, 2, 4, 6, 3, 1};
        quickSort.customQuickSort(arr, 0, 5);
        for (int a = 0; a < arr.length; a++) {
            System.out.println(arr[a]);
        }
        Arrays.asList(arr).stream().forEach(System.out::println);
    }
}
