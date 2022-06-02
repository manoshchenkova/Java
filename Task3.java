//Написать программу вычисления n-ого треугольного числа.

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите n для треугольного числа: ");
        int n = iScanner.nextInt();

        int triangle = triangleNumber(n);
        System.out.println(triangle);

    }

    static int triangleNumber(int numberN) {

        if (numberN == 1) {
            return 1;
        }
        return triangleNumber(numberN - 1) + numberN;
    }

}