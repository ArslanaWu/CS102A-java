import java.util.Scanner;
public class A3Q1rewrite {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numberArray = input.nextInt();


        for(int j =0;j<numberArray;j++){
            int[][] array= readMatrix(input);

            for(int i = 0;i < array[0].length;i++){
                int[]lie = getColumn(array);
                int gcd = calculateGcd(array,lie);

                System.out.print(gcd);
                System.out.printf(" ");
            }
            System.out.printf("\n");
        }

    }
    public static int[][] readMatrix(Scanner input){
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] array = new int[m][n];
        for(int hang = 0;hang < m ;hang++){
            for(int lie = 0;lie < n;lie++){
                array[hang][lie] = input.nextInt();
            }
        }
        return array;
    }
    public static int[] getColumn(int[][] array) {
        int m = array.length;
        int n = array[0].length;
        int[] lie = new int[m];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                lie[y] = array[y][x];
            }
        }
        return lie;
    }
    public static int calculateGcd (int[][]array,int[] lie) {
        int m = array.length;
        int gcd=0;
        for (int k = 0; k + 1 < m; k++) {
            if (lie[k] == 0 && k != 0) {
                lie[k] = lie[k - 1];
            }
            int changeOrder;
            if (lie[k] < lie[k + 1]) {
                changeOrder = lie[k];
                lie[k] = lie[k + 1];
                lie[k + 1] = changeOrder;
            }
            while (lie[k + 1] != 0) {
                int change = lie[k] % lie[k + 1];
                lie[k] = lie[k + 1];
                lie[k + 1] = change;
            }
            gcd = lie[m-2];
        }
        return gcd;
    }

}



