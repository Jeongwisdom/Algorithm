import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {
        File[] file = new File[files.length];
        for (int i = 0; i < files.length; i++) {
            file[i] = new File(files[i]);
        }
        
        Arrays.sort(file);
        String[] answer = new String[files.length];
        for (int i = 0; i < file.length; i++) {
            answer[i] = file[i].file;
        }
        return answer;
    }
}

class File implements Comparable<File> {
    
    String file;
    String head;
    int num;
    
    public File(String file) {
        this.file = file;
        int id1 = 0;
        for (int i = 0; i < file.length(); i++) {
            if (Character.isDigit(file.charAt(i))) {
                id1 = i;
                break;
            }
        }
        int id2 = 0;
        for (int i = id1 + 1; i <= id1 + 5; i++) {
            if (i == file.length()) {
                id2 = i;
                break;
            }
            if (!Character.isDigit(file.charAt(i))) {
                id2 = i;
                break;
            }
        }
        this.head = file.substring(0, id1).toUpperCase();
        this.num = Integer.parseInt(file.substring(id1, id2));
    }
    
    @Override
    public int compareTo(File f) {
        if (this.head.equals(f.head)) return this.num - f.num;
        return this.head.compareTo(f.head);
    }
}