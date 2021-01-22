public class Brick {

    // set brick in layer
    public void setBrickInLayout(int[][] layer, int firstPartRow, int firstPartCol, int secondPartRow, int secondPartCol, int k) {
        layer[firstPartRow][firstPartCol] = k;
        layer[secondPartRow][secondPartCol] = k;
    }

    public boolean isInBound(int start, int end, int row, int col) {
        return end < col && end >= 0 && start >= 0 && start < row;
    }

    public boolean hasEmptyPlace(int[][] layer, int firstPartStart, int firstPartEnd, int secondPartStart, int secondPartEnd) {
        return layer[firstPartStart][firstPartEnd] == 0 && layer[secondPartStart][secondPartEnd] == 0;
    }

    public boolean isOverLayoutOne(int[][] layer, int firstPartStart, int firstPartEnd, int secondPartStart, int secondPartEnd) {
        return layer[firstPartStart][firstPartEnd] != layer[secondPartStart][secondPartEnd];
    }
}
