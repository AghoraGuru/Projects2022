public class Gate16 {
    public static int[] Nand16(int a[],int b[]) {
        int[] c = new int[16];
        a = new int[16];
        b = new int[16];
        
        for (int i = 15; i >=0; i=i-1) {
            c[i] = Gates.Nand(a[i], b[i]);
        }
        return c;
    }
    public static int[] And16(int a[],int b[]) {
        return Nand16(Nand16(a, b),Nand16(a,b));
    }
    public static int[ ] Not16(int in[]) {
        return Nand16(in, in);
    }
    public static int[] Or16(int a[],int b[],int c[]) {
        int aa[] =Nand16(a, a);
        int bb[] =Nand16(b, b);
        int C[] = Nand16(aa, bb);
        return C;
    }
    public static int Or8Way(int in[]) {
        int p,q,r,s,pq,rs;
        p = Gates.Or(in[0], in[1]);
        q = Gates.Or(in[2], in[3]);
        r = Gates.Or(in[4], in[5]);
        s = Gates.Or(in[6], in[7]);
        pq = Gates.Or(p, q);
        rs = Gates.Or(r, s);
        return Gates.Or(pq, rs);
    }
    public static int Or16Way(int in[]) {
      
       int x = 0;
       for (int j = 15; j >=0; j=j-1) {
          if (in[j]==1) {
              x=1;
          }
        }
        return x;
    }
    public static int[] Add16(int a[],int b[]) {
       
        int [] cout = new int[16];
        cout[0] = Adders.HACarry(a[0], b[0]);
        int[] sout = new int[a.length];
        sout[0] = Adders.HASum(a[0], b[0]);
        int j =0;
        for (int i = 0; i < a.length; i++){
            if(i==0){
                 j =0;
            }
            else{
                j = i-1;
            }
            sout[i] = Adders.FASum(a[i], b[i], cout[j]);
            cout[i] = Adders.FACarry(a[i], b[i], cout[j]);
        }
        
        return sout;
    }
}
