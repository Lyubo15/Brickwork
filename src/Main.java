import java.util.*;

public class Main {

    public static void main(String[] s) throws Exception {
        // 1. -- Read Input (row & col) --

        Input<Scanner> input = new Input<>(new Scanner(System.in));
        Printer printer = new Printer();

        System.out.println("Enter dimensions of area (N x M)");
        int[] size = input.getSize();
        int rootRow = size[0];
        int rootCol = size[1];

        // 2. -- Validate row and col given by user --
        Validator validator = new Validator();

        try {
            validator.validateInput(rootRow, rootCol);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        // 3. -- Fill first layer which has already been done by builders --

        int[][] layerOne = new int[rootRow][rootCol];
        System.out.println("Enter Layer 1");

        List<Integer> allBricks =  input.fillLayer(rootRow, layerOne);

        // 4. -- Check count of bricks --
        if (!validator.validateCountOfBricks(layerOne, allBricks)) {
            System.out.print("Invalid input");
        } else {
            // 5. -- Print Layer 1 --
            System.out.println("Layer 1 - with walls");
           printer.printLayerWithWalls(layerOne);
            System.out.println("Layer 1 - without walls");
           printer.printLayer(layerOne);

            int[][] layerTwo = new int[rootRow][rootCol];

            Layer layer = new Layer(new Brick());

            // 6. -- Generate Layer Two --

            boolean isGenerateSuccessfully = layer.generateLayer(layerOne, layerTwo, 0, 0, 1, false);

            if (isGenerateSuccessfully) {
                // 7. -- Print Layer 2 --
                System.out.println("Layer 2 - with walls");
                printer.printLayerWithWalls(layerTwo);
                System.out.println("Layer 2 - without walls");
                printer.printLayer(layerTwo);
            } else {
                System.out.println("-1");
            }
        }
    }
}