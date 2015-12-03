import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by vrussell on 2015-11-28.
 */
public class NumberofIslandsII {
    Node[][] nodeGrid;

    class Node {
        int x,y;
        Node parent;
        Node(int x, int y) {
            this.x=x;
            this.y=y;
            this.parent=null;
        }
    }

    private Node getRoot(Node node) {
        if (node.parent==null) return node;
        else return getRoot(node.parent);
    }

    private Set<Node> getNeighbours(int x, int y, int m, int n) {
        Set<Node> neighbours = new HashSet<>();
        if (x-1>=0 && nodeGrid[x-1][y]!=null) neighbours.add(nodeGrid[x-1][y]);
        if (x+1<m && nodeGrid[x+1][y]!=null) neighbours.add(nodeGrid[x+1][y]);
        if (y-1>=0 && nodeGrid[x][y-1]!=null) neighbours.add(nodeGrid[x][y-1]);
        if (y+1<n && nodeGrid[x][y+1]!=null) neighbours.add(nodeGrid[x][y+1]);
        return neighbours;
    }

    private Set<Node> getRoots(Set<Node> nodes) {
        Set<Node> roots = new HashSet<>();
        for (Node node:nodes) {
            roots.add(getRoot(node));
        }
        return roots;
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        nodeGrid=new Node[m][n];
        List<Integer> result = new ArrayList<>();
        int cnt=0;
        for (int[] position:positions) {
            cnt+=1;
            //1. check if there is any neighbours
            int row=position[0];
            int column=position[1];
            Node newNode = new Node(row,column);
            nodeGrid[row][column]=newNode;
            //map.put(String.format("%s,%s", row,column), newNode);
            Set<Node> neighbours = getNeighbours(row, column, m, n);

            if (!neighbours.isEmpty()) {
                //2. link the neighbour to the new node
                Set<Node> roots = getRoots(neighbours);
                for (Node node:roots) {
                    node.parent=newNode;
                }
                //3. update the counter
                cnt-=roots.size();
            }
            result.add(cnt);
        }
        return result;
    }

    public static void main(String[] args) {
        NumberofIslandsII ni = new NumberofIslandsII();
        int[][] positions = {{0,0},{0,1},{1,2},{2,1}};
        System.out.println(ni.numIslands2(3,3,positions));
    }
}
