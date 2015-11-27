import java.util.*;

/**
 * Created by vrussell on 2015-11-26.
 */
public class MinimumHeightTrees {


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] map = new List[n];
        for (int[] edge : edges) {
            if (map[edge[0]] == null) map[edge[0]] = new ArrayList<>();
            map[edge[0]].add(edge[1]);
            if (map[edge[1]] == null) map[edge[1]] = new ArrayList<>();
            map[edge[1]].add(edge[0]);
        }
        Set<Integer> nodes = new HashSet<>();
        for (int i = 0; i < n; i++) nodes.add(i);

        while (nodes.size() > 2) {
            Set<Integer> leaves = new HashSet<>();
            Set<Integer> nodesAffected = new HashSet<>();
            for (int i:nodes) {
                if (map[i].size() == 1) {
                    leaves.add(i);
                    nodesAffected.add(map[i].get(0));
                }
            }
            for (int node:nodesAffected) {
                map[node].removeAll(leaves);
            }

            nodes.removeAll(leaves);
        }
        return new ArrayList<Integer>(nodes);
    }


    public static void main(String[] args) {
        MinimumHeightTrees mht = new MinimumHeightTrees();
        int[][] edges = {{1,0},{1,2},{1,3}};
        System.out.println(mht.findMinHeightTrees(4, edges));
        int[][] edges2 = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        System.out.println(mht.findMinHeightTrees(6, edges2));
        int[][] edges3 = {{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}};
        System.out.println(mht.findMinHeightTrees(6, edges3));
    }
}
