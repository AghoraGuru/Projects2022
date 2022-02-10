public class Gate16 {

    public static int[] Nand16(int[] a, int[] b) {

        int[] c = new int[16];

        for (int i = 15; i >= 0; i = i - 1) {
            c[i] = Gates.Nand(a[i], b[i]);
        }

        return c;
    }

    public static int[] And16(int[] a, int[] b) {

        return Nand16(Nand16(a, b), Nand16(a, b));
    }

    public static int[] Not16(int[] in) {

        return Nand16(in, in);
    }

    public static int[] Or16(int[] a, int[] b) {

        return Nand16(Nand16(a, a), Nand16(b, b));
    }

    public static int Or8Way(int[] in) {

        for (int i = 1; i < 8; i = i + 2) {
            if (Gates.Or(in[i], in[i - 1]) == 1) {
                return 1;
            }
        }

        return 0;
    }

    public static int Or16Way(int in[]) {

        for (int i = 1; i < 16; i = i + 2) {
            if (Gates.Or(in[i], in[i - 1]) == 1) {
                return 1;
            }
        }

        return 0;
    }

    public static int[] Add16(int a[], int b[]) {

        int carry;
        int[] sout = new int[a.length];

        carry = Adders.HACarry(a[0], b[0]);
        sout[0] = Adders.HASum(a[0], b[0]);

        // int j =0;
        for (int i = 1; i < a.length; i++) {
            sout[i] = Adders.FASum(a[i], b[i], carry);
            carry = Adders.FACarry(a[i], b[i], carry);
        }

        return sout;
    }
}