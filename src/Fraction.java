import java.math.BigInteger;

/**
 * The Fraction class is composed of a numerator, and a denominator of any size.
 */
public class Fraction {
    private final BigInteger numerator;
    private final BigInteger denominator;

    public Fraction(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "\n" + denominator;
    }
}
