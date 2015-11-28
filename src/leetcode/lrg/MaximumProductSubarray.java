package leetcode.lrg;

/**
 * Created by programmer on 11/18/15.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length==1) return nums[0];
        int min=nums[0];
        int max=nums[0];
        int globalMax=nums[0];
        for (int i=1;i<nums.length;i++) {
            int n=nums[i];
            if (n==0) {
                min=1;
                max=1;
                globalMax=Math.max(globalMax,0);
                continue;
            }else{
                min*=n;
                max*=n;
                int newMax=Math.max(Math.max(n,min),max);// ******
                int newMin=Math.min(Math.min(n,min),max);// ******
                min=newMin;
                max=newMax;
                globalMax=Math.max(globalMax,max);
            }
        }
        return globalMax;
    }

    public static void main(String[] args) {
        MaximumProductSubarray solution = new MaximumProductSubarray();
//        System.out.println(solution.maxProduct(new int[]{2, -5, -2,-4,3}));
//        System.out.println(solution.maxProduct(new int[]{-4,-3}));
//        System.out.println(solution.maxProduct(new int[]{-2,0,-1}));
        System.out.println(solution.maxProduct(new int[]{-1,-2,-9,-6}));
    }
}
