import java.util.ArrayList;
import java.util.List;

class Studio{
    protected static void print(String content){
        System.out.print(content);
    }

    protected static void print(int content){
        System.out.print(content);
    }

    protected static boolean MinusCheck(int num){
        return Math.abs(num) != num;
    }
}

public class Main extends Studio{
    public static List<Integer> Numbers = new ArrayList<>();
    public static boolean isMinus = false;
    private static final int TEN = 10;
    private static final String N = "\n";

    public static void main(String[] args) {
        FP();//Do not change it!

        //Main start here
        add(2);
        print(getNumber()+" "+getLength()+N);
        add(12);
        print(getNumber()+" "+getLength());
        print(N);
        minus(10);
        print(getNumber()+" "+getLength()+N);
    }

    private static String getNumber(){
        StringBuilder string = new StringBuilder();
        for(int i : Numbers){
            string.append(i);
        }

        if(isMinus){
            string.append("-");
        }

        return string.reverse().toString();
    }

    private static int getLength(){
        int result = 0;
        for(int ignored : Numbers){
            result++;
        }
        return result;
    }

    private static void check(){

        int length = getLength();
        for(int i=0;i<length;i++){
            int num1 = Numbers.get(i);
            if(num1 > 9){
                String[] num2 = String.valueOf(num1 / TEN).split("\\.");

                int nextIndex = length + 1;

                if(nextIndex >= length){
                    Numbers.add(Integer.valueOf(num2[0]));
                }
                Numbers.set(i, num1 % TEN);
            }
        }
    }

    private static void add(int num){
        if(MinusCheck(num)){
            minus(Math.abs(num));
            return;
        }

        if(Numbers.isEmpty()){
            Numbers.add(0);
        }
        int ZeroNum = Numbers.get(0);
        ZeroNum += num;
        Numbers.set(0,ZeroNum);
        check();
    }

    private static void minus(int num){
        if(MinusCheck(num)){
            add(Math.abs(num));
            return;
        }

        if(Numbers.isEmpty()){
            Numbers.add(0);
        }

        int ZeroNum = Numbers.get(0);
        ZeroNum -= num;
        Numbers.set(0,ZeroNum);
        check();
    }

    private static void FP(){
        Numbers.add(0);
    }
}