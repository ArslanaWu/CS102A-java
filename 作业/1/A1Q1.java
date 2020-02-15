
public class A1Q1 {
    public static void main(String[] args) {

        double pi = 3.14;
        float radius = Float.parseFloat(args[0]);
        double a = 2 * pi * radius;
        double b = pi * Math.pow((radius),2);

        System.out.printf("%.2f\n%.2f",a,b);

    }
}
