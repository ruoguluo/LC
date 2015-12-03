package leetcode.lrg;

import java.util.Arrays;

/**
 * Created by programmer on 11/11/15.
 */
public class HIndex {

    public static int hIndex(int[] citations) {
        int retVal = 0;
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] >= (citations.length - i)) {
                retVal = citations.length - i;
            }
        }
        return retVal;
    }

    public static void main(String[] args){
        System.out.println(hIndex(new int[]{6,5,3,1,0}));
    }
}