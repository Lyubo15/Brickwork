public class Layer {

    private Brick brick;

    public Layer(Brick brick) {
        this.brick = brick;
    }

    public boolean generateLayer(int[][] layerOne, int[][] layerTwo, int start, int end, int value, boolean isTaken) {
        if (isTaken) { return true; }

        int col = layerOne[0].length;
        int row = layerOne.length;

        if (value > col * row / 2) { return true; }

        // try to fill in row and check bound, if has empty place and if over layer one
        if (this.brick.isInBound(start, end, row, col - 1) && this.brick.hasEmptyPlace(layerTwo, start, end, start, end + 1)
                && this.brick.isOverLayerOne(layerOne, start, end, start, end + 1)) {

            this.brick.setBrickInLayer(layerTwo, start, end, start, end + 1, value);
            isTaken = move(layerOne, layerTwo, start, end + 1, value, isTaken);

            if (!isTaken) {
                this.brick.setBrickInLayer(layerTwo, start, end, start, end + 1, 0);
            }
            // try to fill in col and check bound, if has empty place and if over layer one
        } else if (this.brick.isInBound(start, end, row - 1, col) && this.brick.hasEmptyPlace(layerTwo, start, end, start + 1, end) &&
                this.brick.isOverLayerOne(layerOne, start, end, start + 1, end)) {

            this.brick.setBrickInLayer(layerTwo, start, end, start + 1, end, value);
            isTaken = move(layerOne, layerTwo, start, end, value, isTaken);

            if (!isTaken) {
                this.brick.setBrickInLayer(layerTwo, start, end, start + 1, end, 0);
            }
        }
        return isTaken;
    }

    // This method goes through the all sides of layer
    private boolean move(int[][] layerOne, int[][] layerTwo, int start, int end, int value, boolean isTaken) {
        isTaken = generateLayer(layerOne, layerTwo, start + 1, end, value + 1, isTaken);
        isTaken = generateLayer(layerOne, layerTwo, start - 1, end, value + 1, isTaken);
        isTaken = generateLayer(layerOne, layerTwo, start, end + 1, value + 1, isTaken);
        isTaken = generateLayer(layerOne, layerTwo, start, end - 1, value + 1, isTaken);
        isTaken = generateLayer(layerOne, layerTwo, start + 1, end - 1, value + 1, isTaken);
        isTaken = generateLayer(layerOne, layerTwo, start + 1, end + 1, value + 1, isTaken);
        isTaken = generateLayer(layerOne, layerTwo, start - 1, end - 1, value + 1, isTaken);
        isTaken = generateLayer(layerOne, layerTwo, start + 1, end - 1, value + 1, isTaken);
        return isTaken;
    }
}
