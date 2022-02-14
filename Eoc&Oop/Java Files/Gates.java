public class Gates { // !class
    /*
     * This is the SuperClass which then gets extended by other classes.
     * Made universal NAND gate using the Nand Logic and if|else condition.
     */
    public static int Nand(int a, int b) { // !method

        if (a * b == 1) {
            return 0;
        }

        else {
            return 1;
        }
    }

    /*
     * wkt And is a combo of 3 NAND gates
     */

    public static int And(int a, int b) { // !method

        return Nand(Nand(a, b), Nand(a, b));
    }

    /*
     * Not is just nand with same input
     */
    public static int Not(int a) { // !method

        return Nand(a, a);
    }

    /*
     * Or is 2 NAND with a and b for both inputs of NAND and NAND of the both
     * outputs
     */
    public static int Or(int a, int b) { // !method

        return Nand(Nand(a, a), Nand(b, b));
    }

    /*
     * For XOR we just need 5 NAND
     */
    public static int Xor(int a, int b) { // !method

        return Nand(Nand(a, Nand(a, b)), Nand(b, Nand(a, b)));
    }
}
