public class A2Q3_2 {
    public static void main(String args[]) {
        if(args.length % 2 == 1){
            System.out.printf("Please input the right format of score and credit hour in pair, eg. 95 2 88 3");
        }else if(args.length % 2 == 0){
            double[] gra = new double[args.length/2];
            int[] hou = new int[args.length/2];
            for(int i = 0; i < args.length;i++){
                if(i % 2 == 0){
                    gra[i/2] = Double.parseDouble(args[i]);
                }else{
                    hou[(i - 1)/2] = Integer.parseInt(args[i]);
                }
            }
            double[] graa = new double[args.length/2];
            for(int i = 0; i < args.length/2;i++){
                if(gra[i] <= 100 && gra[i] >= 97 ){
                    graa[i] = 4.00;
                }else if(gra[i] <= 96 && gra[i] >= 93 ){
                    graa[i] = 3.94;
                }else if(gra[i] <= 92 && gra[i] >= 90 ){
                    graa[i] = 3.85;
                }else if(gra[i] <= 89 && gra[i] >= 87 ){
                    graa[i] = 3.73;
                }else if(gra[i] <= 86 && gra[i] >= 83 ){
                    graa[i] = 3.55;
                }else if(gra[i] <= 82 && gra[i] >= 80 ){
                    graa[i] = 3.32;
                }else if(gra[i] <= 79 && gra[i] >= 77 ){
                    graa[i] = 3.09;
                }else if(gra[i] <= 76 && gra[i] >= 73 ){
                    graa[i] = 2.78;
                }else if(gra[i] <= 72 && gra[i] >= 70 ){
                    graa[i] = 2.42;
                }else if(gra[i] <= 69 && gra[i] >= 67 ){
                    graa[i] = 2.08;
                }else if(gra[i] <= 66 && gra[i] >= 63 ){
                    graa[i] = 1.63;
                }else if(gra[i] <= 62 && gra[i] >= 60 ){
                    graa[i] = 1.15;
                }else if(gra[i] < 60 ){
                    graa[i] = 0.00;
                }
            }
            double a = 0;
            double b = 0;
            for(int i = 0; i < args.length/2;i++){
                a = a + graa[i] * hou[i];
                b = b + hou[i];
            }
            System.out.printf("GPA = %.2f",a / b);
        }
    }
}
