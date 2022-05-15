package Kata;

import java.util.Scanner;

public class Main {
    public static String calc(String stroka) throws Exception {
        Operations operations1 = new Operations();
        int[] arabic = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 40, 50, 90, 100};
        String[] rimskie = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XL", "L", "XC", "C"};
        String op = "";
        int arabInt = 0;
        int arab2Int = 0;
        String arab = "";
        String arab2 = "";
        String rome = "";
        try {
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

            operations1.count(arabInt, arab2Int, op);
            System.out.println(operations1.arabResult);
            return String.valueOf(Operations.arabResult);


        } catch (NumberFormatException nmfe) {
            for (int i = 0; i < rimskie.length - 4; i++) { //Перевод из арабских в римские через сопоставление массивов
                if (arab.compareTo(rimskie[i]) == 0) {
                    arabInt = arabic[i];
                }
                if (arab2.compareTo(rimskie[i]) == 0) {
                    arab2Int = arabic[i];
                }
            }
            if (arab2Int == 0 | arabInt == 0) {
                throw new Exception("используются одновременно разные системы счисления или введено неподходящее число");
            }
            operations1.countRim(arabInt, arab2Int, op);
            for (int i = arabic.length - 1; i >= 0; i--) { //Обратный перевод из римских в арабские
                if (Operations.result >= arabic[i]) {
                    Operations.result = Operations.result - arabic[i];
                    rome = rome + rimskie[i];
                    i = i + 1;
                }
            }
            System.out.println(rome);
        }
        return rome;
    }

    public static void main(String[] args) throws Exception {
        ReadAnyText readAnyText1 = new ReadAnyText();
        String stroka = readAnyText1.read();
        Main.calc(stroka);
    }
}

class ReadAnyText {
    private final Scanner sc = new Scanner(System.in);

    public String read() {
        System.out.println("Введите число от 1 до 10");
        return sc.nextLine();
    }
}

class Operations {
    public static int result = 0;
    public static int arabResult = 0;

    public void count(int chislo1, int chislo2, String znak) throws Exception {
        if (chislo1 >= 1 && chislo1 <= 10 && chislo2 >= 1 && chislo2 <= 10) {
            switch (znak) {
                case ("+"):
                    arabResult = (chislo1 + chislo2);
                    break;
                case ("-"):
                    arabResult = (chislo1 - chislo2);
                    break;
                case ("*"):
                    arabResult = (chislo1 * chislo2);
                    break;
                case ("/"):
                    arabResult = (chislo1 / chislo2);
                    break;
                default:
                    throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }
    }

    public void countRim(int rimChislo1, int rimChislo2, String RimZnak) throws Exception {

        switch (RimZnak) {
            case ("+"):
                result = rimChislo1 + rimChislo2;
                break;
            case ("-"):
                result = rimChislo1 - rimChislo2;
                break;
            case ("*"):
                result = rimChislo1 * rimChislo2;
                break;
            case ("/"):
                result = rimChislo1 / rimChislo2;
                break;
        }
        if (result < 1) {
            throw new Exception("в римской системе нет отрицательных чисел");
        }
    }
}







