
import java.util.Scanner;

//Написать программу, показывающую последовательность действий для игры “Ханойская башня”

// У нас 3 массива:
// Изначальный (n элементов)
// Конечный
// Промежуточный
// Рекурсия

// Обозначим через «1-2» такое действие: переложить диск или с 1-го штыря 
//на 2-й, или со 2-го на 1-й, в зависимости от того, где он меньше. 
//Тогда, чтобы решить головоломку с чётным количеством дисков, 
//надо многократно повторять действия: 1-2, 1-3, 2-3. 
//Если число дисков нечётно — 1-3, 1-2, 2-3.

public class Task4 {
    public static void main(String[] args) {
        int disks = readNumberOfDisks();

        SortKhanoi('a', 'b', 'c', disks);
    }

    private static int readNumberOfDisks() {
        try (Scanner iScanner = new Scanner(System.in)) {
            while (true) {
                System.out.printf("Please enter number of disks: ");
                String line = iScanner.nextLine();
                try {
                    int disks = Integer.parseInt(line);
                    if (disks <= 0) {
                        System.out.printf("Number of disks should be a positive number\n");
                    } else {
                        return disks;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Number of disks should be an integer");
                }
            }
        }
    }

    public static void printMove(char spire1, char spire2) {
        System.out.println(spire1 + "-->" + spire2);
    }

    static void SortKhanoi(char spire1, char spire2, char spire3, int disksNumber) {
        if (disksNumber == 1) {
            printMove(spire1, spire2);
        } else {
            SortKhanoi(spire1, spire3, spire2, disksNumber - 1);
            printMove(spire1, spire2);
            SortKhanoi(spire3, spire2, spire1, disksNumber - 1);
        }
    }
}
