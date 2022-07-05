import java.util.Scanner;

public class UI {

    private Calculator calculator;
    private Scanner scanner;

    public UI(Calculator calculator) {
        this.calculator = calculator;
    }

    public void run() {

        this.scanner = new Scanner(System.in);
        try {
            Number firstNumber = readNumber();
    
            Operation operation = readOperation();
    
            Number secondNumber = readNumber();
    
            Number result = this.calculator.calc(firstNumber, operation, secondNumber);
    
            System.out.println(result);
        } finally {
            scanner.close();
        }

    }

    private Operation readOperation() {
        System.out.println("Input operation [+-*/]");
        // read string
        String text = readString();
        // convert to Operation
        switch (text) {
            case "+": return Operation.SUM;
            case "-": return Operation.SUBTRACT;
            case "*": return Operation.MULTIPLY;
            case "/": return Operation.DIVIDE;
        }
        throw new RuntimeException("Unknown operation");
    }

    private Number readNumber() {
        System.out.println("Input number in format whole numerator/denominator, ex 1 2/3");
        // read string
        String text = readString();

        // convert to Number
        String[] parts = text.split(" ");
        int whole = Integer.parseInt(parts[0]);
        String[] fractions = parts[1].split("/");
        int numerator = Integer.parseInt(fractions[0]);
        int denominator = Integer.parseInt(fractions[1]);

        return new Number(whole, numerator, denominator);
    }

    private String readString() {
        return scanner.nextLine();
    }
    
}
