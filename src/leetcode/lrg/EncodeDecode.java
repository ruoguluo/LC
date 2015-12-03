package leetcode.lrg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by programmer on 11/13/15.
 */
public class EncodeDecode {

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s:strs) {
            int len = s.length();
            sb.append(len);
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        List<String> stringList = new ArrayList<>();
        while(s.length()>0) {
            int pos = s.indexOf('#');
            int len = Integer.parseInt(s.substring(0,pos));
            if (len==0) {
                stringList.add("");
            }else {
                stringList.add(s.substring(pos + 1, pos+1+len));
            }
            s=s.substring(pos+len+1);
        }
        return stringList;
    }

    public static void main (String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("0");
        String en = encode(strs);
        List<String> de = decode(en);
    }
}
