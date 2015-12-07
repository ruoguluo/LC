package test;

/**
 * Created by programmer on 11/11/15.
 */
public class Swifts {
    public static void main(String[] args) {
        int n = 1;
        System.out.println(n<<1);


        int[][] memoPad = new int [10][10];
        for (int i=0;i<10;i++) {
            for (int j=0;j<10;j++) {
                System.out.print(memoPad[i][j]);
            }
            System.out.println();
        }
    }
}
