public class A2Q4 {
    public static void main(String[] args) {
        String content = args[0];

        int leftp = content.lastIndexOf('(');
        if(leftp != -1) {
            int rightp = content.indexOf(')', leftp);
            String contentp = content.substring(leftp + 1, rightp);

            int fuhaojia = contentp.indexOf('+');
            int fuhaojian = contentp.indexOf('-');
            int fuhaocheng = contentp.indexOf('*');
            int fuhaochu = contentp.indexOf('/');
            double valueContentp = 0;

            if (fuhaojia != -1) {
                valueContentp = Double.valueOf(contentp.substring(0, fuhaojia)) + Double.valueOf(contentp.substring(fuhaojia + 1));
            } else if (fuhaojian != -1) {
                valueContentp = Double.valueOf(contentp.substring(0, fuhaojian)) - Double.valueOf(contentp.substring(fuhaojian + 1));
            } else if (fuhaocheng != -1) {
                valueContentp = Double.valueOf(contentp.substring(0, fuhaocheng)) * Double.valueOf(contentp.substring(fuhaocheng + 1));
            } else if (fuhaochu != -1) {
                valueContentp = Double.valueOf(contentp.substring(0, fuhaochu)) / Double.valueOf(contentp.substring(fuhaochu + 1));
            }
            double valueContent1 = 0;
            if(valueContentp >= 0){
                content = content.substring(0,leftp) + valueContentp + content.substring(rightp+1);
                int fuhaojia1 = content.indexOf('+');
                int fuhaojian1 = content.indexOf('-');
                int fuhaocheng1 = content.indexOf('*');
                int fuhaochu1 = content.indexOf('/');
                if (fuhaojia1 != -1) {
                    valueContent1 = Double.valueOf(content.substring(0, fuhaojia1)) + Double.valueOf(content.substring(fuhaojia1 + 1));
                } else if (fuhaojian1 != -1) {
                    valueContent1 = Double.valueOf(content.substring(0, fuhaojian1)) - Double.valueOf(content.substring(fuhaojian1 + 1));
                } else if (fuhaocheng1 != -1) {
                    valueContent1 = Double.valueOf(content.substring(0, fuhaocheng1)) * Double.valueOf(content.substring(fuhaocheng1 + 1));
                } else if (fuhaochu1 != -1) {
                    valueContent1 = Double.valueOf(content.substring(0, fuhaochu1)) / Double.valueOf(content.substring(fuhaochu1 + 1));
                }
            }else{
                content = content.substring(0,leftp) + Math.abs(valueContentp) + content.substring(rightp+1);
                int fuhaojia1 = content.indexOf('+');
                int fuhaojian1 = content.indexOf('-');
                int fuhaocheng1 = content.indexOf('*');
                int fuhaochu1 = content.indexOf('/');
                if (fuhaojia1 != -1) {
                    valueContent1 = Double.valueOf(content.substring(0, fuhaojia1)) - Double.valueOf(content.substring(fuhaojia1 + 1));
                } else if (fuhaojian1 != -1) {
                    valueContent1 = Double.valueOf(content.substring(0, fuhaojian1)) + Double.valueOf(content.substring(fuhaojian1 + 1));
                } else if (fuhaocheng1 != -1) {
                    valueContent1 = -Double.valueOf(content.substring(0, fuhaocheng1)) * Double.valueOf(content.substring(fuhaocheng1 + 1));
                } else if (fuhaochu1 != -1) {
                    valueContent1 = -Double.valueOf(content.substring(0, fuhaochu1)) / Double.valueOf(content.substring(fuhaochu1 + 1));
                }
            }
            System.out.print(args[0]);
            System.out.printf("=%.2f",valueContent1);


        }else{
            String con =content.replace("+","-");
            String[] num = con.split("-");
            char[] sym = new char[content.length()];
            double valuecontent = 0;
            for(int i = 0;i < num.length;i++){
                if(num[i].contains("*")){
                    int cheng = num[i].indexOf('*');
                    num[i] = String.valueOf(Double.valueOf(num[i].substring(0,cheng)) * Double.valueOf(num[i].substring(cheng+1,num[i].length())));
                }else if(num[i].contains("/")){
                    if(num[i].contains("/")){
                        int chu = num[i].indexOf('/');
                        num[i] = String.valueOf(Double.valueOf(num[i].substring(0,chu)) / Double.valueOf(num[i].substring(chu+1)));
                }
            }}
            if(num.length == 2){
                if(content.contains("+")){
                    valuecontent = Double.valueOf(num[0]) + Double.valueOf(num[1]);
                }else if(content.contains("-")){
                    valuecontent = Double.valueOf(num[0]) - Double.valueOf(num[1]);
                }
            }else{
                for(int i = 0;i < content.length();i++){
                    if(content.charAt(i)=='+'){
                        sym[i]='+';
                    }else if(content.charAt(i)=='-'){
                        sym[i]='-';
                    }
            }
            }
            for(int i = 0;i<sym.length;i++){
            if(sym[i]=='+'){
                for(int j = 0;j<sym.length;j++){
                if(sym[j]=='+' ){
                    valuecontent = Double.valueOf(num[0]) + Double.valueOf(num[1]) + Double.valueOf(num[2]);
                }else if(sym[j]=='-'&& j>i){
                    valuecontent = Double.valueOf(num[0]) + Double.valueOf(num[1]) - Double.valueOf(num[2]);
                }
            }}else if(sym[i]=='-'){
                for(int j = 0;j<sym.length;j++){
                if(sym[j]=='+' && j>i){
                    valuecontent = Double.valueOf(num[0]) - Double.valueOf(num[1]) + Double.valueOf(num[2]);
                }else if(sym[1]=='-'){
                    valuecontent = Double.valueOf(num[0]) - Double.valueOf(num[1]) - Double.valueOf(num[2]);
                }
            }}}

            System.out.print(args[0]);
            System.out.printf("=%.2f",valuecontent);
        }
    }


}
