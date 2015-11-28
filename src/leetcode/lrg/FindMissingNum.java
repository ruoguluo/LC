package leetcode.lrg;

/**
 * Created by programmer on 11/21/15.
 */
public class FindMissingNum {


        public int missingNumber(int[] nums) {
            int i;
            for (i=0;i<nums.length;i++) {
                while (nums[i]!=i && nums[i]!=nums.length) {
                    int num = nums[i];
                    int tmp = nums[Math.min(nums.length-1,num)];
                    nums[Math.min(nums.length-1,num)] = num;
                    nums[i]=tmp;
                }
            }
            if (nums[0] != 0) return 0;

            for (i=1;i<nums.length;i++) {
                if (nums[i]!=nums[i-1]) break;
            }
            return i;
        }


    public static void main(String[] args) {
        FindMissingNum solution = new FindMissingNum();
        System.out.println(solution.missingNumber(new int[]{2,0}));
    }
}
