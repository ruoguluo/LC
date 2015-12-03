package leetcode.lrg;

/**
 * Created by programmer on 11/18/15.
 */
public class FindMinInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int l=0;
        int r=nums.length-1;
        while (l<r) {
            int k=l;
            while (k<=r&&nums[k]==nums[r]) k++;
            if (k>r) return nums[l];
            l=k;
            if (nums[l]<nums[r]) return nums[l];
            int m=(l+r)/2;
            if (nums[l]<=nums[m]) l=m+1;
            else r=m;
        }
        return nums[l];
    }

    public static void main(String[] args) {
        FindMinInRotatedSortedArrayII solution = new FindMinInRotatedSortedArrayII();
        System.out.println(solution.findMin(new int[]{1,1}));
    }
}
