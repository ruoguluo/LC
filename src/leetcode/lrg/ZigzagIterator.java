package leetcode.lrg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by programmer on 11/6/15.
 */
public class ZigzagIterator {

    List<List<Integer>> lists;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        lists = new ArrayList<List<Integer>>();
        if (!v1.isEmpty()) lists.add(v1);
        if (!v2.isEmpty()) lists.add(v2);
    }

    public int next() {
        int retVal = lists.get(0).remove(0);
        List<Integer> firstList = lists.remove(0);
        if(!firstList.isEmpty()) lists.add(firstList);
        return retVal;
    }

    public boolean hasNext() {
        return !lists.isEmpty();
    }
}
