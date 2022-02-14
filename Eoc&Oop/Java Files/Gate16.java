public class Gate16 extends Gates { // ?Gate16 extends Gate(SuperClass) and becomes child class

    /*
     * Again we made NAND16 and used NAND16 to make other gates .
     * array is declared and assigns nand of a&b to each index
     */
    public static int[] Nand16(int[] a, int[] b) { // !Method

        int[] c = new int[16];

        for (int i = 15; i >= 0; i = i - 1) {
            c[i] = Nand(a[i], b[i]);
        }

        return c;
    }
    // Same implementation as Basic AND

    public static int[] And16(int[] a, int[] b) { // !Method

        return Nand16(Nand16(a, b), Nand16(a, b));
    }

    // Same as basic NOT

    public static int[] Not16(int[] in) { // !method

        return Nand16(in, in);
    }
    // same as basic OR

    public static int[] Or16(int[] a, int[] b) {

        return Nand16(Nand16(a, a), Nand16(b, b));
    }
    // made an array with 8 width and and each indices have OR gate with it

    public static int Or8Way(int[] in) { // !method

        for (int i = 1; i < 8; i = i + 2) {
            if (Or(in[i], in[i - 1]) == 1) {
                return 1;
            }
        }

        return 0;
    }
    // same as OR8Way but with 16 as width

    public static int Or16Way(int in[]) { // !method

        for (int i = 1; i < 16; i = i + 2) {
            if (Or(in[i], in[i - 1]) == 1) {
                return 1;
            }
        }

        return 0;
    }

}
