import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start");

//        int[] result = nearby(0, 2, 2); //OK
//        int[] result = nearby(1, 0, 1); // OK
        int[] result = nearby(1, 3, 5); //OK
        System.out.println(Arrays.toString(result));

    }

    public static int[] nearby(int x, int y, int range) {
        int[][] multi = new int[][]{
                {2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323},
                {1, 3, 5, 7},
                {321, 320, 32, 3, 41241, -11, -12, -13, -66, -688}
        };

        int[] arrayTarget = multi[x];
        int[] arrayNearbyLeft;
        int[] arrayNearbyRight;
        int leftRange = y - range;
        int rightRange = (y + 1) + range;

        // y is the index of the array

        // if and try for ArrayIndexOutOfBoundsException

        if (leftRange < 0) {
            leftRange = 0;
        }
        if (rightRange > arrayTarget.length) {
            rightRange = 0;
        }

        try {
            arrayNearbyLeft = Arrays.copyOfRange(arrayTarget, leftRange, y);

        } catch (Exception e) {
            arrayNearbyLeft = new int[]{};
        }
        try {
            arrayNearbyRight = Arrays.copyOfRange(arrayTarget, y + 1, (y + 1) + rightRange);

        } catch (Exception e) {
            arrayNearbyRight = new int[]{};
        }

        // Concatenate Two Arrays using arraycopy
        int[] arrayNearby = new int[arrayNearbyLeft.length + arrayNearbyRight.length];
        System.arraycopy(arrayNearbyLeft, 0, arrayNearby, 0, arrayNearbyLeft.length);
        System.arraycopy(arrayNearbyRight, 0, arrayNearby, arrayNearbyLeft.length, arrayNearbyRight.length);

        return arrayNearby;
    }
}
