import java.util.InputMismatchException;
import java.util.Scanner;

/*Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению 
приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных. */

public class Task2_1 {
    public static void main(String[] args) {
       enterFloatNumber();
        
}

public static void enterFloatNumber() {
    while (true) {
        System.out.println("Please enter a number with decimals: ");
        try {
                Scanner scanner = new Scanner(System.in);
                scanner.nextFloat();     
                return;       
            }
            catch (InputMismatchException e) {
                System.out.println("The entered number should contain decimals");
            }
        }
    }
}