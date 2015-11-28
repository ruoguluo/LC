package leetcode.lrg;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by programmer on 11/20/15.
 */
public class LargestNumber {

    class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            String s1 = "" + o1 + o2;
            String s2 = "" + o2 + o1;
            return s2.compareTo(s1);
        }
    }
    public String largestNumber(int[] nums) {
        Integer[] numsInteger = new Integer[nums.length];
        for (int i=0;i<nums.length;i++) {
            numsInteger[i] = new Integer(nums[i]);
        }
        Arrays.sort(numsInteger, new MyComparator());
        StringBuilder sb = new StringBuilder();
        for (int n:numsInteger) {
            sb.append(n);
        }
        int k=0;
        while (k<sb.length() && sb.charAt(k)=='0') k++;
        return sb.substring(k).toString();
    }

    public static void main (String[] args) {
        LargestNumber solution = new LargestNumber();
        solution.largestNumber(new int[]{1,2});
    }
}
