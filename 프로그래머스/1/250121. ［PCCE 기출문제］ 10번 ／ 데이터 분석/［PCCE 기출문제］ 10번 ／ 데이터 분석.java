import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Data> list = new ArrayList<>();
        int idx = 0;
        switch (ext) {
            case "date":
                idx = 1;
                break;
            case "maximum":
                idx = 2;
                break;
            case "remain":
                idx = 3;
                break;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i][idx] < val_ext) {
                list.add(new Data(data[i][0], data[i][1], data[i][2], data[i][3]));
            }
        }
        
        
        switch (sort_by) {
            case "code":
                Collections.sort(list, (d1, d2) -> d1.code - d2.code);
                break;
            case "date":
                Collections.sort(list, (d1, d2) -> d1.date - d2.date);
                break;
            case "maximum":
                Collections.sort(list, (d1, d2) -> d1.maximum - d2.maximum);
                break;
            case "remain":
                Collections.sort(list, (d1, d2) -> d1.remain - d2.remain);
                break;
        }
        
        int[][] answer = new int[list.size()][4];
        Data d;
        for (int i = 0; i < list.size(); i++) {
            d = list.get(i);
            answer[i][0] = d.code;
            answer[i][1] = d.date;
            answer[i][2] = d.maximum;
            answer[i][3] = d.remain;
        }
        
        return answer;
    }
}

class Data {
    
    int code;
    int date;
    int maximum;
    int remain;
    
    public Data(int code, int date, int maximum, int remain) {
        this.code = code;
        this.date = date;
        this.maximum = maximum;
        this.remain = remain;
    }
}