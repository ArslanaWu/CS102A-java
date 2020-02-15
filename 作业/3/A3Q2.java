import java.util.Scanner;

public class A3Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = input.nextInt();
        }
        int max = findMax(height);
        int volume = calculateVolume(max,height);
        System.out.print(volume);
    }
    public static int findMax(int[] height){
        int c = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > c) {
                c = height[i];
            }
        }
        return c;
    }
    public static int calculateVolume(int max,int[] height){
        int volume = 0;
        for(int i = max;i > 0;i = i - 1){
            int[] place = new int[height.length];
            for(int j = 0;j < height.length;j++){
                if(height[j] >= i){
                    place[j] = 1;
                }
            }
            for(int j = 0;j < height.length;j++){
                if(place[j]==1){
                    for(int k = j + 1;k < height.length;k++){
                        if(place[k]==1){
                            if(k == j + 1){
                                j = k - 1;
                                break;
                            }else if(k > j + 1){
                                volume = volume + k - j - 1;
                                j = k - 1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return volume;
    }

}
