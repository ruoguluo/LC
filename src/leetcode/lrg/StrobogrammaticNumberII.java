package leetcode.lrg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by programmer on 11/7/15.
 */
public class StrobogrammaticNumberII {

    public static List<String> findStrobogrammatic (int n) {
        if (n==0) return Collections.EMPTY_LIST;
        else return findThem(n,n);
    }

    private static List<String> findThem(int n0, int n) {
        if(n0==1) return Arrays.asList("0", "1","8");
        if(n0==0) return Arrays.asList("");
        List<String> inner = findThem(n0-2,n);
        List<String> retVal = new ArrayList<String>();
        for (String innerString:inner) {
            retVal.add("1"+innerString+"1");
            retVal.add("6"+innerString+"9");
            retVal.add("8"+innerString+"8");
            retVal.add("9"+innerString+"6");
            if (n0!=n)
                retVal.add("0"+innerString+"0");
        }
        return retVal;
    }

    public static void main(String[] args){
        List<String> result = findStrobogrammatic(4);
        for (String entry:result) {
            System.out.println(entry);
        }
    }
}
