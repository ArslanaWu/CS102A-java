import java.util.Scanner;
public class A3Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] array;
        int numberArray = input.nextInt();
        for(int i = 0;i < numberArray;i++){
            int m = input.nextInt();
            int n = input.nextInt();
            array = new int[m][n];
            for(int hang = 0;hang < m ;hang++){
                for(int lie = 0;lie < n;lie++){
                    array[hang][lie] = input.nextInt();
                }
            }
            int[] lie = new int[m];
            for(int x = 0;x < n;x++) {
                for(int y = 0;y <m;y++){
                lie[y] = array[y][x];
                }
                for(int k = 0;k + 1< m;k++){
                    if(lie[k] == 0 && k != 0){
                        lie[k] = lie[k-1];
                    }
                    int changeOrder = 0;
                    if(lie[k] < lie[k+1]){
                        changeOrder = lie[k];
                        lie[k] = lie[k+1];
                        lie[k+1] = changeOrder;
                    }
                    while(lie[k+1] != 0){
                        int change = lie[k] % lie[k+1];
                        lie[k] = lie[k+1];
                        lie[k+1] = change;
                    }
                }
                System.out.print(lie[m-2]);
                System.out.printf(" ");
            }
            System.out.printf("\n");
        }

    }

}
