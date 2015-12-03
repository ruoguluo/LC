package leetcode.lrg;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by programmer on 11/10/15.
 */
public class TwoDistinctChars {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length()<3) return s.length();
        char[] chars = s.toCharArray();
        int p=0;
        int q=1;
        int max=0;
        int turningPoint=0;
        Set<Character> set = new HashSet<>();
        set.add(chars[p]);
        char lastChar=chars[p];
        while(q<s.length()){
            char currentChar = chars[q];
            set.add(currentChar);

            if (set.size()>2){
                max=Math.max(max,q-p);
                p=turningPoint;
                turningPoint=q;
                set.clear();
                set.add(chars[p]);
                set.add(currentChar);
            }else{
                if (currentChar!=lastChar) {
                    turningPoint=q;
                }
            }
            lastChar=currentChar;
            q++;
        }
        max=Math.max(max,q-p);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("abaccc"));
    }
}
