import java.io.*;
import java.util.*;

class Main {
    static boolean[] ch = new boolean[26];
    static Set<String> set = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[3][3];
        for (int i = 0; i < 3; i++) {
            String str = br.readLine();
            for (int j = 0; j < 3; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int ind = 0;
        int team = 0;
        for (int i = 0; i < 3; i++) {
            ind += checkInd(arr[i][0], arr[i][1], arr[i][2]);
            team += checkTeam(arr[i][0], arr[i][1], arr[i][2]);
            
            ind += checkInd(arr[0][i], arr[1][i], arr[2][i]);
            team += checkTeam(arr[0][i], arr[1][i], arr[2][i]);
        }
        ind += checkInd(arr[0][0], arr[1][1], arr[2][2]);
        team += checkTeam(arr[0][0], arr[1][1], arr[2][2]);
        
        ind += checkInd(arr[0][2], arr[1][1], arr[2][0]);
        team += checkTeam(arr[0][2], arr[1][1], arr[2][0]);
        System.out.println(ind + "\n" + team);
    }
    
    static int checkInd(char a, char b, char c) {
        if (a == b && b == c) {
            if (!ch[a - 'A']) {
                ch[a - 'A'] = true;
                return 1;
            }
        }
        return 0;
    }
    
    static int checkTeam(char a, char b, char c) {
        Set<Character> uniqueChars = new HashSet<>();
        uniqueChars.add(a);
        uniqueChars.add(b);
        uniqueChars.add(c);

        if (uniqueChars.size() == 2) {
            String teamKey = uniqueChars.toString();
            if (!set.contains(teamKey)) {
                set.add(teamKey);
                return 1;
            }
        }
        return 0;
    }
}