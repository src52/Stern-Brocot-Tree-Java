import java.math.BigInteger;

/**
 * A TreeNode represents a node the binary tree.
 *
 * For the purpose of this assignment, the only values that are needed to calculate
 * the answer is the node's current value, and it's lower & upper bounds. Since a node's
 * value is determined by the sum of it's lower and upper bounds, changing the bounds of
 * the TreeNode makes it go either left or right down the tree.
 */

public class TreeNode {
    private Fraction nodeValue;
    private Fraction upperBoundFraction;
    private Fraction lowerBoundFraction;

    public TreeNode() {
        nodeValue = new Fraction(BigInteger.ONE, BigInteger.ONE);
        lowerBoundFraction = new Fraction(BigInteger.ZERO, BigInteger.ONE);
        upperBoundFraction = new Fraction(BigInteger.ONE, BigInteger.ZERO);
    }

    public Fraction calculateNodeValue() {
        BigInteger numerator = lowerBoundFraction.getNumerator()
                .add(upperBoundFraction.getNumerator());

        BigInteger denominator = lowerBoundFraction.getDenominator()
                .add(upperBoundFraction.getDenominator());

        return new Fraction(numerator, denominator);
    }

    public Fraction getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(Fraction nodeValue) {
        this.nodeValue = nodeValue;
    }

    public void setUpperBoundFraction(Fraction upperBoundFraction) {
        this.upperBoundFraction = upperBoundFraction;
    }

    public void setLowerBoundFraction(Fraction lowerBoundFraction) {
        this.lowerBoundFraction = lowerBoundFraction;
    }
}