public class Gate16 {
    public static int[] Nand16(int a[],int b[], int c[]) {
        a = new int[16];
        b = new int[16];
        c = new int[16];
        for (int i = 0; i < c.length; i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }
    public static int[] And16(int a[],int b[],int c[]) {
        return Gate16.Nand16(Gate16.Nand16(a, b, c),c,c);
    }
    public static int[ ] Not16(int a[],int b[],int c[]) {
        return Gate16.Nand16(a, b, c);
    }
    public static int[] Or16(int a[],int b[],int c[]) {
        int aa[] =Gate16.Nand16(a, a, c);
        int bb[] =Gate16.Nand16(b, b, c);
        int C[] = Gate16.Nand16(aa, bb, c);
        return C;
    }
    
}
