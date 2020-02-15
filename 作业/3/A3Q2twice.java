import java.util.Arrays;
import java.util.Scanner;

public class A3Q2twice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = input.nextInt();
        }
        int[] heightcopy = Arrays.copyOf(height, n);

        int[] maxleft = new int[n];
        maxleft = findMaxLeft(maxleft, heightcopy);
        int[] maxright = new int[n];
        maxright = findMaxRight(maxright, heightcopy);


        int volumn = calculateVolume(maxleft, maxright, height);
        System.out.print(volumn);

    }

    public static int[] findMaxLeft(int[] maxleft, int[] heightcopy) {


        int c = Integer.MIN_VALUE;
        for (int i = 0; i < heightcopy.length; i++) {
            if (heightcopy[i] > c) {
                c = heightcopy[i];
            }
        }
        for (int i = 0; i < heightcopy.length; i++) {
            if (heightcopy[i] == c) {
                maxleft[i] = 1;
                heightcopy = Arrays.copyOfRange(heightcopy, 0, i + 1);
                break;
            }
        }
        if (heightcopy.length > 0){
            return findMaxLeft(maxleft, heightcopy);
        }else{
            return maxleft;
        }


    }

    public static int[] findMaxRight(int[] maxright, int[] heightcopy) {

        int c = Integer.MIN_VALUE;
        for (int i = 0; i + 1 < heightcopy.length; i++) {
            if (heightcopy[i] > c) {
                c = heightcopy[i];
            }
        }
        for (int i = 0; i < heightcopy.length; i++) {
            if (heightcopy[i] == c) {
                maxright[i] = i;
                heightcopy = Arrays.copyOfRange(heightcopy, i, heightcopy.length);
                break;
            }
        }
        if (heightcopy.length > 0)
            return findMaxRight(maxright, heightcopy);
        else {
            return maxright;
        }

    }

    public static int calculateVolume(int[] maxleft, int[] maxright, int[] height) {
        int volumn = 0;
        for (int i = 0; i < maxleft.length; i++) {
            if (maxleft[i] != 0) {
                for (int j = i; j < maxleft.length; i++) {
                    if (maxleft[j] != 0) {
                        for (int k = i + 1; k < j; k++) {
                            volumn = volumn + Math.min(height[i], height[j]) - height[k];
                        }

                    }
                }
            }
        }
        return volumn;
    }
}
