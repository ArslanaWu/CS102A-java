import java.util.Scanner;

public class A3Q6 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] dp = new int[m][n];

        int[][] map = readMatrix(m,n,input);
        int shortest = calculateShortest(map,dp);
        System.out.print(shortest);

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
    public static int calculateShortest(int[][] map,int[][]dp){
        int m = map.length;
        int n = map[0].length;
        dp[0][0]= map[0][0];
        for(int i = 1;i<n;i++){
            dp[0][i]=dp[0][i-1]+map[0][i];
        }
        for(int i = 1;i<m;i++){
           dp[i][0]=dp[i-1][0]+map[i][0];
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+map[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
