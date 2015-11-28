package leetcode.lrg;

import java.util.Arrays;

/**
 * Created by programmer on 11/19/15.
 */
public class CompareVersions {
    public static int compareVersion(String version1, String version2) {
        String[] v1Parts = version1.split("\\.");
        String[] v2Parts = version2.split("\\.");
        int i=0;
        int longerLen=Math.max(v1Parts.length, v2Parts.length);
        String[] newV1 = new String[longerLen];
        String[] newV2 = new String[longerLen];
        Arrays.fill(newV1, "0");
        Arrays.fill(newV2,"0");
        System.arraycopy(v1Parts, 0, newV1, 0, v1Parts.length);
        System.arraycopy(v2Parts, 0, newV2, 0, v2Parts.length);
        while (i<longerLen) {
            if (Integer.parseInt(newV1[i])>Integer.parseInt(newV2[i])) return 1;
            if (Integer.parseInt(newV1[i])<Integer.parseInt(newV2[i])) return -1;
            i++;
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(compareVersion("1.0","1"));
    }
}
