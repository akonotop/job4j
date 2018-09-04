package list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] number : array ) {
            for (int i : number) {
                list.add(i);
            }
        }
        return list;
    }
}
