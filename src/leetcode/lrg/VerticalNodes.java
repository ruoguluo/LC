package leetcode.lrg;

import java.util.*;

/**
 * Created by vrussell on 2015-12-05.
 */
public class VerticalNodes {

    class LevelValue implements Comparable<LevelValue> {
        int level;
        int value;
        public LevelValue(int level, int value) {
            this.level = level;
            this.value = value;
        }

        @Override
        public int compareTo(LevelValue o) {
            return this.level-o.level;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<LevelValue>> map = new TreeMap<>();
        helper(root, 0, 0, map);
        List<List<Integer>> result = new ArrayList<>();
        for (Integer key: map.keySet()) {
            List<LevelValue> valueList = map.get(key);
            Collections.sort(valueList);
            List<Integer> intList = new ArrayList<>();
            for (LevelValue v:valueList) {
                intList.add(v.value);
            }
            result.add(intList);
        }
        return result;
    }

    public void helper(TreeNode root, int key, int level, Map<Integer, List<LevelValue>> map) {
        if (root == null) return;
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        List<LevelValue> theList = map.get(key);
        theList.add(new LevelValue(level, root.val));
        helper(root.left, key-1, level+1, map);
        helper(root.right, key+1, level+1, map);
    }
}
