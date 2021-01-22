import exeptions.EvenNumberException;
import exeptions.MoreThanOneHundredException;

import java.util.Collections;
import java.util.List;

public class Validator {

    // check if given input is more than 99
    public void validateInput(int row, int col) throws Exception {
        if (row > 99 || col > 99) {
            throw new MoreThanOneHundredException("Area has to be less than 100 lines and less than 100 columns");
        } else if (row % 2 != 0 || col % 2 != 0) {
            throw new EvenNumberException("Numbers must be even");
        }
    }

    // Validate if there are bricks spanning 3 rows/ columns
    public boolean validateCountOfBricks(int[][] layer, List<Integer> allBricks) {
        for (int row = 0; row < layer.length; row++) {
            for (int col = 0; col < layer[row].length; col++) {
                // check if there are more than 2 bricks
                if (Collections.frequency(allBricks, layer[row][col]) > 2) {
                    return false;
                }

                // check in row, if there are 3 part of brick
                if (col < layer[row].length - 2 && layer[row][col] == layer[row][col + 1] && layer[row][col] == layer[row][col + 2]) {
                    return false;
                }

                // check in col, if there are 3 part of brick
                if (row < layer.length - 2 && layer[row][col] == layer[row + 1][col] && layer[row][col] == layer[row + 2][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}
