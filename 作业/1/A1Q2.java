public class A1Q2 {
    public static void main(String[] args) {

        float cny = Float.parseFloat(args[0]);

        if (cny > 50) {
            double hkd = (cny - 50) * 1.17;
            System.out.printf("%.2f", hkd);
        }else
            System.out.println("0.00");
    }
}
