import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input<T extends Scanner>{

    private T reader;

    public Input(T reader) {
        this.reader = reader;
    }

    public int[] getSize() throws Exception {
        String[] size = this.reader.nextLine().split(" ");

        int rootRow = Integer.parseInt(size[0]);
        int rootCol = Integer.parseInt(size[1]);

        return new int[]{rootRow, rootCol};
    }

    // fill layer with given input
    public List<Integer> fillLayer(int rootRow, int[][] layerOne) {
        List<Integer> allBricks = new ArrayList<>();
        for (int row = 0; row < rootRow; row++) {
            String[] input = this.reader.nextLine().split(" ");
            for (int col = 0; col < input.length; col++) {
                int num = Integer.parseInt(input[col]);
                layerOne[row][col] = num;
                allBricks.add(num);
            }
        }

        return allBricks;
    }
}
