package leetcode.lrg;

import java.util.*;

/**
 * Created by programmer on 11/14/15.
 */
public class AlienDictionary {

    public static void main(String[] args) {
        AlienDictionary dictionary = new AlienDictionary();
        String[] words = new String[] {"a","b","a"};
        String result = dictionary.alienOrder(words);
        System.out.println(result);
    }

    public String alienOrder(String[] words) {
        if (words.length==1) return words[0];
        StringBuilder sb = new StringBuilder();
        Map<Character,List<Character>> relations = calculateRelations(words);
        Set<Character> allCharSet = getAllChars(words);//a hashset

        while(true){
            Set<Character> childrenSet = getChildrenSet(relations, allCharSet);
            if (childrenSet.isEmpty()) break;
            Set<Character> currentTopLevelSet = new HashSet(allCharSet);
            currentTopLevelSet.removeAll(childrenSet);
            if (currentTopLevelSet.isEmpty()) return "";
            appendToSb(sb,currentTopLevelSet);
            allCharSet.removeAll(currentTopLevelSet);
        }
        appendToSb(sb,allCharSet);
        return sb.toString();
    }

    private void appendToSb(StringBuilder sb, Set<Character> charSet) {
        for (char c:charSet) {
            sb.append(c);
        }
    }

    private Set<Character> getChildrenSet(Map<Character,List<Character>> relations, Set<Character> chars) {
        Set<Character> set = new HashSet<>();
        for (Character c:chars) {
            if (relations.containsKey(c)) {
                set.addAll(relations.get(c));
            }
        }
        return set;
    }

    private Set<Character> getAllChars(String[] words) {
        Set<Character> set = new HashSet<>();
        for (String word:words) {
            for (char c : word.toCharArray()){
                set.add(c);
            }
        }
        return set;
    }

    private Map<Character,List<Character>> calculateRelations(String[] words) {
        Map <Character,List<Character>> map = new HashMap<>();
        for (int i=0;i<words.length-1;i++) {
            String word0=words[i];
            String word1=words[i+1];
            for (int j=0;j<Math.min(word0.length(),word1.length());j++) {
                if (word0.charAt(j)!=word1.charAt(j)){
                    if (map.containsKey(word0.charAt(j))){
                        map.get(word0.charAt(j)).add(word1.charAt(j));
                    }else{
                        List<Character> charList = new ArrayList<>();
                        charList.add(word1.charAt(j));
                        map.put(word0.charAt(j), charList);
                    }
                break;
                }
            }
        }
        return map;
    }
}
