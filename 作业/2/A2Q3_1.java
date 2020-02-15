public class A2Q3_1 {
    public static void main(String args[]) {
        String s = args[0];
        if(s.equals("A+")){
            System.out.println("4.00");
        }else if(s.equals("A")){
            System.out.println(3.94);
        }else if(s.equals("A-")){
            System.out.println(3.85);
        }else if(s.equals("B+")){
            System.out.println(3.73);
        }else if(s.equals("B")){
            System.out.println(3.55);
        }else if(s.equals("B-")){
            System.out.println(3.32);
        }else if(s.equals("C+")){
            System.out.println(3.09);
        }else if(s.equals("C")){
            System.out.println(2.78);
        }else if(s.equals("C-")){
            System.out.println(2.42);
        }else if(s.equals("D+")){
            System.out.println(2.08);
        }else if(s.equals("D")){
            System.out.println(1.63);
        }else if(s.equals("D-")){
            System.out.println(1.15);
        }else if(s.equals("F")){
            System.out.println("0.00");
        }
    }
}
