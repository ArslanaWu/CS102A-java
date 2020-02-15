import java.util.Scanner;
public class A3Q2initial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] height = new int[n];
        for(int i =0;i<n;i++){
            height[i]=input.nextInt();
        }
        int[] volume = new int[n];
        int volumee = 0;
        int place = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0 && i < n - 1) {
                if (height[i - 1] > height[i]) {
                    for (int j = i + 1; j < n; j++) {
                        if (height[j] > height[i]) {
                            if(height[j+1]<height[j] || j==n-1){
                                place = j+1;
                                if (height[j] < height[i - 1]){
                                    for (int v = i; v < j; v++){
                                        volume[i] = height[j] - height[i];
                                    }break;
                                }else if (height[j] >= height[i - 1]){
                                    for (int v = i; v <j; v++){
                                        volume[v] = height[i-1] - height[v];
                                    }break;
                                }
                            }
                        }
                    }
                    if(i<n-2){
                        i = place-1;
                    }

                }

            }
        }
        for(int i=0;i<n;i++){
            volumee = volumee + volume[i];
        }
        System.out.print(volumee);
    }
}