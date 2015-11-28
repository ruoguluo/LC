package leetcode.lrg;

/**
 * Created by programmer on 11/22/15.
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        for (int i=1;i<=num.length()/2;i++) {
            if (num.charAt(i)=='0') continue;
            if (helper(num.substring(0,i), num.substring(i))) return true;
        }
        return false;
    }

    private boolean helper(String prev, String rest) {

        for (int i=1;i<=(rest.length()+1)/2;i++) {

            String cur = rest.substring(0,i);
            System.out.println("rest="+rest+",i="+i+",cur="+cur);
            String newRest = rest.substring(i);
            if (newRest.startsWith("0")) continue;
            String sum=Integer.toString(Integer.parseInt(prev)+Integer.parseInt(cur));
            if (newRest.equals(sum)) {
                return true;
            }
            if (newRest.startsWith(sum)) {
                System.out.println(prev+","+cur+","+newRest);
                if(helper(cur,newRest)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main (String[] args) {
        AdditiveNumber solution = new AdditiveNumber();
        System.out.println(solution.isAdditiveNumber("120122436"));
    }
}
