import java.util.Scanner;
import java.util.InputMismatchException;

public class HandleIncorrectInput1 {
    
    public static void main(String[] args) {
        boolean shouldExit = false;

        while(!shouldExit) {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.print("Please enter an integer: ");
                int x = sc.nextInt();
                System.out.printf("You entered: %d\n", x);
                shouldExit = true;
            }catch(InputMismatchException ex) {
                System.out.println("What jb did you input?");
                sc.nextLine();
            }
        }
    }
}

