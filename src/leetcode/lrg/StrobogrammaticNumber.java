package leetcode.lrg;

/**
 * Created by programmer on 11/7/15.
 */
public class StrobogrammaticNumber {
    public static boolean isStrobogrammatic(String num) {
        for (int i=0;i<(num.length()+1)/2;i++) {
            char c1=num.charAt(i);
            char c2=num.charAt(num.length()-i-1);
            if (c1==c2) {
                if (c1!='0' && c1!='1' && c1!='8') return false;
            }else{
                if (!(c1=='6' && c2=='9' || c1=='9' && c2=='6')) return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        System.out.println(isStrobogrammatic("2"));
    }
}
