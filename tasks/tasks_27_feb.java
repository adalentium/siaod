import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class tasks_27_feb {
    public static void main(String[] args){
        System.out.println(captcha(4));
        System.out.println(polygons(9));
        String[] test = {"Add x", "Add y", "Vote y", "Vote x"};
        System.out.println(checker(test));
    }

    public static ArrayList<Integer> captcha(int n){
        int n1 = n;

        String s = Integer.toString(n);
        int sum = 0;
        List<Integer> sub = new ArrayList<Integer>();
        while(n != 0) {
            //Суммирование цифр числа
            sum += (n % 10);
            n /= 10;
        }
        if (s.length() == 1){
            if( (n1 == 4) || (n1 == 6) || (n1==8)) {
                sub.add(10);
                sub.add(2);
                return (ArrayList<Integer>) sub;
            }
            else if (n1 == 9){
                sub.add(10);
                sub.add(3);
                return (ArrayList<Integer>) sub;
            }
            else {
                sub.add(-1);
                return (ArrayList<Integer>) sub;
            }
        }
        else {
            if (sum == 1) {
                sub.add(10);
                sub.add(2);
                return (ArrayList<Integer>) sub;
            }
            sub.add(sum+1);
            sub.add(sum);
            return (ArrayList<Integer>) sub;
        }

    }

    public static int polygons(int number){
        for (int i = 3; i < Math.sqrt(number) + 1; i++ ){
            if(number % i == 0) {
                return i;
            }
        }
        if (number > 4 && number % 2 == 0){
            /*
            многоугольника из 2 вершин не существует,
            но второй множитель явно больше 2 (для N > 4), поэтому, если ничего из цикла не подошло,
             то это число нам подходит
             */
            return  number / 2;
        }
        return number;
    }

    public static String checker (String[] event){
        Stack<String> stack = new Stack<>();
        ArrayList<String> string = new ArrayList<String>();
        int k = 0;
        for (int i = 0; i < event.length; i++){
            for (String retval : event[i].split(" ")) {
                string.add(retval);
            }
            String first = string.get(k);
            k++;
            String second = string.get(k);
            k++;
            if (first.equals("Add")){
                stack.push(second);
            }
            else if (!stack.pop().equals(second)){
                return "No";
            }
        }
        if (stack.size() == 0){
            return "Yes";
        }
        else {
            return "No";
        }
    }
}
