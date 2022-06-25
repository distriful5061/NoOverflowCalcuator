import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> Numbers = new ArrayList<>();
    private static final int TEN = 10;

    public static void main(String[] args) {
        Numbers.add(2);
        print(Numbers.get(0)+"\n");
        add(12);
        for(int num : Numbers){
            print(num + " ");
        }
        print("\n");
    }

    private static void print(String content){
        System.out.print(content);
    }

    private static void print(int content){
        System.out.print(content);
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
        if(Numbers.isEmpty()){
            Numbers.add(0);
        }
        int ZeroNum = Numbers.get(0);
        ZeroNum += num;
        Numbers.set(0,ZeroNum);
        check();
    }
}