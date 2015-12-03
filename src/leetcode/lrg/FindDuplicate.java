package leetcode.lrg;

/**
 * Created by programmer on 11/15/15.
 */
public class FindDuplicate {

    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        int left =1, right = len-1;
        while(left<right) {
            int mid=(left+right)/2;
            int count=0;
            for (int i=0;i<len;i++) {
                if (nums[i]>=left && nums[i]<=mid) count++;
            }
            if (count<=mid-left+1) {
                left = mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] {1,2,2}));
    }
}
