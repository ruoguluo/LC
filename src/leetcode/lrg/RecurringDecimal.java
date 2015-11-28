package leetcode.lrg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by programmer on 11/11/15.
 */
public class RecurringDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator==0) return "0";
        String sign ="";
        if (numerator < 0 ^ denominator < 0) {
            sign = "-";
        }
        Long lnumerator = Math.abs((long) numerator);
        long ldenominator = Math.abs((long)denominator);
        long intPart = lnumerator / ldenominator;
        long reminder = lnumerator % ldenominator;
        if (reminder == 0) return sign + intPart;
        List<Long> decPart = new ArrayList<>();
        Map<Long, Integer> map = new HashMap<>();
        map.put(reminder,0);
        int recurrStartPoint=-1;
        while(reminder!=0){
            reminder*=10;
            decPart.add(reminder/ldenominator);
            reminder%=denominator;
            if (map.containsKey(reminder)) {
                recurrStartPoint = map.get(reminder);
                break;
            }
            map.put(reminder,decPart.size());
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<decPart.size();i++) {
            if (i==recurrStartPoint) sb.append("(");
            sb.append(decPart.get(i));
        }
        if (recurrStartPoint>-1) sb.append(")");

        return sign + intPart + "." + sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(fractionToDecimal(1,2));
//        System.out.println(fractionToDecimal(2,1));
       // System.out.println(fractionToDecimal(2, 600));
        System.out.println(fractionToDecimal(-2147483648, 1));
//        System.out.println(Math.abs(-2147483648));
        // System.out.println(fractionToDecimal(-2147483648,-10));
    }
}
