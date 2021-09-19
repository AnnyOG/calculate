import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String scanString = sc.next();
        System.out.println(scanString);
        try {
            if (isValidString(scanString)) throw new Exception();

            System.out.println("Резельтат вычисления: " + Calculate(scanString));
        }
        catch (Exception e) {
            System.out.println("Введено некорректное значение");
        }
    }
    public static int Calculate(String str) {
        String operators[]=str.split("[0-9]+");
        String operands[]=str.split("[+-/*]");
        int result = Integer.parseInt(operands[0]);
        for(int i=1;i<operands.length;i++){
            if(operators[i].equals("+"))
                result += Integer.parseInt(operands[i]);
            if(operators[i].equals("-"))
                result -= Integer.parseInt(operands[i]);
            if(operators[i].equals("*"))
                result *= Integer.parseInt(operands[i]);
            if(operators[i].equals("/"))
                result /= Integer.parseInt(operands[i]);
        }
        return result;
    }

    public static boolean isValidString(String str) {
        Pattern pattern = Pattern.compile("(^[+-/*]|[a-zA-Zа-яА-Я]+|[+-/*]{2,}|[+-/*]$)");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}
