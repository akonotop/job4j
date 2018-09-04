package list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows != 0 ? list.size() / rows + 1 : list.size() / rows;
        int[][] array = new int[rows][cells];
        int row = 0, cell = 0;

        for (Integer value : list) {
            if (cell == cells - 1) {
                array[row][cell] = value;
                cell = 0;
                row++;
            } else {
                array[row][cell] = value;
                cell++;
            }
        }
        return array;
    }
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] arr : list) {
            for (int value : arr) {
                result.add(value);
            }
        }
        return result;
    }
}
