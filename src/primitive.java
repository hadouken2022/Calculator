//import zaur2.Operations;
////import zaur2.ReadAnyText;

import java.util.InputMismatchException;
import java.util.Scanner;

public class primitive {
    public static void main(String[] args) throws Exception {
        while (true) {
            ReadAnyText readAnyText1 = new ReadAnyText();
            //Operations operations1 = new Operations();

            //Scanner sc = new Scanner(System.in);
            int[] arabic = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 40, 50, 90, 100};
            String[] rimskie = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XL", "L", "XC", "C"};
            System.out.println("Введите число от 1 до 10");
            String op = "";
            int arabInt = 0;
            int arab2Int = 0;
            String arab = "";
            String arab2 = "";
            String stroka = "";
            int result = 0;
            try {
                stroka = readAnyText1.read();
                String[] array = stroka.split(" ");
                if (array.length < 3 | array.length > 3) {
                    throw new Exception("строка не является математической операцией или количество операторов не удовлетворяет заданию");
                }
                arab = array[0];
                op = array[1];
                arab2 = array[2];

                arabInt = Integer.parseInt(arab);
                try {
                    arab2Int = Integer.parseInt(arab2);
                } catch (Exception e) {
                    throw new Exception("используются одновременно разные системы счисления");
                }
                if (arabInt > 10 | arab2Int > 10) {
                    throw new Exception("введено неподходящее число");
                }
                //operations1.count(arabInt, arab2Int, op);
                if (arabInt >= 1 && arabInt <= 10 && arab2Int >= 1 && arab2Int <= 10) {
                    switch (op) {
                        case ("+"):
                            System.out.println(arabInt + arab2Int);
                            break;
                        case ("-"):
                            System.out.println(arabInt - arab2Int);
                            break;
                        case ("*"):
                            System.out.println(arabInt * arab2Int);
                            break;
                        case ("/"):
                            System.out.println(arabInt / arab2Int);
                            break;
                        default:
                            throw new Exception("отличный от задания операнд (+, -, /, *)");
                    }
                }
            } catch (NumberFormatException nmfe) {
                nmfe.printStackTrace();
                for (int i = 0; i < rimskie.length; i++) {
                    if (arab.compareTo(rimskie[i]) == 0) {
                        arabInt = arabic[i];
                    }
                    if (arab2.compareTo(rimskie[i]) == 0) {
                        arab2Int = arabic[i];
                    }
                }
//                if (arabInt > 10 | arab2Int > 10) {               //НУЖНО КИНУТЬ ИСКЛЮЧЕНИЕ ПРИ ВВОДЕ НЕ ПОДХОДЯЩИХ РИМСКИХ ( БОЛЬШЕ Х)
//                    throw new Exception("введено неподходящее число");}
                if (arab2Int == 0) {
                    throw new Exception("используются одновременно разные системы счисления");
                }
                switch (op) {
                    case ("+"):
                        result = arabInt + arab2Int;
                        break;
                    case ("-"):
                        result = arabInt - arab2Int;
                        break;
                    case ("*"):
                        result = arabInt * arab2Int;
                        break;
                    case ("/"):
                        result = arabInt / arab2Int;
                        break;
                }
                if (result < 1) {
                    throw new Exception("в римской системе нет отрицательных чисел");
                }
                String rome = "";
                for (int i = arabic.length - 1; i >= 0; i--) {
                    if (result >= arabic[i]) {
                        result = result - arabic[i];
                        rome = rome + rimskie[i];
                        i = i + 1;
                    }
                }
                System.out.println(rome);
            }
        }
    }
}