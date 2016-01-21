package leetcode.lrg;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by programmer on 1/21/16.
 */
public class MaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        maxNumber(nums1, nums2, k, 0, result);
        return result;
    }

    public void maxNumber(int[] nums1, int[] nums2, int k, int i, int[] result) {

        Stack<Integer> stack1 = createStack(nums1, 0, nums1.length - 1);
        Stack<Integer> stack2 = createStack(nums2, 0, nums2.length - 1);
        putIntoResult(nums1,stack1,nums2,stack2,result, i, k);
    }

    private void putIntoResult(int[] nums1, Stack<Integer> stack1, int[] nums2, Stack<Integer> stack2, int[] result, int i, int k) {
        if (i == k) return;
        if (stack1.isEmpty()) process(nums2,stack2,nums1,stack1,result,i,k);
        else if (stack2.isEmpty()) process(nums1,stack1,nums2,stack2,result,i,k);
        else if (nums1[stack1.peek()]>nums2[stack2.peek()]) process(nums1,stack1,nums2,stack2,result,i,k);
        else if (nums2[stack2.peek()]>nums1[stack1.peek()]) process(nums2,stack2,nums1,stack1,result,i,k);
        else process(nums2,stack2,nums1,stack1,result,i,k);
    }

    private void process(int[] numsA, Stack<Integer> stackA, int[] numsB, Stack<Integer> stackB, int[] result, int i, int k) {
        if (numsA.length - (stackA.peek()+1) + numsB.length >= k - i -1) {
            result[i] = numsA[stackA.peek()];
            int[] newNumsA = Arrays.copyOfRange(numsA, stackA.peek() + 1, numsA.length);
            maxNumber(newNumsA, numsB, k, i+1, result);
        } else {
            stackA.pop();
            putIntoResult(numsA, stackA, numsB, stackB, result, i, k);
        }
    }


    private Stack<Integer> createStack(int[] nums, int start, int end) {
        Stack<Integer> stack = new Stack<>();
        for (int i = start; i <= end; i++) {
            if (stack.isEmpty() || nums[stack.peek()] < nums[i]) {
                stack.push(i);
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        int[] nums1 = {6,7};
        int[] nums2 = {6,0,4};
        MaxNumber solution = new MaxNumber();
        for (int x:solution.maxNumber(nums1,nums2,5))
            System.out.println(x);
    }
}
