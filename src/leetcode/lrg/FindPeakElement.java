package leetcode.lrg;

/**
 * Created by programmer on 11/12/15.
 */
public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int len = nums.length;
        int p=0;
        int q=len-1;
        int answer=0;
        while(p<=q) {
            if (p==q) {
                answer=p;
                break;
            }
            int mid = (p+q)/2;
            if (nums[mid]<nums[mid+1]) {
                p=mid+1;
            }else{
                q=mid;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(findPeakElement(new int[]{1,2,3,4,5,6,1}));
        //System.out.println(findPeakElement(new int[]{1,2,3,1}));
    }
}
