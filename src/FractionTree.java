import java.math.BigInteger;

/**
 * The FractionTree class represents a Stern-Brocot binary tree.
 *
 * A FractionTree takes two BigIntegers as input, a numerator and denominator,
 * and creates a Fraction object out of them. Then, it initializes a TreeNode
 * object with a value of (1/1), a lower bound of (0/1), and an upper bound of (1/0).
 *
 * It travels down the binary tree, searching for the square root of the user's input,
 * with a precision such that:
 *      |(N * a^2) - (M * b^2)| < b,
 * is satisfied. Where:
 *      N = inputDenominator,
 *      M = inputNumerator,
 *      a = the rootNode's current numerator,
 *      b = the rootNode's current denominator.
 */
public class FractionTree {
    private final Fraction inputFraction;
    private final TreeNode rootNode;

    public FractionTree(BigInteger inputNumerator, BigInteger inputDenominator) {
        rootNode = new TreeNode();
        inputFraction = new Fraction(inputNumerator, inputDenominator);
    }

    public Fraction calculateSqrt() {
        return fractionAction(rootNode);
    }

    /**
     * Recursively searches the TreeNode object for the square root of the inputted fraction.
     *
     * The .signum() method returns a value of 1 if the computed BigInteger is positive,
     * and -1 if it's negative. This output determines whether or not to descend left,
     * or right on the binary tree.
     *
     * Since the given equation [(Na^2 - Mb^2) = 0] represents the equality (a/b) = sqrt(M/N),
     * having a negative output means the node we're currently on is too small to be the sqrt.
     * (You'd have to add that value to both sides to make the equation equal to 0 again).
     * So it goes to the right to become larger.
     *
     * By going left, you change the upper bound, since the parent node is now to your left.
     * By going right, you change the lower bound, since the parent node is now to your right.
     *
     * @param rootNode The new root node of the binary tree.
     * @return the approximate square root of the specified Fraction, precision given above.
     */
    private Fraction fractionAction(TreeNode rootNode) {
        BigInteger numeratorA = rootNode.getNodeValue().getNumerator();
        BigInteger denominatorB = rootNode.getNodeValue().getDenominator();

        BigInteger computation = inputFraction.getDenominator().multiply(numeratorA.pow(2))
                .subtract(inputFraction.getNumerator().multiply(denominatorB.pow(2)));

        switch (computation.signum()) {
            //Left
            case 1:
                rootNode.setUpperBoundFraction(rootNode.getNodeValue());
                break;

            //Right
            case -1:
                rootNode.setLowerBoundFraction(rootNode.getNodeValue());
                break;
        }

        if((computation.abs()).compareTo(denominatorB) < 0) {
            return rootNode.getNodeValue();
        } else {
            rootNode.setNodeValue(rootNode.calculateNodeValue());
            return fractionAction(rootNode);
        }
    }
}