public class DALU {

    public static int[][] alu16(int[] x, int[] y, int zx, int nx, int zy, int ny, int f, int no) {
        // Zero x y
        int[] zerosForFalse = new int[16];
        int[] x1 = Muxes.Mux16(x, zerosForFalse, zx);
        int[] y1 = Muxes.Mux16(y, zerosForFalse, zy);
        // not x,y
        int[] x2 = Gate16.Not16(x1);
        int[] x3 = Muxes.Mux16(x1, x2, nx);
        int[] y2 = Gate16.Not16(y1);
        int[] y3 = Muxes.Mux16(y1, y2, ny);

        // f part
        int[] f0 = Gate16.And16(x3, y3);
        int[] f1 = Gate16.Add16(x3, y3);
        int[] fo = Muxes.Mux16(f0, f1, f);

        // not f part
        int[] notf = Gate16.Not16(fo);
        int[] outputALU = Muxes.Mux16(fo, notf, no);

        int[] zr = { 0 };
        for (int i = 0; i < 16; i++) {
            if (outputALU[i] == 1)
                ;
            zr[0] = 1;
        }
        int[] tru = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        int[] temp = Gate16.And16(outputALU, tru);
        int[] ng = { temp[0] };

        int[][] output = { outputALU, zr, ng };
        return output;
    }

}