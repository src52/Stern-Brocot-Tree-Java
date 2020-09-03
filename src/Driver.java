import java.math.BigInteger;

public class Driver {
    /**
     * CECS 328-01 -- Data Structures and Algorithms
     * Darin Goldstein
     * @author Spencer Carlson
     *
     * Runs the program. First, it checks the parameters to see if it matches the pattern: ###.../###...
     *
     * There can be any amount of numbers of either side of the slash, but there can't be any spaces,
     * or any additional slashes/characters, or any additional parameters.
     *
     * Then, it prints out a on one line, b on the next line, and quits.
     *
     * @param args The fraction input.
     */
    public static void main(String[] args) {
        if(args.length != 1 || !args[0].matches("^[0-9]+/[0-9]+$")) {
            System.out.println("Error parsing input! Please enter a fraction.\n" +
                    "Examples (don't use quotations}: \"492346346436334/2343643643643482\", \"125/5\", \"1203154/9983823\".");
            return;
        }

        String[] fractionArgs = args[0].split("/");

        BigInteger m = new BigInteger(fractionArgs[0]);
        BigInteger n = new BigInteger(fractionArgs[1]);
        FractionTree fractionTree = new FractionTree(m, n);

        Fraction result = fractionTree.calculateSqrt();
        System.out.println(result);
    }
}
