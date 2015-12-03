package leetcode.lrg;

import java.util.StringTokenizer;

/**
 * Created by programmer on 11/13/15.
 */
public class BasicCalculator {

    public static int calculate(String s) {
        if (s.length()==0) return 0;
        return helper(new StringTokenizer(s, "(+-) ",true));
    }

    private static int helper(StringTokenizer stringTokenizer) {
        int val = 0;
        int sign = 1;
        while(stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            if (token.equals("(")) {
                val+=sign*(helper(stringTokenizer));
            }else if (token.equals(")")) {
                return val;
            }else if (token.equals("-")) {
                sign = -1;
            } else if (token.equals("+")){
                sign = 1;
            } else if (!token.equals(" ")) {
                val+=sign*Integer.parseInt(token);
            }
        }
        return val;
    }


    public static void main(String[] args) {
        System.out.println(calculate("2-1 + 2"));
        System.out.println(calculate("(1+2)-3-(4+5)"));
    }
}
