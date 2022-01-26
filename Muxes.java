public class Muxes {
    public static int[] Dmux(int in,int sel,int out[]) {
        int na = Gates.Not(sel);
        int a = Gates.And(in, na);
        int b = Gates.And(in, sel);
        out = new int[]{a,b};
        return out;
    }
    public static int Mux(int a,int b,int sel) {
        int s1 = Gates.Not(sel);
        int out1 = Gates.And(s1, a);
        int out2 = Gates.And(sel, b);
       return Gates.Nand(out1, out2);    
    }
    public static int[] Mux16(int a[],int b[],int sel,int sum[]) {
        for (int i = 0; i < a.length; i++) {
            sum[i] = Muxes.Mux(a[i], b[i], sel);
            
        }
        return sum;
    }
}
