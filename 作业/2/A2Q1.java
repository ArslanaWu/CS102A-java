public class A2Q1 {
    public static void main(String[] args) {
        int y = Integer.parseInt(args[0]);
        String stem = "";
        String branch = "";
        String symbol = "";

        switch(y%10){
            case 4:
                stem = "jia";
                break;
            case 5:
                stem = "yi";
                break;
            case 6:
                stem = "bing";
                break;
            case 7:
                stem = "ding";
                break;
            case 8:
                stem = "wu";
                break;
            case 9:
                stem = "ji";
                break;
            case 0:
                stem = "geng";
                break;
            case 1:
                stem = "xin";
                break;
            case 2:
                stem = "ren";
                break;
            case 3:
                stem = "gui";
                break;
        }
        switch(y%12){
            case 4:
                branch = "zi";
                symbol = "Rat";
                break;
            case 5:
                branch = "chou";
                symbol = "Ox";
                break;
            case 6:
                branch = "yin";
                symbol = "Tiger";
                break;
            case 7:
                branch = "mao";
                symbol = "Rabbit";
                break;
            case 8:
                branch = "chen";
                symbol = "Dragon";
                break;
            case 9:
                branch = "si";
                symbol = "Snake";
                break;
            case 10:
                branch = "wu";
                symbol = "Horse";
                break;
            case 11:
                branch = "wei";
                symbol = "Sheep";
                break;
            case 0:
                branch = "shen";
                symbol = "Monkey";
                break;
            case 1:
                branch = "you";
                symbol = "Rooster";
                break;
            case 2:
                branch = "xu";
                symbol = "Dog";
                break;
            case 3:
                branch = "hai";
                symbol = "Pig";
                break;
        }
        System.out.printf("%d is the year of %s-%s. Also %s year.\n",y,stem,branch,symbol);




    }
}
