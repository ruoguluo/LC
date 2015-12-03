package leetcode.lrg;

/**
 * Created by programmer on 11/16/15.
 */
public class WallsGates {
    int dx[]=new int[]{-1,0,1,0};
    int dy[]=new int[]{0,-1,0,1};
    int rows;
    int columns;
    public void wallsAndGates(int[][] rooms) {
        if (rooms==null) return;
        rows = rooms.length;
        if (rows==0) return;
        columns = rooms[0].length;
        for (int i=0;i<rows;i++) {
            for (int j=0;j<columns;j++){
                if (rooms[i][j]==0) {
                    dfs(i,j,rooms,0);
                }
            }
        }
    }

    private void dfs(int row, int column, int[][] rooms, int distance) {

        if (row<0||row==rows||column<0||column==columns||rooms[row][column]==-1||
                rooms[row][column]<distance)
            return;
        rooms[row][column]=distance;
        for (int i=0;i<dx.length;i++) {
            dfs(row+dy[i], column+dx[i], rooms, distance+1);
        }
    }

    public static void main(String[] args) {
        WallsGates wg = new WallsGates();
        int[][] rooms = {
            {Integer.MAX_VALUE, -1,0,Integer.MAX_VALUE},
            {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-1},
            {Integer.MAX_VALUE,-1,Integer.MAX_VALUE,-1},
                    {0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}
        };
        wg.wallsAndGates(rooms);
        for (int i=0;i<rooms.length;i++) {
            for (int j=0;j<rooms[0].length;j++) {
                System.out.print (rooms[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
