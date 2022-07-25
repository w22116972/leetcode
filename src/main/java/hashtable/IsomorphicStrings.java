package hashtable;

import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMapT = new HashMap<>();
        HashMap<Character, Character> tMapS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            final Character ss = s.charAt(i);
            final Character tt = t.charAt(i);

            if (!sMapT.containsKey(ss) && !tMapS.containsKey(tt)) {
                sMapT.put(ss, tt);
                tMapS.put(tt, ss);
            } else if (sMapT.get(ss) != tt || tMapS.get(tt) != ss) {
                return false;
            }
        }
        return true;
    }
}
