public class Fraction {

    private final int a;
    private final int b;

    public Fraction(int a, int b) {
        if (b < 0) {
            a = -a;
            b = -b;
        }
        final var gcd = gcd(a, b);
        this.a = a / gcd;
        this.b = b / gcd;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public Fraction add(Fraction fraction) {
        return new Fraction(this.a * fraction.b + fraction.a * this.b, this.b * fraction.b);
    }

    public Fraction subtract(Fraction fraction) {
        return add(fraction.negate());
    }

    public Fraction multiply(Fraction fraction) {
        return new Fraction(this.a * fraction.a, this.b * fraction.b);
    }

    public Fraction divide(Fraction fraction) {
        return multiply(fraction.swap());
    }

    private Fraction negate() {
        return new Fraction(-this.a, this.b);
    }

    private Fraction swap() {
        return new Fraction(this.b, this.a);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    
}
