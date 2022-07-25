package string;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println("(int)'a' = " + (int) 'a');
        System.out.println("(int) 'a' - (int) 'a' = " + ((int) 'z' - (int) 'a'));


//        final GroupAnagrams sol = new GroupAnagrams();
//        System.out.println("sol.groupAnagrams(new String[]{}) = " + sol.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
//        System.out.println("sol.groupAnagrams(new String[]{}) = " + sol.groupAnagrams(new String[]{""}));
//        System.out.println("sol.groupAnagrams(new String[]{}) = " + sol.groupAnagrams(new String[]{"a"}));
    }

    public List<List<String>> sol(String[] strs) {
        final HashMap<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            final int[] bitmap = new int[26];
            for (int i = 0; i < s.length(); i++) {
                bitmap[(int)s.charAt(i) - (int)'a']++;
            }
            map.putIfAbsent(Arrays.toString(bitmap), new LinkedList<>());
            map.get(Arrays.toString(bitmap)).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
