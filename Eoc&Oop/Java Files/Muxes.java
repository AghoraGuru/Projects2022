public class Muxes {
    public static int[] Dmux(int in, int sel) {
        int[] out;
        int na = Gates.Not(sel);
        int a = Gates.And(in, na);
        int b = Gates.And(in, sel);
        out = new int[] { a, b };
        return out;
    }

    public static int Mux(int a, int b, int sel) {
        int s1 = Gates.Not(sel);
        int out1 = Gates.And(s1, a);
        int out2 = Gates.And(sel, b);
        return Gates.Or(out1, out2);
    }

    public static int[] Mux16(int a[], int b[], int sel) {
        int[] out = new int[16];
        for (int i = 15; i >= 0; i = i - 1) {
            out[i] = Muxes.Mux(a[i], b[i], sel);
        }
        return out;
    }

    public static int[] Mux4Way16(int a[], int b[], int c[], int d[], int[] sel) {
        int[] ab = Muxes.Mux16(a, b, sel[0]);
        int[] cd = Muxes.Mux16(c, d, sel[0]);
        return Muxes.Mux16(ab, cd, sel[1]);
    }

    public static int[] Mux8Way16(int a[], int b[], int c[], int d[], int e[], int f[], int g[], int h[], int sel[]) {
        int[] c1 = Muxes.Mux4Way16(a, b, c, d, sel[0], sel[1]);
        int[] c2 = Muxes.Mux4Way16(e, f, g, h, sel[0], sel[1]);
        return Muxes.Mux16(c1, c2, sel[2]);
    }

    private static int[] Mux4Way16(int[] a, int[] b, int[] c, int[] d, int i, int j) {
        return null;
    }
}