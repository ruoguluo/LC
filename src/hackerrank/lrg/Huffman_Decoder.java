package hackerrank.lrg;

/**
 * Created by programmer on 11/20/15.
 */
public class Huffman_Decoder {
    public static void main(String[] args) {
        String line = " \t01001";
        String[] tokens = line.split("\\t");
        System.out.println(tokens.length);
        System.out.println("-" + tokens[0] +"-");
        System.out.println("-" + tokens[1] +"-");
        StringBuilder sb = new StringBuilder("abcde");
        sb.delete(0,2);
        System.out.println(sb);
        System.out.println(sb.length());
    }
}
