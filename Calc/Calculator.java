public class Calculator {

    public Number calc(Number firstNumber, Operation operation, Number secondNumber) {
        
        Fraction firstOperand = firstNumber.toFraction();
        Fraction secondOperand = secondNumber.toFraction();

        Fraction result = calc(firstOperand, operation, secondOperand);

        return new Number(result);
    }

    private Fraction calc(Fraction firstNumber, Operation operation, Fraction secondNumber) {
        switch (operation) {
            case SUM: return firstNumber.add(secondNumber);
            case DIVIDE: return firstNumber.divide(secondNumber);
            case MULTIPLY: return firstNumber.multiply(secondNumber);
            case SUBTRACT: return firstNumber.subtract(secondNumber);
            default:
                throw new RuntimeException("Unknown operation " + operation);
        }
    }
    
    
}
