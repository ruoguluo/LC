package leetcode.lrg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by vrussell on 2015-12-09.
 */
public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        Set allCharSet = new HashSet<>();
        Set foundCharSet = new HashSet<>();
        for (int i=0;i<s.length();i++) {
            allCharSet.add(s.charAt(i));
        }
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<allCharSet.size();i++) {
            Set auxSet = new HashSet<>(allCharSet);
            auxSet.removeAll(foundCharSet);
            for (int j = s.length()-1; j>=0;j--) {
                auxSet.remove(s.charAt(j));
                if (auxSet.isEmpty()) {
                    char minChar = '{';
                    int pos = 0;
                    for (int k=j;k>=0;k--) {
                        if (!foundCharSet.contains(s.charAt(k)) && s.charAt(k) <= minChar) {
                            minChar = s.charAt(k);
                            pos = k;
                        }
                    }
                    s = s.substring(pos+1);
                    sb.append(minChar);
                    foundCharSet.add(minChar);
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("abacb"));
    }
}
