import java.util.ArrayList;
import java.util.List;

public class Printer {

    public void printLayerWithWalls(int[][] layer) {
        System.out.println();
        List<Integer> columnsWithNumbersWithTwoDigits = checkIfHaveNumberWithTwoDigits(layer);

        System.out.println("* ".repeat(layer[0].length + 1));
        for (int row = 0; row < layer.length; row++) {
            System.out.print("*");

            if (row >= 1) {
                for (int col = 0; col < layer[row].length; col++) {
                    if (layer[row - 1][col] == layer[row][col]) {
                        if (columnsWithNumbersWithTwoDigits.contains(col)) {
                            System.out.print("--*");
                        } else {
                            System.out.print("-*");
                        }
                    } else {
                        if (columnsWithNumbersWithTwoDigits.contains(col)) {
                            System.out.print("***");
                        } else {
                            System.out.print("**");
                        }
                    }
                }
                System.out.println();
                System.out.print("*");
            }

            for (int col = 0; col < layer[row].length; col++) {
                System.out.print(layer[row][col]);
                if (col + 1 < layer[row].length && layer[row][col] == layer[row][col + 1]) {
                    if (columnsWithNumbersWithTwoDigits.contains(col)) {
                        System.out.print("--");
                    } else {
                        System.out.print("-");
                    }
                } else {
                    if (columnsWithNumbersWithTwoDigits.contains(col)) {
                        System.out.print("**");
                    } else {
                        System.out.print("*");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("* ".repeat(layer[0].length + 1));

        System.out.println();
    }

    private List<Integer> checkIfHaveNumberWithTwoDigits(int[][] layer) {
        List<Integer> columns = new ArrayList<>();

        for (int col = 0; col < layer[0].length; col++) {
            for (int row = 0; row < layer.length; row++) {
                if (layer[row][col] > 9) {
                    columns.add(col - 1);
                    break;
                }
            }
        }
        return columns;
    }

    public void printLayer(int[][] layer) {
        System.out.println();

        for (int row = 0; row < layer.length; row++) {
            for (int col = 0; col < layer[row].length; col++) {
                System.out.print(layer[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
