package list;

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
        if (list.size() / rows != cells) {
            for (int i = list.size(); i < cells; i++) {
                array [row][i] = 0;
            }
        }
        return array;
    }
}
