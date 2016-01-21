package leetcode.lrg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by programmer on 12/17/15.
 */
public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        helper("", s, 0, result);

        if (result.isEmpty()) result.add("");

        return result;

    }


    void helper(String prefix, String rest, int leftExtra, List<String> result) {

        if (leftExtra == 0) {

            if (result.isEmpty()) {

                result.add(prefix);

            } else {

                if (prefix.length() > result.get(0).length()) {

                    result.clear();

                    result.add(prefix);

                } else

                if (prefix.length() == result.get(0).length()) { result.add(prefix); }

            }

        }

        char lastC = 'x';

        for (int i = 0; i < rest.length(); i++) {

            char c = rest.charAt(i);

            if (c != '(' && c != ')') {

                helper(prefix + c, rest.substring(i + 1), leftExtra, result);

            }

            if (c == '(') {

                if (c == lastC) continue;

                lastC = c;

                helper(prefix + c, rest.substring(i + 1), leftExtra + 1, result);

            }

            if (c == ')') {

                if (leftExtra == 0 || c == lastC) continue;

                lastC = c;

                helper(prefix + c, rest.substring(i + 1), leftExtra - 1, result);

            }

        }

    }

    public static void main(String[] args) {
        RemoveInvalidParentheses rip = new RemoveInvalidParentheses();
        System.out.println(rip.removeInvalidParentheses("n("));
    }
}
