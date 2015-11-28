package leetcode.lrg;

/**
 * Created by programmer on 11/7/15.
 */
public class WiggleSort {

    public static void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (((i & 1) == 1) == (nums[i] < nums[i - 1])) {
                swap(nums, i - 1, i);
            }
        }
    }

    private static void swap(int[] nums, int i0, int i1) {
        int tmp = nums[i0];
        nums[i0] = nums[i1];
        nums[i1] = tmp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,5,2,1,6,4};
        wiggleSort(input);
        for (int i:input) {
            System.out.println(i);
        }

    }
}
