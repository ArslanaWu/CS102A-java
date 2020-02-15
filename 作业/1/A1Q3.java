public class A1Q3 {
    public static void main(String[] args) {

        int lec = Integer.parseInt(args[0]);
        int lab = Integer.parseInt(args[1]);
        int ass = Integer.parseInt(args[2]);
        int pro = Integer.parseInt(args[3]);
        int exa = Integer.parseInt(args[4]);
        double a = 0.1 * lec + 0.1 * lab + 0.3 * ass + 0.2 * pro + 0.3 * exa;

        if (a >= 80) {
            System.out.printf("%.2f\n", a);
            System.out.print("A");
        } else if (a >= 50) {
            System.out.printf("%.2f\n", a);
            System.out.print("B");
        } else {
            System.out.printf("%.2f\n", a);
            System.out.print("C");
        }
    }
}
