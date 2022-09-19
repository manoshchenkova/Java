import java.util.Scanner;

/*Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
Пользователю должно показаться сообщение, что пустые строки вводить нельзя */

public class Task2_4 {
    public static void main(String[] args) {
        try {
            requestText();
        } catch (EmptyTextException e) {
           System.out.println(e.getMessage());
        }
    }

    public static void requestText() throws EmptyTextException {
        try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("Please enter something:");

        String userText = scanner.nextLine();
        if (userText.isEmpty()) {
            throw new EmptyTextException();
            }
        }
    
    }

    private static class EmptyTextException extends Exception {
        public EmptyTextException() {
            super("The text should not be empty");
        }
    }

}