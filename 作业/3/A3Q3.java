import java.util.Scanner;

public class A3Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] matrix = new int[m][n];

        matrix = fillMatrix(matrix);

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(m*n<100){
                    System.out.printf("%-3d",matrix[i][j]);
                    if(j == n-1){
                        System.out.printf("\n");
                    }
                }else if(m*n<1000 && m*n>100){
                    System.out.printf("%-4d",matrix[i][j]);
                    if(j == n-1){
                        System.out.printf("\n");
                    }
                }

            }
        }
    }
    public static int[][] fillMatrix(int[][] matrix){
        int number = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        int size = m*n;

        for(int i = 0;i<n;i++){
            for(int j = n-i-1;j>i-1;j--){
                if(checkStop(number,size)){
                    break;
                }
                matrix[i][j] = number;
                number++;
            }for(int j = i;j<m-i;j++){
                if(checkStop(number,size)){
                    break;
                }
                if(j == i){
                    number = number-1;
                }
                matrix[j][i] = number;
                number++;
            }for(int j = i;j<n-i;j++){
                if(checkStop(number,size)){
                    break;
                }
                if(j == i){
                    number = number-1;
                }
                matrix[m-i-1][j] = number;
                number++;
            }for(int j = m-i-1;j>i;j--){
                if(checkStop(number,size)){
                    break;
                }
                if(j == m-i-1){
                    number = number-1;
                }
                matrix[j][n-i-1] = number;
                number++;
            }
        }
        return matrix;
    }

    public static boolean checkStop(int number,int size){
        if(number == size + 1){
            return true;
        }else{
            return false;
        }
    }

}
