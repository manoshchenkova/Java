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

    static int triangleNumber(int n) {

        if (n == 1) {
            System.out.println("*");
            return 1;
        }
        int result = n + triangleNumber(n - 1);
        String s = "";
        for (int i = 0; i < result; i++) {
            s = s + "*";
        }
        System.out.println(s);
        return result;
    }

}