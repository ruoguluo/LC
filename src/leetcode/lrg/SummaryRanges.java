package leetcode.lrg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by programmer on 11/7/15.
 */
public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 1) {
            ranges.add("" + nums[0]);
        } else if (nums.length > 1) {
            int start = nums[0];
            int end = start;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] == nums[i] + 1) {
                    end = nums[i + 1];

                } else {
                    output(start, end, ranges);
                    start = nums[i + 1];
                    end = start;
                }
                if (i == nums.length - 2) {
                    output(start, end, ranges);
                }
            }
        }
    return ranges;
}

    private static void output(int start, int end, List<String> ranges) {
        if (start == end) {
            ranges.add("" + start);
        } else {
            ranges.add(start + "->" + end);
        }
    }

    public static void main(String[] args) {
        List<String> output = summaryRanges(new int[]{-1});
        for (String s : output) {
            System.out.println(s);
        }
    }
}
