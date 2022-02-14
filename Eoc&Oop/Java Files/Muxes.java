public class Muxes extends Gate16 {                         //?This extends Gate16 and itself is a child class
    
    public static int Mux(int a, int b, int sel) {          //!method - which gets input when needed
        int ns = Not(sel);                                  
        int out1 = And(ns, a);
        int out2 = And(sel, b);

        return Or(out1, out2);
    }

    public static int[] Dmux(int in, int sel) {             //!method - we made the method as array cuz the out is as array

        int na = Not(sel);
        int a = And(in, na);
        int b = And(in, sel);
        int[] out = new int[] { a, b };

        return out;
    }

    public static int[] Mux16(int[] a, int[] b, int sel) {  //!method

        int[] out = new int[16];

        for (int i = 15; i >= 0; i = i - 1) {
            out[i] = Mux(a[i], b[i], sel);                  //for loop to print array elements
        }

        return out;
    }

    public static int[] Mux4Way16(int[] a, int[] b, int[] c, int[] d, int[] sel) {  //!method

        int[] ab = Mux16(a, b, sel[0]);                     // 2 different variables just to make it look simple
        int[] cd = Mux16(c, d, sel[0]);

        return Mux16(ab, cd, sel[1]);
    }

    public static int[] Mux8Way16(int[] a, int[] b, int[] c, int[] d, int[] e, int[] f, int[] g, int[] h, int[] sel) {    //!method

        int[] sels = { sel[0], sel[1] };                    //array cuz 2 selection lines are req in mu8way16
        int[] c1 = Mux4Way16(a, b, c, d, sels);
        int[] c2 = Mux4Way16(e, f, g, h, sels);

        return Mux16(c1, c2, sel[2]);
    }
}