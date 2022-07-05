public class Number {

    private int whole;
    private int numerator;
    private int denominator;

    public Number(int whole, int numerator, int denominator) {
        this.whole = whole;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Number(Fraction fraction) {
        this(fraction.getA() / fraction.getB(), fraction.getA() % fraction.getB(), fraction.getB());
    }

    @Override
    public String toString() {
        return whole + " " + numerator + "/" + denominator;
    }

    public Fraction toFraction() {
        return new Fraction(whole * denominator + numerator, denominator);
    }

    
}
