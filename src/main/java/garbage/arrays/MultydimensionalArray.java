package garbage.arrays;

public class MultydimensionalArray {
    public static int[][][] init(int[][][] twodim) {
        for (int i = 0; i < twodim.length; i++) {
            twodim[i] = new int[i + 2][];
            for (int j = 0; j < twodim[i].length; j++) {
                twodim[i] = new int[i][j + 1];
            }
        }
        return twodim;
    }

    public static void print(int[][][] twodim) {
        for (int i = 0; i < twodim.length; i++) {
            for (int j = 0; j < twodim[i].length; j++) {
                for (int k = 0; k < twodim[i][j].length; k++) {
                    for (int ints : twodim[i][j]) {
                        System.out.print(ints);
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][][] twodim = new int[5][][];
        init(twodim);
        print(twodim);


    }
}
