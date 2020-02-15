import java.util.Scanner;
public class A1Q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a ;
        int b ;

        System.out.print("Enter the first number: ");
        a = input.nextInt();
        System.out.print("Enter the second number: ");
        b = input.nextInt();


        while (a + b != 100) {
            System.out.printf("Sum of two numbers is %d\n", a + b);
            System.out.println("Sum does not equal 100, loop repeats");

            System.out.print("Enter the first number: ");
            a = input.nextInt();
            System.out.print("Enter the second number: ");
            b = input.nextInt();

        } if(a + b == 100){
            System.out.printf("Sum of two numbers is %d\n", a + b);
            System.out.println("Sum equals 100, loop terminates");
        }

    }
}

