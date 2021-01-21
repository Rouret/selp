package test;

import java.io.FileInputStream;
import java.util.OptionalInt;

import static calc.Calc.interpret;

public class Test {
    private static int count = 0;
    private static int success = 0;
    static Boolean verbose;

    public static void main(String[] args) {
        verbose = args.length > 0 && args[0].equals("-v");
    }

    static void report() {
        System.out.println(success + " successful tests out of " + count);
    }

    // Boolean verbose: in verbose mode, additional debugging information is printed
    // String mess1: gives some idea of what the test is about
    // OptionalInt expected: the expected result,
    //   as an optional integer, empty if the program is supposed to be incorrect
    static void test(Boolean verbose, String filename, String mess1, OptionalInt expected) {
        count++;
        String[] args0 = new String[1];
        args0[0] = filename;
        if (verbose)
            System.out.println("====: " + filename + "\ncontent: " + mess1 + "\nexpected: " + expected);
        try {
            int found = interpret(new FileInputStream(filename));
            if (expected.isEmpty()) { // error expected
                System.err.println("FAILURE on " + filename);
                System.err.println("error expected, found " + found);
            } else {
                int result = expected.getAsInt();
                if (verbose) System.out.println("result: " + found);
                if (found != result) {
                    System.err.println("FAILURE on " + filename);
                    System.err.println("expecting " + result + " found " + found);
                } else {
                    success++;
                    System.out.println ("SUCCESS on " + filename);
                }
            }
        } catch (Exception e) {
            if (expected.isEmpty()) {
                if (e instanceof java.lang.NullPointerException) {
                    System.err.println("FAILURE on " + filename); // for debugging purposes
                } else {
                    success++;
                    System.out.println("SUCCESS on " + filename + " with error : " + e.getMessage());
                    // but is it indeed a meaningful error?
                }
            } else { // unexpected error
                System.err.println("FAILURE on " + filename);
            }
            if (verbose) e.printStackTrace();
        }
    }
}

