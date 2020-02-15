import java.util.Scanner;
import java.util.InputMismatchException;

public class HandleIncorrectInput2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                System.out.print("Please enter an integer: ");
                int x = sc.nextInt();
                System.out.printf("You entered: %d\n", x);
                break;
            }catch(InputMismatchException ex) {
                System.out.println("What jb did you input?");
                sc.nextLine(); // Clear input buffer
            }
        }
    }
}

