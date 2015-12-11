package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by programmer on 12/6/15.
 */
public class MergeSort {

    static List<Integer> sort(List<Integer> nums) {
        int size = nums.size();
        if (size<=1) return nums;
        List<Integer> left = sort(nums.subList(0, size / 2));
        List<Integer> right = sort(nums.subList(size/2, size));
        int m = left.size();
        int n = right.size();
        int i=0,j=0;
        List<Integer> result = new ArrayList<>();
        while (i+j<m+n) {
            if (j==n || i<m && left.get(i)<=right.get(j)) {
                result.add(left.get(i));
                i++;
            }else {
                result.add(right.get(j));
                j++;
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main (String[] args) {
        List<Integer> nums = Arrays.asList(1,4,3,5,6,4,7,8,0);
        List<Integer> result= sort(nums);
        System.out.println(result);
    }


}
