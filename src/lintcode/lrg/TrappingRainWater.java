package lintcode.lrg;

import java.util.Stack;

/**
 * Created by programmer on 10/7/15.
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] numbers = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.solve(numbers));
    }

    private int solve(int[] heights) {
        int retVal = 0;
        Stack<Integer> stack = new Stack<>();
        //how to initialize the stack?
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            int rightSide = heights[i];
            while (!stack.empty()) {
                int stackTop = stack.peek();
                if (rightSide < stackTop) {
                    stack.push(i);
                    break;
                }
                if (rightSide == stackTop) {
                    break;
                } else {
                    // rightSide > stackTop
                    int bottom = stack.pop();
                    if (!stack.empty()) {
                        int leftSideIndex = stack.peek();
                        int leftSide = heights[leftSideIndex];
                        int lowerSide = Math.min(leftSide, rightSide);
                        retVal += (lowerSide - bottom) * (i - leftSideIndex - 1);
                    }
                }
            }
        }

        return retVal;
    }
}
