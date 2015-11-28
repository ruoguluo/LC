package leetcode.lrg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by programmer on 11/13/15.
 */
public class ClosetBSTII {

    public static List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        helper(root, target, k, result);
        return result;
    }

    public static void helper(TreeNode root, double target, int k, List<Integer> result) {
        if (root==null) return;
        helper(root.left,target,k,result);
        if (result.size()<k) {
            result.add(root.val);
        }else if (result.size()==k && Math.abs(k-result.get(0))>Math.abs(k-root.val)){
            result.remove(0);
            result.add(root.val);
        }
        helper(root.right,target,k,result);
    }

    public static void main (String[] args) {
        TreeNode node0= new TreeNode(1);
        TreeNode node1= new TreeNode(2);
        node0.left=node1;
        closestKValues(node0, 10, 1);
    }
}
