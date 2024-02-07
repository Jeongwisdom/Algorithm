import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        char[] c1 = str1.toUpperCase().toCharArray();
        char[] c2 = str2.toUpperCase().toCharArray();
        Map<String, Integer> a = new HashMap<>();
        Map<String, Integer> b = new HashMap<>();
        Map<String, Integer> intersection = new HashMap<>();
        Map<String, Integer> union = new HashMap<>();
        String str;
        
        for (int i = 0; i < c1.length - 1; i++) {
            if (Character.isAlphabetic(c1[i]) && Character.isAlphabetic(c1[i + 1])) {
                str = String.valueOf(c1[i]) + String.valueOf(c1[i + 1]);
                a.put(str, a.getOrDefault(str, 0) + 1);
            }
        }
        for (int i = 0; i < c2.length - 1; i++) {
            if (Character.isAlphabetic(c2[i]) && Character.isAlphabetic(c2[i + 1])) {
                str = String.valueOf(c2[i]) + String.valueOf(c2[i + 1]);
                b.put(str, b.getOrDefault(str, 0) + 1);
            }
        }
        
        for (Map.Entry<String, Integer> entry: a.entrySet()) {
            intersection.put(entry.getKey(), Math.min(entry.getValue(), b.getOrDefault(entry.getKey(), 0)));
            union.put(entry.getKey(), Math.max(entry.getValue(), b.getOrDefault(entry.getKey(), 0)));
        }
        
        for (Map.Entry<String, Integer> entry: b.entrySet()) {
            intersection.put(entry.getKey(), Math.min(entry.getValue(), a.getOrDefault(entry.getKey(), 0)));
            union.put(entry.getKey(), Math.max(entry.getValue(), a.getOrDefault(entry.getKey(), 0)));
        }
        
        int inter = 0;
        int uni = 0;
        for (int i: intersection.values()) inter += i;
        for (int i: union.values()) uni += i;
        
        return uni == 0? 65536: inter * 65536 / uni;
    }
}