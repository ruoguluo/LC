package leetcode.lrg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by programmer on 12/6/15.
 */
public class CountSmallerNumbersAfterSelf {

    private List<Entry> sort(List<Entry> nums, List<Integer> cnt) {
        int size = nums.size();
        if (size<=1) return nums;
        List<Entry> left = sort(nums.subList(0, size / 2), cnt);
        List<Entry> right = sort(nums.subList(size/2, size), cnt);
        int m = left.size();
        int n = right.size();
        int i=0,j=0;
        List<Entry> result = new ArrayList<>();
        while (i+j<m+n) {
            if (j==n || i<m && left.get(i).value<=right.get(j).value) {
                result.add(left.get(i));
                cnt.set(left.get(i).index, cnt.get(left.get(i).index) + j);
                i++;
            }else {
                result.add(right.get(j));
                j++;
            }
        }
        //System.out.println(result);
        return result;
    }

    private class Entry {
        int index;
        int value;
        Entry (int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int size = nums.length;
        List<Entry> inputList = new ArrayList<>();
        for (int i=0;i<size;i++) {
            result.add(0);
            inputList.add(new Entry(i, nums[i]));
        }
        sort(inputList, result);
        return result;

    }

    public static void main(String[] args) {
        CountSmallerNumbersAfterSelf solution = new CountSmallerNumbersAfterSelf();
        int[] input = {6, 4, 2, 3, 5, 1};
        System.out.println(solution.countSmaller(input));
    }

}
