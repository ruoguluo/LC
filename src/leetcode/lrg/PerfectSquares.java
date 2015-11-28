package leetcode.lrg;

/**
 * Created by programmer on 11/8/15.
 */
public class PerfectSquares {
    public static int numSquares(int n) {
        if (n<4) return n;
        int[] arr = new int[n+1];
        arr[1]=1;
        arr[2]=2;
        arr[3]=3;

        for (int i=4;i<=n;i++) {
            double root = Math.sqrt(i);
            if (root==Math.rint(root)) arr[i]=1;
            else{
                int min=i;
                for (int j=1;j<=i/2;j++) {
                    min=Math.min(arr[j]+arr[i-j],min);
                }
                arr[i]=min;
            }
        }
        for (int i=1;i<=n;i++) {
            System.out.println(i+"\t"+arr[i]);
        }
        return arr[n];
    }

    public static void main(String[] args){
        System.out.println(numSquares(18));
    }
}
