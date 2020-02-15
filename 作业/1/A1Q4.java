public class A1Q4 {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        int b = 0;

        for (int a = 1;a <= n;a = a + 1) {
            b = b + a;
        }
        System.out.println(b);
    }
}
