import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class WordBreakerII {
    Map<String, List<String>> memoPad = new HashMap<String, List<String>>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (s.length()==0||wordDict.size()==0) return Collections.emptyList();
        return dfs(s,wordDict);
    }
    
    private List<String> dfs(String s, Set<String> wordDict) {
    	List<String> result = new ArrayList();
    	
        if (s.length()==0) {
        	result.add("");
        	return result;
        }
        if (memoPad.containsKey(s)) return memoPad.get(s);

        for (String word:wordDict) {
            if (s.startsWith(word)) {
                String suffix = s.substring(word.length());
                List<String> tails = dfs(suffix, wordDict);
                     memoPad.put(suffix, tails);
                    for (String tail: tails) {
                        result.add((word+" "+tail).trim());
                    }                
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
    	WordBreakerII solution = new WordBreakerII();
    	Set<String> wordDict = new HashSet<String>();
    	wordDict.add("cat");
    	wordDict.add("cats");
    	wordDict.add("and");
    	wordDict.add("sand");
    	wordDict.add("dog");    	
    	System.out.println(solution.wordBreak("catsanddog", wordDict));
    }
}
