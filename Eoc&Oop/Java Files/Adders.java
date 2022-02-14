public class Adders extends Muxes { // ?extends muxes and itself is a child class
    /*
     * Sum and Carry are in different methods to make use of both when needed
     * Same fot CLA
     */
    public static int HASum(int a, int b) { // HASum = HalfAdderSum

        return Xor(a, b);
    }

    public static int HACarry(int a, int b) { // HACaryy = HalfAdderCarry

        return And(a, b);
    }

    public static int FASum(int a, int b, int c) { // FASum = FullAdderSum

        return Xor(Xor(a, b), c);
    }

    public static int FACarry(int a, int b, int c) { // FACarry = FullAdderCarry

        return Or(Or(And(a, b), And(b, c)), And(a, c));
    }

    public static int CLAAdderSum(int a, int b, int c) { // CLAAdderSum = Carry Look Ahead Sum

        int ab = Xor(a, b);

        return Xor(ab, c);
    }

    public static int CLAAdderCarry(int a, int b, int c) { // CLAAdderCarry = Carry Look Ahead Carry

        int ab = Xor(a, b);
        int Aca = And(ab, c);
        int Aab = And(a, b);

        return Or(Aca, Aab);
    }

    public static int[] Add16(int a[], int b[]) {

        int carry;
        int[] sout = new int[a.length]; // array declaration and definition

        carry = HACarry(a[0], b[0]); // as 0th index is always 0
        sout[0] = HASum(a[0], b[0]); // as 0th index is always 0

        // int j =0;
        for (int i = 1; i < a.length; i++) { // from index 1-14 gets value by this forloop
            sout[i] = FASum(a[i], b[i], carry);
            carry = FACarry(a[i], b[i], carry);
        }

        return sout;
    }

    public static int[] Inc16(int in[]) {

        int[] increment = new int[16];
        increment[0] = 1; // the second input should be true so assigned 1

        return Add16(in, increment);
    }
}
