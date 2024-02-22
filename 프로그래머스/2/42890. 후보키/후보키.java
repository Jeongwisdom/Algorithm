import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        List<String> index;
        List<Set<String>> list;
        List<String> answer = new ArrayList<>();
        List<String> regex = new ArrayList<>();
        int count = 0;
        while (count++ < relation[0].length) {
            index = new ArrayList<>();
            boolean[] ch = new boolean[relation[0].length];
            combi(regex, index, new StringBuilder(), ch, 0, 0, count);

            list = new ArrayList<>();
            for (int i = 0; i < index.size(); i++) {
                list.add(new HashSet<>());
            }

            String s;
            for (int i = 0; i < relation.length; i++) {
                for (int j = 0; j < index.size(); j++) {
                    s = index.get(j);
                    StringBuilder str = new StringBuilder();
                    for (int k = 0; k < s.length(); k++) {
                        str.append(relation[i][s.charAt(k) - '0']);
                    }
                    list.get(j).add(str.toString());
                }
            }

            for (int i = 0; i < index.size(); i++) {
                if (list.get(i).size() == relation.length) {
                    answer.add(index.get(i));
                    StringBuilder sb = new StringBuilder();
                    for (char c: index.get(i).toCharArray()) {
                        sb.append("(.*")
                            .append(c)
                            .append(".*)");
                    }
                    regex.add(sb.toString());
                }
            }
        }

        return answer.size();
    }
    
    private void combi(List<String> regex, List<String> index, StringBuilder sb, boolean[] ch, int l, int id, int count) {
        if (l == count) {
            for (String str: regex) {
                if (sb.toString().matches(str)) return;
            }
            index.add(sb.toString());
        } else {
            for (int i = id; i < ch.length; i++) {
                if (!ch[i]) {
                    ch[i] = true;
                    combi(regex, index, new StringBuilder(sb).append(i), ch, l + 1, i + 1, count);
                    ch[i] = false;
                }
            }
        }
    }
}