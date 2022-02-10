public class Gates {

    public static int Nand(int a, int b) {

        if (a * b == 1) {
            return 0;
        }

        else {
            return 1;
        }
    }

    public static int And(int a, int b) {

        return Nand(Nand(a, b), Nand(a, b));
    }

    public static int Not(int a) {
        return Nand(a, a);

    }

    public static int Or(int a, int b) {
        return Nand(Nand(a, a), Nand(b, b));
    }

    public static int Xor(int a, int b) {
        int c = Nand(a, Nand(a, b));
        int d = Nand(b, Nand(a, b));
        return Nand(c, d);
    }

    public static int XNOR(int a, int b) {
        int c = Nand(a, a);
        int d = Nand(b, b);
        int o = Nand(c, d);
        return Nand(o, Nand(a, b));

    }

}