import java.util.Scanner;

public class A3Q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] map = readMatrix(m,n,input);
        int t = input.nextInt();
        int[] sum = new int[t];

        for(int i = 0;i<t;i++){
            sum[i] = getSum(map,input);
            System.out.println(sum[i]);
        }
    }
    public static int[][] readMatrix(int m,int n,Scanner input){
        int[][] map = new int[m][n];
        for(int i = 0;i < m ;i++){
            for(int j = 0;j < n;j++){
                map[i][j] = input.nextInt();
            }
        }
        return map;
    }
    public static int getSum(int[][]map,Scanner input){
        int x1 = input.nextInt();
        int y1 = input.nextInt();
        int x2 = input.nextInt();
        int y2 = input.nextInt();
        int sum = 0;

        for(int i = x1;i<x2+1;i++){
            for(int j = y1;j<y2+1;j++){
                sum = sum + map[i][j];
            }
        }
        return sum;
    }
}
