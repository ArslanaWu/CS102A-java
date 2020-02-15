public class A2Q2 {
    public static void main(String[] args) {
        double[] num = new double[args.length];
        double ave = 0;
        double[] mod = new double[args.length];
        double med = 0;

        for (int i = 0; i < args.length; i++) {
            num[i] = Double.parseDouble(args[i]);
        }
        double a = 0;
        for (int i = 0; i < args.length; i++) {
            a = a + num[i];
        }
        ave = a / args.length;
        System.out.printf("average = %.2f\n", ave);


        int[] b = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            b[i] = 0;
        }

        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args.length; j++) {
                if(j>i){
                if (num[i] == num[j]) {
                    b[i]++;
                }
            }
        }}
        int c = Integer.MIN_VALUE;
        //int d = Integer.MIN_VALUE;
        for (int i = 0; i < args.length; i++) {
            if (b[i] >= c && b[i] != 0) {
                for(int j = 0;j < args.length;j++){
                    if(b[i] >= b[j]){
                        c = b[i];
                    }
                }

                mod[i] = num[i];
            }
        }
        System.out.printf("mode = ");
        for(int i = 0;i < mod.length;i++){
            if(mod[i] != 0){
            System.out.printf("%.2f ",mod[i]);
        }}


        double d = 0;
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args.length; j++) {
                if (j > i) {
                    if (num[i] > num[j]) {
                        d = num[j];
                        num[j] = num[i];
                        num[i] = d;
                    }
                }
            }
        }

        if (args.length % 2 == 0) {
            med = (num[args.length / 2] + num[args.length / 2 - 1])/2;
        } else {
            med = num[(args.length - 1) / 2];
        }


        System.out.printf("\nmedian = %.2f", med);

    }
}

