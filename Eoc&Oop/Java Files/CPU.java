public class CPU extends ProgramCounter {
    // static Register aRegister = new Register();
    // static Register dRegister = new Register();
    static int[] x = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };              //to start of x is 0
    static int[] y = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    static int[] outM = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    static int writeM;
    static int[] addressM = new int[15];
    static int[] pcout = new int[16];


    public static void cpu(int[] inM, int[] instruction, int reset) {

        int[] flse = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        int[] muxOUT = Mux16(flse, instruction, instruction[15]);
        int cJGT = muxOUT[0];
        int cJEQ = muxOUT[1];
        int cJLT = muxOUT[2];
        writeM = muxOUT[3];
        int DestD = muxOUT[4];
        int DestA = muxOUT[5];
        int ALUno = muxOUT[6];
        int ALUf = muxOUT[7];
        int ALUny = muxOUT[8];
        int ALUzy = muxOUT[9];
        int ALUnx = muxOUT[10];
        int ALUzx = muxOUT[11];
        int AorM = muxOUT[12];
        int Type = muxOUT[15];

        // ALU(x = x, y = y, zx = ALUzx, zy = ALUzy, nx = ALUnx, ny = ALUny, f = ALUf,
        // no = ALUno, out = outM, out = outM, zr = zr, ng = ng);
        
        // ALU
        calculation(x, y, ALUzx, ALUzy, ALUnx, ALUny, ALUf, ALUno);

        outM = getOutput();
        int zr = getZr();
        int ng = getNg();

        int notpos = Or(zr, ng);
        int pos = Not(notpos);

        int[] A = Mux16(instruction, outM, Type);
        int notType = Not(Type);
        int loadA = Or(notType, DestA);

        //ARegister                     
        int[] areg = new int[16];                           //as Areg is just reg with AdressM as output
        areg = Register.Reg(A, loadA);
        for (int i = 0; i < 15; i++) {
            addressM[i] = areg[i];
        }
        y = Mux16(areg, inM, AorM);

        //DRegister
        x = Register.Reg(outM, DestD);

        int JEQ = And(cJEQ, zr);
        int JLT = And(cJLT, ng);
        int JGT = And(cJGT, pos);
        int JLE = Or(JEQ, JLT);
        int jump = Or(JLE, JGT);
        //PC
        int truee = 1;                                     //true is reserved keyword
        pcout = pc(areg, truee, jump, reset);              //as inc is true for pc
        pcout[15] = 0;                                     //15th bit of pc out is false

    }

    public static int[] getOutM() {    //todo (not todo) : This is the OutM we will get if we use getOutM 
     
        return outM;
    }

    public static int getWriteM() {    //!This is the getWriteM we will get if we use getWriteM 
     
        return writeM;
    }

    public static int[] getAddress() { //This is the getAddress we will get if we use getAddress 
     
        return addressM;
    }

    public static int[] getPC() {     //?This is the getPC we will get if we use getPC 

        return pcout;
    }
}
