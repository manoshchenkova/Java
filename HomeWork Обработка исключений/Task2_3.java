import java.io.FileNotFoundException;

/*Дан следующий код, исправьте его там, где требуется (задание 3):
 * 1. Убрали NullPointerException
 * 2. Поменяли местами IndexoutOfBound exception (подвинули выше)
 * 3. Убрали FileNotFoundException
 */

public class Task2_3 {
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        } 
     }
     public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
     }
     
}
