package leetcode.lrg;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by programmer on 11/7/15.
 */
public class TheSkylineProblem {

    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> skyline = new ArrayList<>();
        PriorityQueue<RH> pq = new PriorityQueue<>();
        int x;
        int i = 0;
        while (i < buildings.length || !pq.isEmpty()) {
            if (pq.isEmpty() || i<buildings.length && buildings[i][0] <= pq.peek().right) {
                x = buildings[i][0];
                while (i < buildings.length && x == buildings[i][0]) {
                    pq.offer(new RH(buildings[i][1], buildings[i][2]));
                    i++;
                }
            } else {
                x = pq.peek().right;
                while (!pq.isEmpty() && pq.peek().right <= x) pq.poll();
            }
            int height = pq.isEmpty() ? 0 : pq.peek().height;
            if (skyline.isEmpty() || height != skyline.get(skyline.size() - 1)[1]) {
                skyline.add(new int[]{x, height});
            }
        }

        return skyline;
    }

    static class RH implements Comparable<RH> {
        int right, height;

        public RH(int right, int height) {
            this.right = right;
            this.height = height;
        }

        @Override
        public int compareTo(RH o) {
            return o.height - this.height;
        }
    }

    public static void main(String[] args){
        int[][] buildings = new int[5][3];
        buildings[0] = new int[]{2,9,10};
        buildings[1] = new int[]{3,7,15};
        buildings[2] = new int[]{5,12,12};
        buildings[3] = new int[]{15,20,10};
        buildings[4] = new int[]{19,24,8};
        List<int[]> skyline = getSkyline(buildings);
        for (int[] entry:skyline) {
            System.out.printf("%d,%d%n", entry[0],entry[1]);
        }
    }


}
