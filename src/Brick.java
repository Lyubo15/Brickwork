public class Brick {

    // set brick in layer
    public void setBrickInLayer(int[][] layer, int firstPartRow, int firstPartCol, int secondPartRow, int secondPartCol, int k) {
        layer[firstPartRow][firstPartCol] = k;
        layer[secondPartRow][secondPartCol] = k;
    }

    // check, if given brick is in bound
    public boolean isInBound(int start, int end, int row, int col) {
        return end < col && end >= 0 && start >= 0 && start < row;
    }

    // chack, if have empty space by given coordinates
    public boolean hasEmptyPlace(int[][] layer, int firstPartStart, int firstPartEnd, int secondPartStart, int secondPartEnd) {
        return layer[firstPartStart][firstPartEnd] == 0 && layer[secondPartStart][secondPartEnd] == 0;
    }

    // chack, if brick from second layer is over first layer
    public boolean isOverLayerOne(int[][] layer, int firstPartStart, int firstPartEnd, int secondPartStart, int secondPartEnd) {
        return layer[firstPartStart][firstPartEnd] != layer[secondPartStart][secondPartEnd];
    }
}
