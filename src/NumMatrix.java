
public class NumMatrix {
    
    int rows, columns;
    int[][] sums;
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        rows = matrix.length;
        if (rows>0 ){
        columns = matrix[0].length;
        sums = new int[rows][columns];
        for (int i=0;i<rows;i++) {
        	sums[i][0]=matrix[i][0];
            for (int j=1;j<columns;j++){
                sums[i][j]=sums[i][j-1]+matrix[i][j];
            }
        }
        }
    }

    public void update(int row, int col, int val) {
    	if (rows==0) return;
        int delta = val - matrix[row][col];
        for (int j=col;j<columns;j++){
            sums[row][j]+=delta;
        }
        matrix[row][col]=val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if (rows==0) return 0;
        int sum=0;
        for (int i=row1;i<=row2;i++) {
            if (col1>0) {
                sum+=sums[i][col2]-sums[i][col1-1];
            }else {
                sum+=sums[i][col2];
            }
        }
        return sum;
    }
    
    public static void main (String[] args) {
//    	int[][] nums={
//        		{3,0,1,4,2},
//        		{5,6,3,2,1},
//        		{1,2,0,1,5},
//        		{4,1,0,1,7},
//        		{1,0,3,0,5}
//        	};
    	int[][] nums={{1}};
    	
    	NumMatrix nm = new NumMatrix (nums);
    	nm.update(0, 0, -1);
    	System.out.println(nm.sumRegion(0,0,0,0));
    	
//    	System.out.println(nm.sumRegion(2, 1, 4, 3));
//    	nm.update(3, 2, 2);
//    	System.out.println(nm.sumRegion(2, 1, 4, 3));
    	
//    	System.out.println(nm.sumRegion(0, 0, 0, 0));
//    	nm.update(0, 0, -1);
//    	System.out.println(nm.sumRegion(0, 0, 0, 0));
    	
    	
    	//[[2,4],[-3,5]],update(0,1,3,update(1,1,-3,update(0,1,1,sumRegion(0,0,1,1)
//    	int[][] nums={
//        		{2,3},
//        		{-3,5}
//        	};
//    	nm = new NumMatrix (nums);
//    	nm.update(0, 1, 3);
//    	System.out.println(nm.sumRegion(0, 0, 1, 1));
//    	nm.update(1, 1, -3);
//    	System.out.println(nm.sumRegion(0, 0, 1, 1));
//    	nm.update(0, 1, 1);
//    	System.out.println(nm.sumRegion(0, 0, 1, 1));
    }
}
