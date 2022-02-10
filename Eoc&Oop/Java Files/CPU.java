public class CPU {
	static Register aRegister = new Register();
	static Register dRegister = new Register();
    static int[] x = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	static int[] y = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
public static int[][] cpu(int[] inM, int[] instruction, int reset){
	

/*
		Mux16(a = false, b = instruction, sel = instruction[15],		out[0] = cJGT,
		out[1] = cJEQ,
		out[2] = cJLT,
		out[3] = DestM, out[3] = writeM,
		out[4] = DestD,
		out[5] = DestA,
		out[6] = ALUno,
		out[7] = ALUf,
		out[8] = ALUny,
		out[9] = ALUzy,
		out[10] = ALUnx,
		out[11] = ALUzx,
		out[12] = AorM,
		out[15] = Type);
*/

	int[] flse = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	int[] muxOUT = Muxes.Mux16(flse, instruction, instruction[15]);	
	int cJGT = muxOUT[0];
	int cJEQ = muxOUT[1];
	int cJLT = muxOUT[2];
	int DestM = muxOUT[3];
	int writeM = muxOUT[3];
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

//		ALU(x = x, y = y, zx = ALUzx, zy = ALUzy, nx = ALUnx, ny = ALUny, f = ALUf, no = ALUno, out = outM, out = ALUout, zr = zr, ng = ng);
	
	ALU.Calculation(x,y,ALUzx,ALUzy,ALUnx,ALUny,ALUf,ALUno);
	
	int[] ALUout = ALU.getoutput();
	//TODO: FIX ALU
	int[] outM = ALU.getoutput();
	int zr = ALU.getZr();
	int ng = ALU.getNg();


/*		Or(a = zr, b = ng, out = notpos);
		Not(in = notpos, out = pos); */

		int notpos = Gates.Or(zr,ng);
		int pos = Gates.Not(notpos);

/*

		//A register logic
		Mux16(a = instruction, b = ALUout, sel = Type, out = A);
		Not(in = Type, out = notType);
		Or(a = notType, b = DestA, out = loadA);
		ARegister(in = A, load = loadA, out = AReg, out[0..14] = addressM);
		Mux16(a = AReg, b = inM, sel = AorM, out = y);

*/

	int[] A = Muxes.Mux16(instruction, ALUout, Type);
	int notType = Gates.Not(Type);
	int loadA = Gates.Or(notType, DestA);
	//TODO: ARegister
	int[] areg = aRegister.Reg(A,loadA);
	int[] addressM = new int[15];
	for (int i = 0; i < 15; i++){
  		addressM[i] = areg[i];
	}
	y = Muxes.Mux16(areg, inM, AorM);
	
/*
DRegister(in = ALUout, load = DestD, out = x);
*/

//TODO: DRegister
	x = dRegister.Reg(ALUout, DestD);


/*

		//Jump Logic
		And(a = cJEQ, b = zr, out = JEQ);
		And(a = cJLT, b = ng, out = JLT);
		And(a = cJGT, b = pos, out = JGT);
		Or(a = JEQ, b = JLT, out = JLE);
		Or(a = JLE, b = JGT, out = jump);
		PC(in = AReg, load = jump, inc = true, reset = reset, out[0..14] = PC, out[15] = false);
*/

	int JEQ = Gates.And(cJEQ, zr);
	int JLT = Gates.And(cJLT, ng);
	int JGT = Gates.And(cJGT, pos);
	int JLE = Gates.Or(JEQ, JLT);
	int jump = Gates.Or(JLE, JGT);
	//TODO: PC
	int truee = 1;
	int[] pcout = new int[16];
	pcout = ProgramCounter.pc(areg, truee, jump, reset);
	pcout[15] = 0;

	int[][] out = {outM, {writeM}, addressM, pcout};

	return out;
}
}
