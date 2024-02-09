import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        List<Music> answer = new ArrayList<>();
        String play, tmp;
        Music music;
        m = replaceHash(m);

        for (int i = 0; i < musicinfos.length; i++) {
            music = new Music(musicinfos[i]);
            play = playMusic(music.time, replaceHash(music.sheet));
            if (play.contains(m)) {
                answer.add(music);
            }
        }
        Collections.sort(answer);

        return answer.size() == 0? "(None)": answer.get(0).title;
    }

    public String playMusic(int time, String sheet) {
        StringBuilder sb = new StringBuilder();

        sb.append(sheet.repeat(Math.max(0, time / sheet.length())));
        sb.append(sheet.substring(0, time % sheet.length()));

        return sb.toString();
    }
    
    public String replaceHash(String sheet) {
        char[] c = new char[] {'A', 'C', 'D', 'F', 'G'};
        String a;
        for (int i = 0; i < c.length; i++) {
            a = c[i] + "#";
            sheet = sheet.replace(a, String.valueOf((char) (c[i] + 32)));
        }
        
        return sheet;
    }
}

class Music implements Comparable<Music> {
    
    int time;
    String title;
    String sheet;
    
    public Music(String musicInfo) {
        String[] split = musicInfo.split(",");
        this.time = calculateTime(split[0], split[1]);
        this.title = split[2];
        this.sheet = split[3];
    }
    
    private int calculateTime(String t1, String t2) {
        String[] st = t1.split(":");
        String[] et = t2.split(":");
        return Integer.parseInt(et[0]) * 60 + Integer.parseInt(et[1]) - Integer.parseInt(st[0]) * 60 - Integer.parseInt(st[1]);
    }
    
    @Override
    public int compareTo(Music m) {
        return m.time - this.time;
    }
}