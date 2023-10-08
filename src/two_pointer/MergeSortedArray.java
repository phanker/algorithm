package two_pointer;

import java.util.Arrays;

class MergeSortedArray {

    public static void main(String[] args) {
//        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num1 = new int[]{4, 5, 6, 0, 0, 0};

//        new Solution().merge(num1, 3, new int[]{2, 5, 6}, 3);
        new MergeSortedArray().merge1(num1, 3, new int[]{1, 2, 3}, 3);

        System.out.println(Arrays.toString(num1));
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (m + n != nums1.length || n < 1) {
            return;
        }
        int[] new_arr = Arrays.copyOf(nums1, m);
        int i = 0;
        int k = 0;
        int current = 0;
        while (i < m && k < n) {
            int num1 = new_arr[i];
            int num2 = nums2[k];
            if (num1 > num2) {
                nums1[current] = num2;
                k++;
            } else {
                nums1[current] = num1;
                i++;
            }
            current++;
        }
        while (i < m) {
            nums1[current] = new_arr[i];
            current++;
            i++;
        }
        while (k < n) {
            nums1[current] = nums2[k];
            current++;
            k++;
        }
    }

    // more efficient
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (m + n != nums1.length || n < 1) {
            return;
        }
        int p1 = m - 1;
        int p2 = n - 1;
        int p3 = nums1.length - 1;
        while (p1 >= 0 && p2 >= 0) {
            int num1 = nums1[p1];
            int num2 = nums2[p2];
            if (num1 > num2) {
                nums1[p3] = num1;
                p1--;
            } else {
                nums1[p3] = num2;
                p2--;
            }
            p3--;
        }

        while (p2 >= 0) {
            nums1[p3] = nums2[p2];
            p2--;
            p3--;
        }
    }
}