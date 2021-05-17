import java.lang. *;

public class task2{
    public static void main(String[] args){
        //First task
        System.out.println("First task");
        System.out.println("Input: s1 = \"abc\", s2 = \"xya\"");
        System.out.print("Output: ");
        System.out.println(canWin("abc", "xya"));
        System.out.println("Input: s1 = \"abe\", s2 = \"acd\"");
        System.out.print("Output: ");
        System.out.println(canWin("abe", "acd"));
        System.out.println();

        //Second task
        System.out.println("Second task");
        System.out.println("Input: s = \"babad\"");
        System.out.print("Output: ");
        System.out.println(palindrome("babad"));
        System.out.println("Input: s = \"cbbd\"");
        System.out.print("Output: ");
        System.out.println(palindrome("cbbd"));
        System.out.println();

        //Third task
        System.out.println("Third task");
        System.out.println("Input: s = \"abcabcabc\"");
        System.out.print("Output: ");
        System.out.println(concatenations("abcabcabc"));
    }

    static boolean canWin(String line1, String line2){
        String s1 = "";
        String s2 = "";
        for(int i = 0; i < line1.length(); i++){
            s1 += line1.charAt(i);
            s2 += line2.charAt(i);
            for(int j = i; j < line1.length(); j++){
                if(line1.charAt(i) >= line1.charAt(j)){
                    s1 = s1.substring(0, s1.length() - 1);
                    s1 += line1.charAt(j);
                }
                if(line2.charAt(i) >= line2.charAt(j)){
                    s2 = s2.substring(0, s2.length() - 1);
                    s2 += line2.charAt(j);
                }
            }
        }
        boolean status = false;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) < s2.charAt(i)){
                status = true;
                break;
            }
        }
        if(status == false)
            return true;
        for(int i = 0; i < s1.length(); i++){
            if(s2.charAt(i) < s1.charAt(i)){
                return false;
            }
        }
        return true;
    }

    static String palindrome(String line){
        int l = 0;
        String s;
        String result = "";

        for(int i = 0; i < line.length(); i++){
            s = "";
            for(int j = i; j < line.length(); j++){
                s += line.charAt(j);
                if(isPalindrome(s)){
                    if(l < s.length()){
                        result = s;
                        l = s.length();
                    }
                }
            }
        }

        return result;
    }
    static boolean isPalindrome(String line){
        String reverse = "";
        for(int i = 0; i < line.length(); i++){
            reverse += line.charAt(line.length() - i - 1);
        }
        return reverse.equals(line);
    }

    static int concatenations(String line){
        String conc = "";
        String[] arr;
        for(int i = 0; i < line.length(); i++){
            for(int j = i; j < line.length(); j++){
                if(isConc(line.substring(i, j + 1))){
                    conc += (line.substring(i, (i + j + 1) / 2)) + " ";
                }
            }
        }
        conc = conc.substring(0, conc.length());
        arr = conc.split(" ");
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i].equals(arr[j])){
                    arr[j] = "";
                }
            }
        }
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            if(!arr[i].equals(""))
                count++;
        }

        return count;

    }
    static boolean isConc(String line){
        //проверяем, если длина строки чётна, иначе это не может быть конкатенацией
        if(line.length() % 2 == 0){
            String l1 = line.substring(0, line.length() / 2);
            String l2 = line.substring(line.length() / 2);
            if(l1.equals(l2))
                return true;
            return false;
        }
        return false;

    }
}