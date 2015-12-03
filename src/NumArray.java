/**
 * Created by vrussell on 2015-11-28.
 */
public class NumArray {
    int[] sums;
    int[] nums;

    public NumArray(int[] nums) {
        this.nums=nums;
        if (nums.length==0) return;
        sums=new int[nums.length];
        sums[0] = nums[0];
        for (int i=1;i<nums.length;i++) {
            sums[i]=sums[i-1]+nums[i];
        }
    }

    void update(int i, int val) {
        if (nums.length==0) return;
        int delta = val-nums[i];
        for (int j=i;j<sums.length;j++) {
            sums[j]+=delta;
        }
    }

    public int sumRange(int i, int j) {
        if (nums.length==0) return 0;
        if (i==0) {
            return sums[j];
        }else{
            return sums[j]-sums[i-1];
        }
    }

    public static void  main(String[] args) {
        // Your NumArray object will be instantiated and called as such:
        int[] nums={1, 3, 5};
 NumArray numArray = new NumArray(nums);
 System.out.println(numArray.sumRange(0, 1));
 numArray.update(1, 10);
 System.out.println(numArray.sumRange(1, 2));
    }
}
